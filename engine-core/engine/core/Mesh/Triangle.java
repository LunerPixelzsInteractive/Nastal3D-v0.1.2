package engine.core.Mesh;

public class Triangle {
	
	private float[] positions;
	
	public Triangle() {
		positions = new float[]{
                0.0f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f
        };
	}
	
	public float[] getPositions(){
		return positions;
	}
}
