package JAVA8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Testhashmap  extends Thread {

		private static Map hm = Collections.synchronizedMap(new HashMap());
       @Override
		public void run() {
    	   hm.put("four", 4);
       }
      public static void main (String []args)
      { 
       hm.put("one", 1);
       hm.put("two", 2);
       hm.put("three", 3);
       Testhashmap t1 = new Testhashmap();
       t1.start();
       for (Object o : hm.entrySet()) {
    	   System.out.println(o);
       }
       System.out.println(hm);
	}
       
	}


