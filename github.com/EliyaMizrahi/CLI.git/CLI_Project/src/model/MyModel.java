package model;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.MazeSearchable;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * The MyModel program implements an application that realize the methods from
 * CommonModel. MyModel consist from StringBuilder.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class MyModel extends CommonModel {
	private StringBuilder sBuild;

	/**
	 * Constructor
	 */
	public MyModel() {
		super();
		this.sBuild = new StringBuilder();
	}

	/**
	 * This method is used to create maze3d by Recursive Backtracker algorithm.
	 * 
	 * @param nameMaze
	 * @param y
	 * @param x
	 * @param z
	 */
	@Override
	public void generate(String nameMaze, int y, int x, int z) {
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				Maze3d myMaze = new MyMaze3dGenerator(y, x, z).generate(y, x, z);
				hashMaze.put(nameMaze, myMaze);
				controller.display("maze " + nameMaze + " is ready");
			}
		});
	}

	/**
	 * This method is used to display maze3d.
	 * @param nameMaze
	 */
	@Override
	public void displayMaze(String nameMaze) {
		Maze3d myMaze = hashMaze.get(nameMaze);
		if (myMaze == null) {
			controller.display("Maze " + nameMaze + "is not exist");
		} else {
			controller.displayByteArr(myMaze.toByteArray());	
		}
	}

	/**
	 * This method is used to get cross section by y / x / z axis.
	 * 
	 * @param by
	 * @param nameMaze
	 * @param index
	 */
	@Override
	public void displayCrossSectionBy(String by, String nameMaze, int index) {
		Maze3d myMaze = hashMaze.get(nameMaze);
		int[][] maze2d = null;
		String printMaze = "";

		if (myMaze == null) {
			controller.display("The maze is not exist");
			return;
		}

		try {
			switch (by) {
			case "Y":
				maze2d = myMaze.getCrossSectionByY(index);
				break;
			case "y":
				maze2d = myMaze.getCrossSectionByY(index);
				break;
			case "X":
				maze2d = myMaze.getCrossSectionByX(index);
				break;
			case "x":
				maze2d = myMaze.getCrossSectionByX(index);
				break;
			case "Z":
				maze2d = myMaze.getCrossSectionByZ(index);
				break;
			case "z":
				maze2d = myMaze.getCrossSectionByZ(index);
				break;
			default:
				controller.display("Invalid parameters");
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			controller.display("Invalid index");
			return;
		}
		for (int i = 0; i < maze2d.length; i++) {
			for (int j = 0; j < maze2d[i].length; j++) {
				printMaze = printMaze + String.valueOf(maze2d[i][j] + " ");
			}
			printMaze = printMaze + "\n";
		}
		controller.display(printMaze);

	}

	/**
	 * This method is use to save the maze into a file.
	 * 
	 * @param nameMaze
	 * @param fileName
	 */
	@Override
	public void saveMaze(String nameMaze, String fileName) {
		Maze3d myMaze = hashMaze.get(nameMaze);
		if (myMaze == null) {
			controller.display("Maze " + nameMaze + " is not exist");
		} else {
			try {
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
				out.write(myMaze.toByteArray());
				out.close();
				controller.display("Maze " + nameMaze + " is saved successfully in the file " + fileName);

			} catch (FileNotFoundException e) {
				controller.display("The " + fileName + " is not exist");
			} catch (IOException e) {
				controller.display("Cannot collapse the " + nameMaze);
			}
		}
	}

	/**
	 * This method is use to load the maze from a file.
	 * 
	 * @param fileName
	 * @param nameMaze
	 */
	@Override
	public void loadMaze(String fileName, String nameMaze) {
		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			byte[] bArr = new byte[34586];
			int numByte = in.read(bArr);
			in.read(bArr);
			in.close();
			byte[] newbArr = new byte[numByte];
			for (int i = 0; i < newbArr.length; i++) {
				newbArr[i] = bArr[i];
			}
			Maze3d myMaze = new Maze3d(bArr);
			hashMaze.put(nameMaze, myMaze);
			controller.display("Maze " + nameMaze + " is loaded from " + fileName + " file");
			in.close();

		} catch (FileNotFoundException e) {
			controller.display("The file " + fileName + " is not found");
		} catch (IOException e) {
			controller.display("There is error with the new maze");
		}
	}

	/**
	 * This method is use to display the size of the maze in memory.
	 * 
	 * @param nameMaze
	 */
	@Override
	public void mazeSize(String nameMaze) {
		Maze3d myMaze = hashMaze.get(nameMaze);
		if (myMaze == null) {
			controller.display("Maze " + nameMaze + " is not exist");
		} else {
			int size = myMaze.getSizeY() * myMaze.getSizeX() * myMaze.getSizeZ() + 36;
			controller.display("The size of " + nameMaze + " is: " + size);
		}
	}

	/**
	 * This method is use to display the size of maze in the file.
	 * @param nameMaze
	 */
	@Override
	public void fileSize(String nameMaze) {
		Maze3d myMaze = hashMaze.get(nameMaze);
		if (myMaze == null) {
			controller.display("Maze " + nameMaze + " is not exist in the file");
		} else {
			ByteArrayOutputStream bOut = new ByteArrayOutputStream();
			MyCompressorOutputStream compOut = new MyCompressorOutputStream(bOut);
			try {
				compOut.write(myMaze.toByteArray());
				controller.display("The size of " + nameMaze + " maze in the file is: " + bOut.size());
			} catch (IOException e) {
				controller.display("Could not write the " + nameMaze + " maze to a file");
			}
		}
	}

	/**
	 * This method is use to solve the maze by some algorithm.
	 * @param nameMaze
	 * @param nameAlgorithms
	 */
	@Override
	public void solveMaze(String nameMaze, String nameAlgorithms) {
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				Maze3d myMaze = hashMaze.get(nameMaze);
				if (myMaze == null) {
					controller.display("Maze " + nameMaze + " is not exist");
				} else {
					Searcher<Position> algorithms;
					Searchable<Position> mazeSearchable = new MazeSearchable(myMaze);
					switch (nameAlgorithms) {
					case "BFS":
						algorithms = new BFS<Position>();
						break;
					case "AirDistance":
						algorithms = new Astar<Position>(new MazeAirDistance());
						break;
					case "ManhattanDistance":
						algorithms = new Astar<Position>(new MazeManhattanDistance());
						break;
					default:
						controller.display("Invalid algorithm");
						return;
					}
					hashSolution.put(nameMaze, algorithms.search(mazeSearchable));
					controller.display("Solution for" + nameMaze + " is ready");
				}
			}
		});
	}

	/**
	 * This method is use to display the solution of chosen algorithm.
	 * 
	 * @param nameMaze
	 */
	@Override
	public void displaySolution(String nameMaze) {
		Solution<Position> mySolution = hashSolution.get(nameMaze);
		if (mySolution == null) {
			controller.display("Solution for " + nameMaze + " is not exist");
		} else {
			Stack<Position> stackSolution = mySolution.getStackState();
			while (!(stackSolution.isEmpty())) {
				sBuild.append(stackSolution.pop());
			}
			controller.display("The solution for " + nameMaze + " is:\n" + sBuild.toString());
		}
	}

	/**
	 * This method is use to close the project orderly.
	 */
	@Override
	public void exit() {
		controller.display("The system is shutting down");
		threadPool.shutdown();
		try {
			while (!(threadPool.awaitTermination(10, TimeUnit.SECONDS)))
				;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
