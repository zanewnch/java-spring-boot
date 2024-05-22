package file;

import java.io.File;

public class practice3 {
	/*
	計算folder內文件總size
	 */
	public static void main(String[] args) {
		String currentWorkingDirectory =
				System.getProperty("user.dir");
		System.out.println("The current directory is: " + currentWorkingDirectory);
		
		File f1 = new File("src/main/java/file" +
				"/createFolder1");
		long result = getTotalLen(f1);
		System.out.println(result);
	}
	
	public static long getTotalLen(File folder) {
		/**
		 * pass in a file object with path
		 * return the long with total data size in the
		 * folder
		 */
		File[] files = folder.listFiles();
		long length = 0;
		
		for (File file : files
		) {
			// condition 1: file
			if (file.isFile()) {
				length = length + file.length();
			} else {
				// 	condtion 2: folder
				// 為了讓recursion 計算的值加回到原本的length variable
				length = length + getTotalLen(file);
			}
		}
		return length;
	}
}
