package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.MyController;
import model.MyModel;
import view.MyView;

/**
 * The Run program implements an application that contains the main method.
 * The main method start the whole CLI project.
 * @author Mor Mordoch & Eliya Mizrahi 
 * @version 1.0
 * @since 22-09-2015
 */
public class Run {

	public static void main(String[] args){
		
		MyModel myModel= new MyModel();
		MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
		MyController myController= new MyController(myView, myModel);
		
		myModel.setController(myController);
		myView.setController(myController);
		myView.start();
	}

}
