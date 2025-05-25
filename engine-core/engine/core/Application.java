package engine.core;

import engine.core.window.Window;

public interface Application {
	public void init(Window window);
	
	public void update(Window window);
	
	public void input(Window window);
}
