package controller;

/**
 * The Load program implements an application that realize the methods from CommonCommand.
 * This method apply the loadMaze method that load a maze from a file.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Load extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Load(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String fileName = tempArr[0];
			String nameMaze = tempArr[1];
			controller.loadMaze(fileName, nameMaze);
		}
	}
}
