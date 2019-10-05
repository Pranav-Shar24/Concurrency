package seqentialSum;

import java.util.Random;

public class Application {
	public static void main(String[] args) {

		//int arr[] = {2,3,5,10,50};
		
		Random random = new Random();
		
		SequentialSum s = new SequentialSum();
		int nums[] =  new int[10000000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(100);
		}
		
		long start = System.currentTimeMillis();
		
		
		System.out.println(s.sum(nums));
		
		System.out.println("Sequential sum takes " + (System.currentTimeMillis()-start) + " milli seconds");
	}
}

class SequentialSum{
	
	public int sum(int [] num) {
		
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			total = total + num[i];
		}
		
		return total;
		
	}
}
