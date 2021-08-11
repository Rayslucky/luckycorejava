package JAVA8;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashmapC extends Thread {
	private static Map<String, Integer> hm = new ConcurrentHashMap<String,Integer >();
	public void run(){
		hm.put("five", 5);
	}
	public static void main(String[] args) {
		hm.put("one", 1);
		hm.put("two", 2);
		hm.put("three", 3);
		hm.put("four", 4);
		TestHashmapC tc = new TestHashmapC();
		tc.start();
		for (Object c : hm.entrySet()) {
			System.out.println(c);
		}
		System.out.println(hm);
			
		}
		
}
