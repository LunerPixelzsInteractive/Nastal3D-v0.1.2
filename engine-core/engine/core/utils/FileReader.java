package engine.core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
	private FileReader() {
		
	}
	
	public static String fileReader(String filePath) {
		String str;
		
		try {
			str = new String(Files.readAllBytes(Paths.get(filePath)));
		}catch(IOException exception) {
			throw new RuntimeException("Error reading file [" + filePath + "]", exception);
		}
		
		return str;
	}
}
