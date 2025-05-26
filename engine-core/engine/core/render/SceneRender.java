package engine.core.render;

import static org.lwjgl.opengl.GL30.*;

import java.util.ArrayList;
import java.util.List;

import engine.core.scene.Scene;
import engine.core.shader.Program;

public class SceneRender {

    private Program shaderProgram;

    public SceneRender() {
        List<Program.ShaderModuleData> shaderModuleDataList = new ArrayList<>();
        shaderModuleDataList.add(new Program.ShaderModuleData("engine-resources/shaders/shader.vert", GL_VERTEX_SHADER));
        shaderModuleDataList.add(new Program.ShaderModuleData("engine-resources/shaders/shader.frag", GL_FRAGMENT_SHADER));
        shaderProgram = new Program(shaderModuleDataList);
    }

    public void cleanup() {
        shaderProgram.cleanup();
    }

    public void render(Scene scene) {
        shaderProgram.bind();

        scene.getMesh().values().forEach(mesh -> {
                    glBindVertexArray(mesh.getVaoId());
                    glDrawArrays(GL_TRIANGLES, 0, mesh.getNumVertices());
                }
        );

        glBindVertexArray(0);

        shaderProgram.unbind();
    }
}
