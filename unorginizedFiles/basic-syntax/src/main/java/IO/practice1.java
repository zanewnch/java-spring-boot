package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class practice1 {
	public static void main(String[] args) throws IOException {
		// append: true 續寫
		// default append: false 會覆蓋原內容直接重寫
		FileOutputStream fileOut1 = new FileOutputStream(
				"src/main/java/IO/createFolder",true);
		
		String writeContent = "This the content written " +
				"in" +
				" file";
		byte[] bytes1 = writeContent.getBytes();
		
		fileOut1.write(bytes1);
		
		String changeLine = "\r";
		byte[] bytes2 = changeLine.getBytes();
		fileOut1.write(bytes2);
	
		
		String writeContent2 = "The next line content";
		byte[] byte3 = writeContent2.getBytes();
		fileOut1.write(byte3);
		
		fileOut1.close();
		
	}
}
