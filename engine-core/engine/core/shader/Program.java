package engine.core.shader;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import engine.core.utils.FileReader;

public class Program {
	
	private final int programID;
	
	public Program(List<ShaderModuleData> shaderModuleDataList) {
		programID = GL20.glCreateProgram();
		
		if(programID == 0) System.err.println("ERROR: Program could not be created");
		
		List<Integer> shaderModules = new ArrayList<>();
        shaderModuleDataList.forEach(s -> shaderModules.add(createShader(FileReader.fileReader(s.shaderFile), s.shaderType)));

        link(shaderModules);
	}
	
	public void bind() {
		GL20.glUseProgram(programID);
	}
	
	public void cleanup() {
		unbind();
		if(programID != 0) GL20.glDeleteProgram(programID);
	}
	
	//TODO: Clean up this code - 5/26/25
	protected int createShader(String source, int type) {
		int id = GL20.glCreateShader(type);

		if(id == 0) System.err.println("ERROR: shader did not create or something went wrong:" + type);
		
		GL20.glShaderSource(id, source);
		GL20.glCompileShader(id);
		
		//I know this line of code is to long, but I was to lazy to use {}
		if(GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) == 0) System.err.println("ERROR: something went wrong compiling shader:" + GL20.glGetShaderSource(id, 1024)); // the i in glGetShaderi means integer
		
		GL20.glAttachShader(programID, id);
		
		return id;
	}
	
	public int getProgram() {
		return programID;
	}
	
	public void link(List<Integer> shaderModules) {
	    GL20.glLinkProgram(programID);

	    if (GL20.glGetProgrami(programID, GL20.GL_LINK_STATUS) == GL11.GL_FALSE) {
	        System.err.println("ERROR linking program:\n" + GL20.glGetProgramInfoLog(programID));
	    }

	    shaderModules.forEach(s -> GL20.glDetachShader(programID, s));
	    shaderModules.forEach(GL30::glDeleteShader);
	}
	
	public void validate() {
		GL20.glValidateProgram(programID);
		//TODO: Add error handling - 5/26/25- to lazy to implement right now
	}
	
	public void unbind() {
		GL20.glUseProgram(0);
	}
	
	public record ShaderModuleData(String shaderFile, int shaderType) {
    }
}
