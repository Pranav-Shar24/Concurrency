package runnable_interface;

public class Application {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());
		
		t1.start();
		t2.start();
	}

}
