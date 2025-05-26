package engine.core.app;

import engine.core.render.Render;
import engine.core.scene.Scene;
import engine.core.window.Window;

public interface Application {
	public void init(Window window, Scene scene, Render render);
	
	public void update(Window window, Scene scene);
	
	public void input(Window window, Scene scene);
}
