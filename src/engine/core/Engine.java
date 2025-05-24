package engine.core;

import engine.core.window.Window;

public class Engine {
	public final Window window;
	
	public Engine(String title, int width, int height, int fps, Application app) {
		window = new Window(width, height, fps, title);
		app.init(window);
	}
	
	public void start() {
		window.create();
		
		while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
			}
		}
		window.stop();
	}
}
