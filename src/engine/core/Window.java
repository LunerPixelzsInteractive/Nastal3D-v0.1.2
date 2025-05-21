package engine.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Window {
	private int width, height;
	private String title;
	
	private boolean closed;
	private double fps_cap, time, processedTime = 0;
	
	private long window;
	
	public Window(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public void create() {
		
		closed = false; //I want to cry TODO: Make the window stop closing
		
		if(!GLFW.glfwInit()) {
			System.err.println("GLFW can not init");
		}
		
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		
		if(window == 0) {
			System.err.println("Window could not create");
		}
		
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();

		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
		
		GLFW.glfwShowWindow(window);
		
		time = getTime();
	}
	
	public void update() {
		GLFW.glfwPollEvents();
		
		GLFW.glfwSwapBuffers(window);
	}
	
	public double getTime() {
		return (double) System.nanoTime() / (double) 1000000000;
	}
	
	public boolean closed() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public void stop() {
		GLFW.glfwTerminate();
		closed = true;
	}
	
	public boolean isUpdating() {
		if (!closed) {
			double nextTime = getTime();
			double passedTime = nextTime - time;
			processedTime += passedTime;
			time = nextTime;
			
			while (processedTime > 1.0/fps_cap) {
				processedTime -= 1.0/fps_cap;
				return true;
			}
		}
		return false;
	}
}
