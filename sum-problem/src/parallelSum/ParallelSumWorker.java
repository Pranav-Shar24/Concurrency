package parallelSum;

public class ParallelSumWorker extends Thread{
	
	private int num[];
	private int low;
	private int high;
	private int partialSum;

	public ParallelSumWorker(int[] num, int low, int high) {
		this.num = num;
		this.low = low;
		this.high = high;
	}
	
	public int getPartialSum() {
		return this.partialSum;
	}
	
	@Override
	public void run() {
		partialSum = 0;
		
		for (int i = low; i < high; i++) {
			partialSum = partialSum + num[i];
		}
	
	}

}
