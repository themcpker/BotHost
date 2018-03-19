package Main;

import gui.Gui;
import Threads.SystemChecker;

public class Main {
	
	public static void main(String[] args) {
		SystemChecker thread = new SystemChecker();
		Gui gui = new Gui();
		System.out.println("Program has started");
		thread.start();
	}
	
	

}
