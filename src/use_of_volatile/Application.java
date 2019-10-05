package use_of_volatile;

public class Application {

	public static void main(String[] args) {
		Worker worker = new Worker();
		
		Thread t1 = new Thread(worker);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		worker.setTerminated(true);
		System.out.println("Task finished!!!");
	}
	
	

}
