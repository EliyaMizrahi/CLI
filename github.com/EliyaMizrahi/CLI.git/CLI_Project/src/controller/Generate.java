package controller;

/**
 * The Generate program implements an application that realize the methods from CommonCommand.
 * This method apply the generate method that create maze3d by Recursive Backtracker algorithm
 * and check the command theat we get from the client.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-9-2015
 *
 */
public class Generate extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Generate(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length >5) {
			if ((tempArr[0].equals("3d") || tempArr[0].equals("3D"))) {
				if ((tempArr[1].equals("maze") || tempArr[1].equals("Maze"))) {
					int y = 0, x = 0, z = 0;
					try {
						y = Integer.parseInt(tempArr[3]);
						x = Integer.parseInt(tempArr[4]);
						z = Integer.parseInt(tempArr[5]);
						controller.generate(tempArr[2], y, x, z);
					} catch (NumberFormatException e) {
						controller.display("Invalid parameters");
					}
				}
			}
		} else {
			controller.display("Invalid length");
		}
	}
}
