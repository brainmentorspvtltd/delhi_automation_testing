package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(90);
		list.add(20);
		list.add(0,100);
		list.remove(0); // index wise
		//list.remove(""); // value wise
		//list.clear();
		boolean isFound = list.contains(90); // search
		int index = list.indexOf(90); // search from start return index or -1
		index = list.lastIndexOf(90); // search from end , not found -1
		//list.ensureCapacity(20);
		list.set(0, 999999);
		int len = list.size();
		list.trimToSize();
		
		boolean empty = list.isEmpty();
		int singleValue = list.get(0); // return value on index 0
		// Traversal
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 1.5 Enhance for Loop
		for(int i : list) {
			System.out.println(i);
		}
		list.forEach((ele)->System.out.println(ele)); // Java 8
		Iterator<Integer> j = list.iterator();
		while(j.hasNext()) {
			System.out.println(j.next()); 
			// j.remove();
		}
		ListIterator<Integer> w = list.listIterator();
		while(w.hasNext()) {
			System.out.println(w.next());
		}
		while(w.hasPrevious()) {
			System.out.println(w.previous());
		}
		
		System.out.println(list);
		Collections.sort(list);
		//int m =  list.get(0);
		//list.add("Ram");
//		ArrayList l = new ArrayList();
//		l.add(100);
//		l.add("Ram");
//		l.add(300.90);
		//int e = (int)l.get(0);
		

	}

}
