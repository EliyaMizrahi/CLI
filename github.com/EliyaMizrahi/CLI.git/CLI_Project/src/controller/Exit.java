package controller;

/**
 * The Exit program implements an application that realize the methods from CommonCommand.
 * This method apply the exit method close the project orderly.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Exit extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Exit(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		controller.exit();
	}

}
