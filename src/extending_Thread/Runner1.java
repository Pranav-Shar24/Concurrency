package extending_Thread;

public class Runner1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 1: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
