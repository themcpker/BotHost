package Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemChecker implements Runnable {

	private Thread t;
	private String threadName = "SystemChecker";
	private boolean shouldRun = false;
	
	@Override
	public void run() {
//		while(shouldRun) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Runtime runtime = Runtime.getRuntime();
	        String cmds[] = {"cmd", "/c", "tasklist"};
	        Process proc = null;
			try {
				proc = runtime.exec(cmds);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        InputStream inputstream = proc.getInputStream();
	        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
	        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
	        String line;
	        try {
			while ((line = bufferedreader.readLine()) != null) {
			       System.out.println(line);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}
	
	public void stop() {
		
	}
	
	public boolean isAlive() {
		return shouldRun;
	}
	
	public void start() {
//		if(!shouldRun) {
//			shouldRun = true;
//		}
		if (t == null) {
			t = new Thread (this, threadName);
			t.start();
		}
	}
	
	

}
