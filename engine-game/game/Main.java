package game;

import org.lwjgl.glfw.GLFW;

import engine.core.Nastal;
import engine.core.app.Application;
import engine.core.scene.Scene;
import engine.core.window.Window;

public class Main implements Application{
	public static final int WIDTH = 1270, HEIGHT = 720, FPS = 60;
	public static String title = "Debug";
	
	public static void main(String[] args) {
		Main main = new Main();
		Nastal nas = new Nastal(title, WIDTH, HEIGHT, FPS, main); // (title, width, height, frames per second, application)
		nas.start();
	}
	
	@Override
	public void init(Window window, Scene scene) {
		window.setBackgroundColor(0.0f, 0.0f, 1.0f);
	}

	@Override
	public void update(Window window, Scene scene) {
		if (window.isKeyPressed(GLFW.GLFW_KEY_V)) System.out.println("Engine Version: v0.1.3");
	}

	@Override
	public void input(Window window, Scene scene) {
		
	}

}
