package wait_notify;

public class Application {

	public static void main(String[] args) {

		Processor processor = new Processor();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("I am pointing to the producer method");
			wait(3000);
			System.out.println("Again the produce method");
		}
	}

	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("I am pointing to the consumer method");
			notify();
		}
	}
}
