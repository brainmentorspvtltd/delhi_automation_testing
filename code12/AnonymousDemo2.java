
class Account1{
	void roi() {
		System.out.println("Account class ROI");
	}
	void withDraw() {
		System.out.println("Account WithDraw");
	}
}

public class AnonymousDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account1 sa = new Account1() {
			@Override
			void roi() {
				super.roi();
				System.out.println("SA class ROI");
			}
		};
		sa.roi();
		sa.withDraw();

	}

}
