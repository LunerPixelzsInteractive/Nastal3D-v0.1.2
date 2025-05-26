package game;

import org.lwjgl.glfw.GLFW;

import engine.core.Mesh.Triangle;
import engine.core.Mesh.Mesh;
import engine.core.app.Application;
import engine.core.render.Render;
import engine.core.scene.Scene;
import engine.core.utils.Nastal;
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
	public void init(Window window, Scene scene, Render render) {
		window.setBackgroundColor(1.0f, 0.3f, 0.1f);
		
		Triangle tri = new Triangle();
		Mesh triangle = new Mesh(tri.getPositions(), 3);
		scene.addMesh("triangle", triangle);
	}

	@Override
	public void update(Window window, Scene scene) {
		if (window.isKeyPressed(GLFW.GLFW_KEY_V)) System.out.println("Engine Version: v0.1.3");
	}

	@Override
	public void input(Window window, Scene scene) {
		
	}

}
