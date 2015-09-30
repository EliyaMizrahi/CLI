package controller;

/**
 * The FileSize program implements an application that realize the methods from CommonCommand.
 * This method apply the fileSize method that display the size of maze in the file.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class FileSize extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public FileSize(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tampArr = command.split(" ");
		if (tampArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tampArr[1];
			controller.fileSize(nameMaze);
		}
	}
}
