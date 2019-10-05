package use_of_volatile;

public class Worker implements Runnable {

	private volatile boolean isTerminated = false;

	@Override
	public void run() {

		while (!isTerminated) {
			System.out.println("Hello!, Inside of the worker class.");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

}
