import java.util.ArrayList;

public class HeapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//main(null);
		System.out.println("Heap Demo");
		long i = 0L;
		ArrayList<User> users = new ArrayList<>();
		while(true) {
			User user = new User("ram"+i,"123"+i);
			users.add(user);
			i++;
		}
		
	}

}
