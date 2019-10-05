package semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
--semaphores maintains a set of permits. It has basically two methods associated:
	1) acquire() -> if a permit is available it takes it.
	2) release() -> adds a permit

Semaphores just keep the tracks of number of available resources.

 new Semaphore(int permits, boolean false);
	--*/


enum Downloader{
	
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(3,true);
	
	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}

	private void download() {
		System.out.println("Downloading data from the web...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class Application {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0; i<12;i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					Downloader.INSTANCE.downloadData();
				}
				
			});
		}
	}

}
