package controller;

/**
 * The Command is an Interface class that has one method that 
 * will be implement differently in each class.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 22-09-2015
 */
public interface Command {
	public void doCommand(String command);

}
