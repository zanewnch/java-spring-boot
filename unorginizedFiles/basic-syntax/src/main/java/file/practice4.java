package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class practice4 {
	/*
	計算folder內各類文件的個數
	 */
	public static void main(String[] args) {
	
	}
	public static Map<String,Integer> getCount(File folder){
		File[] files = folder.listFiles();
		Map<String,Integer> map = new HashMap<>();
		
		assert files != null;
		for (File file: files
		     ) {
			// is file
			if(file.isFile()){
				// regular expression
				String[] fileName =  file.getName().split(
						"\\.");
				String detectName =
						fileName[fileName.length - 1];
			// 	add data to map
				if (map.containsKey(detectName)){
				// 	Key is exist
					int detectValue = map.get(detectName);
					detectValue ++;
					map.put(detectName,detectValue);
				}else {
				// 	key is not exist
					map.put(detectName,1);
				}
			}else {
			// 	is folder
				Map<String,Integer> sonMap = getCount(file);
				
				// add recursion result to primitive
				// variable
				Set<Map.Entry<String,Integer>> entries =
						sonMap.entrySet();
				for (Map.Entry<String,Integer> entry: entries
				     ) {
					String sonKey = entry.getKey();
					
					if (map.containsKey(sonKey)){
						int count = map.get(sonKey);
						count = count + sonMap.get(sonKey);
						map.put(sonKey,count);
					}else{
						map.put(sonKey,1);
					}
				}
			}
		}
		
		return map;
	}
}
