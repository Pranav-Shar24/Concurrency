package producer_consumer_with_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void producer() throws InterruptedException {
		lock.lock();
		try {
			System.out.println("Producer Method.....");
			condition.await();
			System.out.println("Producer Again....");
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public void consumer() throws InterruptedException {
		lock.lock();
		try {
			Thread.sleep(2000);
			System.out.println("Inside Consumer");
			condition.signal();
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}
}

public class Application {

	public static void main(String[] args) {

		Worker worker = new Worker();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					worker.consumer();
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
