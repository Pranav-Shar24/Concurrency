package sequential_processing;

class Runner1{
	public void startRunner1() {
		for(int i =0 ; i<=10 ; i++) {
			System.out.println("Runner 1: " + i);
		}
	}
}

class Runner2{
	public void startRunner2() {
		for(int i =0 ; i<=10 ; i++) {
			System.out.println("Runner 2: " + i);
		}
	}
}

public class Application {

	public static void main(String[] args) {

		Runner1 rn1 = new Runner1();
		Runner2 rn2 = new Runner2();
		
		rn1.startRunner1();
		rn2.startRunner2();
	}

}
