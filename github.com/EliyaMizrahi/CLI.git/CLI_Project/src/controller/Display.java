package controller;


/**
 * The Display program implements an application that realize the methods from CommonCommand.
 * This method apply the relevant application according to command.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Display extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Display(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		String nameMaze;
		if (tempArr.length >5) {
			if (tempArr[0].equals("cross")) {
				int index = 0;
				try {
					index = Integer.parseInt(tempArr[4]);
				} catch (NumberFormatException e) {
					controller.display("Invalid parameters");
				}
				String by = tempArr[3];
				nameMaze = tempArr[5];
				controller.displayCrossSectionBy(by, nameMaze, index);
			}
		} else if (tempArr.length >1) {
			if (tempArr[0].equals("solution")) {
				nameMaze = tempArr[1];
				controller.displaySolution(nameMaze);
			}
		} else {
			nameMaze = tempArr[0];
			controller.displayMaze(nameMaze);
		}
	}
}
