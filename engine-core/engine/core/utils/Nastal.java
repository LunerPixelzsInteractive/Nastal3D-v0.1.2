package engine.core.utils;

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
	}
	
	public void start() {
		window.create();
		
		render = new Render();
		scene = new Scene();
		app.init(window, scene, render);
		
		while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
				
				app.update(window, scene);
				
				render.render(window, scene);
				window.swapBuffers();
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
