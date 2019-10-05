package latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {

	private int id;
	private CountDownLatch countDownLatch;

	Worker(int id, CountDownLatch countDownLatch) {
		this.id = id;
		this.countDownLatch = countDownLatch;

	}

	@Override
	public void run() {
		doWork();
		countDownLatch.countDown();
	}

	private void doWork() {
		System.out.println("Thread with id: " + this.id + " starts working...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Application {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		CountDownLatch countDownLatch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Worker(i + 1, countDownLatch));
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("All the pre-requisites are Done!!");
			executorService.shutdown();
		}
	}

}
