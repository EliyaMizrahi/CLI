package controller;

import java.io.File;

/**
 * The Dir program implements an application that realize the methods from CommonCommand.
 * This method display whole files and folders in some path.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Dir extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Dir(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		if (command == null) {
			controller.display("Invalid parameters");
		} else {
			try {
				File file = new File(command);
				if (file.list().length == 0) {
					controller.display("The file is not exist");
				} else {
					controller.displayArr(file.list());
				}
			} catch (NullPointerException e) {
				controller.display("Invalid path");
			}
		}
	}
}