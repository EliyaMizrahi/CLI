package controller;

/**
 * The Solve program implements an application that realize the methods from CommonCommand.
 * This method apply the solveMaze method that solve the maze by some algorithm.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Solve extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Solve(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tempArr[0];
			String nameAlgorithms = tempArr[1];
			controller.solveMaze(nameMaze, nameAlgorithms);
		}
	}
}
