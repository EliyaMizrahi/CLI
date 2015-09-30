package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import controller.Command;

/**
 * The CLI program implements an application that implement a user interface of
 * the command line. CLI consist from: 1. BufferReader 2. PrintWriter 3. HashMap
 * .
 * 
 * @author Mor Mordoch & Eliya Mizrahi
 * @version 1.0
 * @since 20-9-2015
 *
 */
public class CLI {
	public static final int FIRST_ORGAN = 0;

	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> commandMap;
	private ExecutorService threadPool;

	/**
	 * Constructor
	 * 
	 * @param in
	 * @param out
	 * @param commandMap
	 */
	public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> commandMap) {
		this.in = in;
		this.out = out;
		this.commandMap = commandMap;
		this.threadPool = Executors.newCachedThreadPool();
	}

	/**
	 * This method is use to get the HashMap that include String and Command.
	 * @return HashMap
	 */
	public HashMap<String, Command> getHash() {
		return commandMap;
	}

	/**
	 * This method is use to set the HashMap
	 * @param commandMap
	 */
	public void setHash(HashMap<String, Command> commandMap) {
		this.commandMap = commandMap;
	}

	/**
	 * This method is use to begin the project. This method will run until we
	 * get "exit"
	 */
	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					out.println("Please enter command");
					out.flush();
					String line = in.readLine();
					Command command;
					while (!(line.equals("exit"))) {
						command = commandMap.get(line.split(" ")[0]);
						if (command != null) {
							if (line.split(" ").length > 1) {
								command.doCommand(line.substring(line.indexOf(' ') + 1));
								try {
									threadPool.awaitTermination(3, TimeUnit.SECONDS);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							} else {
								out.println("Invalid parameters");
								out.flush();
							}
						} else {
							out.println("The command does not exist in the system, please insert a new command");
							out.flush();
						}
						out.println("Please enter a new command");
						out.flush();
						line = in.readLine();
					}

					commandMap.get("exit").doCommand("");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
