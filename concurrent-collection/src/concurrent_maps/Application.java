package concurrent_maps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Application {

	public static void main(String[] args) {
		
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
		new Thread(new FirstWorker(map)).start();
		new Thread(new SecondWorker(map)).start();
		
		
	}

}

class FirstWorker implements Runnable {

	private ConcurrentMap<String, Integer> maps;

	public FirstWorker(ConcurrentMap<String, Integer> maps) {
		this.maps = maps;
	}

	@Override
	public void run() {
		try {
			maps.put("a", 1);
			maps.put("b", 2);
			Thread.sleep(1000);
			maps.put("c", 3);
			maps.put("d", 4);
			Thread.sleep(1000);
			maps.put("e", 5);

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}

class SecondWorker implements Runnable{
	
	private ConcurrentMap< String, Integer> maps;

	public SecondWorker(ConcurrentMap<String, Integer> maps) {
		this.maps = maps;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(500);
			System.out.println(maps.get("a"));
			Thread.sleep(1000);
			System.out.println(maps.get("b"));
			System.out.println(maps.get("e"));
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
}
