package engine.core.render;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import engine.core.scene.Scene;
import engine.core.window.Window;

public class Render {
	public Render() {
		GL.createCapabilities();
	}
	
	public void cleanup() {
		
	}
	
	public void render(Window window, Scene scene) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
}
