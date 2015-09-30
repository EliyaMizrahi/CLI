package controller;

/**
 * The Save program implements an application that realize the methods from CommonCommand.
 * This method apply the saveMaze method that save the maze into a file.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Save extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Save(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tempArr[0];
			String fileName = tempArr[1];
			controller.saveMaze(nameMaze, fileName);
		}
	}
}
