package game;

import engine.core.Application;
import engine.core.Engine;
import engine.core.window.Window;

public class Main implements Application{
	public static final int WIDTH = 1270, HEIGHT = 720, FPS = 60;
	public static String title = "Debug";
	
	public static void main(String[] args) {
		Main main = new Main();
		Engine eng = new Engine(title, WIDTH, HEIGHT, FPS, main);
		eng.start();
	}
	
	@Override
	public void init(Window window) {
		window.setBackgroundColor(1.0f, 0.0f, 0.0f);
	}

	@Override
	public void update(Window window) {
		
	}

	@Override
	public void input(Window window) {
		
	}

}
