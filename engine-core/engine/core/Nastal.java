package engine.core;

import engine.core.app.Application;
import engine.core.render.Render;
import engine.core.scene.Scene;
import engine.core.window.Window;

public class Nastal {
	private final Window window;
	private Render render;
	private Scene scene;
	private Application app;
	
	public Nastal(String title, int width, int height, int fps, Application app) {
		this.app = app;
		window = new Window(width, height, fps, title);
		render = new Render();
		scene = new Scene();
		app.init(window, scene);
	}
	
	public void start() {
		window.create();
		
		while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
				
				app.update(window, scene);
			}
		}
		this.cleanup();
	}
	
	private void cleanup() {
		window.stop();
		render.cleanup();
		scene.cleanup();
	}
}
