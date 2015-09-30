package controller;

/**
 * The Controller is an Interface class that has the following methods.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-09-2015
 */
public interface Controller {

	public void displayArr(String[] arr);
	public void display(String nameMaze);
	public void displayByteArr(byte[] b);
	public void displayMaze(String message);
	public void generate(String nameMaze, int y, int x, int z);
	public void displayCrossSectionBy(String by, String nameMaze, int index);
	public void saveMaze(String nameMaze, String fileName);
	public void loadMaze(String fileName, String nameMaze);
	public void mazeSize(String nameMaze);
	public void fileSize(String nameMaze);
	public void solveMaze(String nameMaze, String nameAlgorithms);
	public void displaySolution(String nameMaze);
	public void exit();


}
