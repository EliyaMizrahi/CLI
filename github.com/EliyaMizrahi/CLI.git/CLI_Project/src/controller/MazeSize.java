package controller;

/**
 * The MazeSize program implements an application that realize the methods from CommonCommand.
 * This method apply the mazeSize method that display the size of the maze in memory.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class MazeSize extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public MazeSize(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tempArr[1];
			controller.mazeSize(nameMaze);
		}
	}
}
