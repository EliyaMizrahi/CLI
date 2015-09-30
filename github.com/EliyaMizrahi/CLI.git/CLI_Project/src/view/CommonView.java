package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.activation.CommandMap;

import controller.Command;
import controller.Controller;

/**
 * The CommonView program implements an application that organize all
 * the common methods of view methods and implement the methods of the View interface.
 * CommonView consist from: 1. Controller 2. BufferReasder 3. PrintWriter
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 20-09-2015
 */

public abstract class CommonView implements View{
	
	protected Controller controller;
	protected BufferedReader in;
	protected PrintWriter out;
	
	public CommonView(BufferedReader in, PrintWriter out) {
		this.in=in;
		this.out=out;		
	}
	
	public abstract void start();
	public abstract void displayArr(String[] string);
	public abstract void display(String message);	
	public abstract void displayByteArr(byte[] b);
	public abstract void setCommand(HashMap<String, Command> commandMap);
	public abstract void exit();

	/**
	 * 	This method is use to get the Controller
	 * @return controller
	 */
	public Controller getController() {
		return controller;
	}
	

	/**
	 * This method is use to set the Controller
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}


}
