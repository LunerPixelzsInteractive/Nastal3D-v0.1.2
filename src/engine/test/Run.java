package engine.test;

import org.lwjgl.glfw.GLFW;

import engine.core.Window;

public class Run {

	public static final int WIDTH = 1270, HEIGHT = 720, FPS = 60;
	public static Window window = new Window(WIDTH, HEIGHT, FPS, "v0.1.2");
	
	public static void main(String[] args) {
		window.create();
		window.setBackgroundColor(0.0f, 0.0f, 1.0f); //Background color:)
		
		//Why, the problem all along was I didn't a while loop. I put an if loop
		//life is just so unfair and rigged
		while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
				
				if (window.isKeyDown(GLFW.GLFW_KEY_B)) System.out.println("Hello");
			}
		}
		window.stop();
	}
}
