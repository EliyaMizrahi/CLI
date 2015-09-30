package controller;

import model.Model;
import view.View;

/**
 * The CommonController program implements an application that organize all
 * the common methods of command methods and implement the methods of the Command interface.
 * CommonController consist from: 1. View 2. Model
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-09-2015
 */
public abstract class CommonController implements Controller {
	protected View view;
	protected Model model;

	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public CommonController(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public abstract void generate(String nameMaze, int y, int x, int z);
	public abstract void displayCrossSectionBy(String by, String nameMaze, int index);
	public abstract void saveMaze(String nameMaze, String fileName);
	public abstract void loadMaze(String fileName, String nameMaze);
	public abstract void mazeSize(String nameMaze);
	public abstract void fileSize(String nameMaze);
	public abstract void solveMaze(String nameMaze, String nameAlgorithms);
	public abstract void displaySolution(String nameMaze);
	public abstract void exit();
	
	/**
	 * This method is used to get a view object.
	 * @return View
	 */
	public View getView() {
		return view;
	}

	/**
	 * This method is used to set a view object.
	 * @param view
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * This method is used to get a model object.
	 * @return Model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * This method is used to set a model object.
	 * @param model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * This method is used to apply the method displayArr by View.
	 * @param arr
	 */
	@Override
	public void displayArr(String[] arr) {
		this.view.displayArr(arr);
	}

	/**
	 * This method is used to apply the method display by View.
	 * @param message
	 */
	@Override
	public void display(String message) {
		this.view.display(message);
	}

	/**
	 * This method is used to apply the method displayByteArr by View.
	 * @param b
	 */
	@Override
	public void displayByteArr(byte[] b) {
		view.displayByteArr(b);
	}

	/**
	 * This method is used to apply the method displayMaze by View.
	 * @param nameMaze
	 */
	@Override
	public void displayMaze(String nameMaze) {
		this.model.displayMaze(nameMaze);
	}

}
