package parallelSum;

public class ParallelSum {

	private ParallelSumWorker[] sums;
	private int numberOfThreads;

	public ParallelSum(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
		this.sums = new ParallelSumWorker[numberOfThreads];
	}

	public int sum(int[] nums) {

		int steps = (int) Math.ceil(nums.length * 1.0 / numberOfThreads);
		for (int i = 0; i < numberOfThreads; i++) {
			sums[i] = new ParallelSumWorker(nums, i * steps, (i + 1 * steps));
			sums[i].start();

		}
		try {
			for (ParallelSumWorker worker : sums) {
				worker.join();
			}

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		int total = 0;

		for (ParallelSumWorker worker : sums) {
			total = total + worker.getPartialSum();
		}
		return total;
	}
}
