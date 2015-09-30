package controller;

import java.util.HashMap;

import model.Model;
import view.View;

/**
 * The MyController program implements an application that realize the methods
 * from controller. MyController get command from the view and send the command
 * to the model, the model returns his calculation to controller and send it to
 * the view MyController consist from HashMap.
 *
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class MyController extends CommonController {

	private HashMap<String, Command> commandMap;

	/**
	 * Constructor
	 * 
	 * @param v
	 * @param m
	 */
	public MyController(View v, Model m) {
		super(v, m);
		this.commandMap = new HashMap<String, Command>();
		this.commandMap.put("dir", new Dir(this));
		this.commandMap.put("generate", new Generate(this));
		this.commandMap.put("display", new Display(this));
		this.commandMap.put("save", new Save(this));
		this.commandMap.put("load", new Load(this));
		this.commandMap.put("maze", new MazeSize(this));
		this.commandMap.put("file", new FileSize(this));
		this.commandMap.put("solve", new Solve(this));
		this.commandMap.put("exit", new Exit(this));

		view.setCommand(commandMap);
	}

	/**
	 * This method is used to create maze3d by Recursive Backtracker algorithm
	 * according to model that start this method.
	 * 
	 * @param nameMaze
	 * @param y
	 * @param x
	 * @param z
	 */
	@Override
	public void generate(String nameMaze, int y, int x, int z) {
		model.generate(nameMaze, y, x, z);

	}

	/**
	 * This method is used to get cross section by y / x / z axis according to
	 * model that start this method.
	 * 
	 * @param by
	 * @param nameMaze
	 * @param index
	 */
	@Override
	public void displayCrossSectionBy(String by, String nameMaze, int index) {
		model.displayCrossSectionBy(by, nameMaze, index);
	}

	/**
	 * This method is used to save the maze into a file according to model that
	 * start this method.
	 * 
	 * @param nameMaze
	 * @param fileName
	 */
	@Override
	public void saveMaze(String nameMaze, String fileName) {
		model.saveMaze(nameMaze, fileName);
	}

	/**
	 * This method is used to load the maze from a file according to model that
	 * start this method.
	 * 
	 * @param nameMaze
	 * @param fileName
	 */
	@Override
	public void loadMaze(String fileName, String nameMaze) {
		model.loadMaze(fileName, nameMaze);
	}

	/**
	 * This method is used to display the size of the maze in memory according
	 * to model that start this method.
	 * 
	 * @param nameMaze
	 */
	@Override
	public void mazeSize(String nameMaze) {
		model.mazeSize(nameMaze);
	}

	/**
	 * This method is used to display the size of maze in the file according to
	 * model that start this method.
	 * 
	 * @param nameMaze
	 */
	@Override
	public void fileSize(String nameMaze) {
		model.fileSize(nameMaze);
	}

	/**
	 * This method is used to solve the maze by some algorithm according to
	 * model that start this method.
	 * 
	 * @param nameMaze
	 * @param nameAlgorithms
	 */
	@Override
	public void solveMaze(String nameMaze, String nameAlgorithms) {
		model.solveMaze(nameMaze, nameAlgorithms);
	}

	/**
	 * This method is used to display the solution of chosen algorithm according
	 * to model that start this method.
	 * 
	 * @param nameMaze
	 */
	@Override
	public void displaySolution(String nameMaze) {
		model.displaySolution(nameMaze);
	}

	/**
	 * This method is used to close the project orderly according to model and
	 * view that start this method.
	 */
	@Override
	public void exit() {
		model.exit();
		view.exit();

	}

}
