package engine.core.scene;

import java.util.HashMap;
import java.util.Map;

import engine.core.Mesh.Mesh;

public class Scene {
	private Map<String, Mesh> meshMap;
	
	public Scene() {
		meshMap = new HashMap<>();
	}
	
	public void addMesh(String id, Mesh mesh) {
		meshMap.put(id, mesh);
	}
	
	public void cleanup() {
		 meshMap.values().forEach(Mesh::cleanup);
	}
	
	public Map<String, Mesh> getMesh() {
		return meshMap;
	}
}
