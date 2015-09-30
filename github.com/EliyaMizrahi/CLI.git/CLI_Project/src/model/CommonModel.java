package model;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

/**
 * The CommonModel program implements an application that organize all
 * the common methods of model methods and implement the methods of the Model interface.
 * CommonModel consist from: 1. Controller 2. HashMap- for maze 3. HashMap- for solution 4.ExecutorService
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-09-2015
 */

public abstract class CommonModel implements Model{
	
	protected Controller controller;
	protected HashMap<String, Maze3d> hashMaze;
	protected HashMap<String, Solution<Position>> hashSolution;
	protected ExecutorService threadPool;
	
	/**
	 * Constructor
	 */
	public CommonModel() {
		this.hashMaze=new HashMap<String, Maze3d>();
		this.hashSolution=new HashMap<String, Solution<Position>>();
		this.threadPool=Executors.newCachedThreadPool();
	}
	
	public abstract void generate(String nameMaze, int y, int x,int z);
	public abstract void displayMaze(String nameMaze);
	public abstract void displayCrossSectionBy(String by, String nameMaze, int index);
	public abstract void saveMaze(String nameMaze, String fileName);
	public abstract void loadMaze(String fileName, String nameMaze);
	public abstract void mazeSize(String nameMaze);
	public abstract void fileSize(String nameMaze);
	public abstract void solveMaze(String nameMaze, String nameAlgorithms);
	public abstract void displaySolution(String nameMaze);
	public abstract void exit();

	/**
	 * This method is use to get controller.
	 * @returnvController
	 */
	public Controller getController() {
		return controller;
	}
	/**
	 * This method is use to set controller.
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * This method is use to get hashMaze.
	 * @return HashMap
	 */
	public HashMap<String, Maze3d> getHashMaze() {
		return hashMaze;
	}

	/**
	 * This method is use to set hashMaze.
	 * @param hashMaze
	 */
	public void setHashMaze(HashMap<String, Maze3d> hashMaze) {
		this.hashMaze = hashMaze;
	}

	 
}
