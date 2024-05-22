package treeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class pratice1 {
	/*
	Using comparator class method to create treemap
	 */
	public static void main(String[] args) {
		/*
		Because the generics are java build-in data type,
		 so can directly use comparator;
		 but if the generics are user-defined class,
		 I better use comparable
		 */
		/*
		the default order is ascending by key
		 */
		Map<Integer,String> treemap =
				new TreeMap<>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// ascending
						// return o1 - o2;
						// descending
						return o2 - o1;
					}
				});
		treemap.put(5,"1");
		treemap.put(2,"2");
		treemap.put(0,"3");
		System.out.println(treemap);
	}
}
