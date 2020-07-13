package collections;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class LoopDemo {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		//ArrayList<String> list = new ArrayList<>();
		list.add("P Master Gen");
		list.add("P Master Gen2");
		int c = 1;
		for(String l : list) {
			list.add("M"+c+"  Gen");
			System.out.println(l);
			//list.remove(0);
		}
		System.out.println(list);

	}

}
