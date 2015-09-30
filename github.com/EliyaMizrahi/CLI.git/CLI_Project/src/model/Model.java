package model;

/**
 * The Model is an Interface class that has the following methods.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 20-09-2015
 */
public interface Model {
	 public void generate(String nameMaze, int y, int x, int z);
	 public void displayMaze(String nameMaze);
	 public void displayCrossSectionBy(String by, String nameMaze, int index);
	 public void saveMaze(String nameMaze, String fileName);
	 public void loadMaze(String fileName, String nameMaze);
	 public void mazeSize(String nameMaze);
	 public void fileSize(String nameMaze);
	 public void solveMaze(String nameMaze, String nameAlgorithms);
	 public void displaySolution(String nameMaze);
	 public void exit();
}
