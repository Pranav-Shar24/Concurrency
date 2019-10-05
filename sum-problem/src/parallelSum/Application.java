package parallelSum;

import java.util.Random;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		//System.out.println(numberOfProcessors);
		ParallelSum ps = new ParallelSum(numberOfProcessors);

		int nums[] = new int[10000000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(100);
		}

		long start = System.currentTimeMillis();

		System.out.println(ps.sum(nums));

		System.out.println("Parallel sum takes " + (System.currentTimeMillis() - start) + " milli seconds");
	}

}
