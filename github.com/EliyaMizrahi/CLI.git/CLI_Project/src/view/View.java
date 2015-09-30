package view;

import java.util.HashMap;
import controller.Command;

/**
 * The View is an Interface class that has following methods.
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 20-09-2015
 */

public interface View {
	 public void start();
	 public void displayArr(String[] arr);
	 public void display(String message);
	 public void displayByteArr(byte[] b);
	 public void setCommand(HashMap<String, Command> commandMap);
	 public void exit();
}
