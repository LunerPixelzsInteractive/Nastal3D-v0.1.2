package engine.test;

import engine.core.Window;

public class Run {

	public static final int WIDTH = 800, HEIGHT = 600;
	public static Window window = new Window(WIDTH, HEIGHT, "v0.1");
	
	public static void main(String[] args) {
		window.create();
		
		//Why, the problem all along was I didn't a while loop. I put a if loop
		//life is just so unfair and rigged
		while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
			}
		}
		window.stop();
	}
}
