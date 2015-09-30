package controller;

/**
 * The CommonCommand program implements an application that organize all
 * the common methods of command methods and implement the methods of the Command interface.
 * CommonCommand consist from: 1. Controller
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-09-2015
 */

public abstract class CommonCommand implements Command{
	protected Controller controller;
	
	/**
	 * Constructor
	 * @param controller
	 */
	public CommonCommand(Controller controller) {
		this.controller=controller;
	}
	
	public abstract void doCommand(String command);
		

}
