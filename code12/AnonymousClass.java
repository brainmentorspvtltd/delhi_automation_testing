import java.util.Scanner;

//abstract interface IPlayer{
interface IPlayer{
	void kick();
	void punch();
	void walk();
	void run();
	void jump();
}
class Ryu implements IPlayer{

	@Override
	public void kick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void punch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}
	
}
class Ken implements IPlayer{

	@Override
	public void kick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void punch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}
	
}
//class Honda implements IPlayer{
//	
//}
public class AnonymousClass {
	
	static IPlayer giveKen() {
		return new IPlayer() {

			@Override
			public void kick() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void punch() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void walk() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void jump() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	static IPlayer giveRYU() {
		IPlayer ryu = new IPlayer() {

			@Override
			public void kick() {
				// TODO Auto-generated method stub
				System.out.println("PowerFul Kicks");
			}

			@Override
			public void punch() {
				// TODO Auto-generated method stub
				System.out.println("Average Punch");
				
			}

			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("Walk Speed Average");
				
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Run Fast");
				
				
			}

			@Override
			public void jump() {
				// TODO Auto-generated method stub
				System.out.println("Jump High");
			}  // Create Create and Implement the IPlayer
			
		};
		return ryu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ryu ryu = new Ryu();
		//Ken ken = new Ken();
		System.out.println("Choose a Player");
		int ch = new Scanner(System.in).nextInt();
		if(ch==1) {
			IPlayer ryu = giveRYU();
		}
		
	}

}
