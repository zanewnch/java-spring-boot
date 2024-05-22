package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class practice2 {
	public static void main(String[] args) throws IOException {
		
		/*
		basic syntax practice
		 */
		String currentWorkingDirectory =
				System.getProperty("user.dir");
		System.out.println("The current directory is: "+currentWorkingDirectory);
		
		File f10 = new File(".");
		System.out.println(f10.exists());
		System.out.println(f10.getAbsoluteFile());
		
		File f20 = new File("src");
		System.out.println(f20.exists());
		System.out.println(f20.getAbsolutePath());
		
		File f30 = new File("src/main/java");
		System.out.println(f30.exists());
		System.out.println("The absolute path is: "+f30.getAbsolutePath());
		System.out.println("The relative path is: "+f30.getPath());
		
		/*
		question 1:
		create a.txt file in current directory(edit)
		 */
		
		// /Users/zane/Documents/Code/Java/Basic
		String currentWorkingDirectory1 =
				System.getProperty("user.dir");
		System.out.println(currentWorkingDirectory1);
		
		/*
		這個邏輯是：要先給定一個路徑
		然後這個路徑要用method .mkdir to be create
		而不是先設定要創立directory的資料夾路徑
		然後在mkdir輸入要創建的folder name
		.mkdir是沒有parameter的
		 */
		File folder1 = new File("src/main/java/file" +
				"/createFolder1");
		System.out.println(folder1.exists());
		boolean createFolderSuccess = folder1.mkdir();
		
		// using f1 as parent path
		File file2 = new File(folder1,"createFile.txt");
		boolean createFileSuccess = file2.createNewFile();
		
		if (createFileSuccess | createFolderSuccess){
			System.out.println("Creating both file and " +
					"folder are successfully");
		}else{
			System.out.println("The items are already be " +
					"created " +
					"or with wrong path.");
		}
		
		/*
		question 2:
		define a method to find does there is any file
		end in .avi in the folder
		先不用考慮子資料夾
		 */
		
		boolean haveAVIResult = haveAVI(folder1);
		System.out.println(haveAVIResult);
		
		/*
		question 3:
		find the file end in .avi in current directory
		and subdirectory.
		 */
		/*
		question 4:
		delete a directory
		 */
		/*
		question 5:
		統計一個directory 當中每種文件的個數並print out
		 */
		
		
	}
	
	// question 2:
	// 找到以.avi結尾的file
	public static boolean haveAVI(File folder){
		File[] files = folder.listFiles();
		assert files != null;
		for (File f: files) {
			if(f.isFile() | f.getName().endsWith(".avi")){
				return true;
			}
		}
		// 如果for loop當中都沒有找到，就return false.
		return false;
	}
// 	question 3:
	public static List<File> getAllAVIFile(File folder){
		File[] files = folder.listFiles();
		List<File> containAVI = new ArrayList<>();
		assert files != null;
		for (File file: files
		     ) {
			if(file.isFile() | file.getName().endsWith(
					".avi")){
				containAVI.add(file);
			}else{
				getAllAVIFile(file);
			}
		}
		return containAVI;
	}
// 	question 4:
	public static void deleteFolder(File folder){
		File[] files = folder.listFiles();
		if(files == null){
			folder.delete();
		} else {
			for (File file: files
			     ) {
				if(file.isFile()){
					file.delete();
				}else {
					deleteFolder(file);
				}
			}
			folder.delete();
		}
		
	}
}
