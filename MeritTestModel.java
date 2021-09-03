package Javabean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MeritTestModel {
	public static void main(String[] args) throws Exception {
		testMerit();
	}
	public static void testMerit() throws Exception {
	ClassBean Bean  = new ClassBean();
	    
	    List<ClassBean> mbean= new ArrayList<>();
	    
	    ModelMerit m = new ModelMerit();
		
       mbean =	m.ModelMeritList(Bean);
       
		Iterator<ClassBean> it=mbean.iterator();
		while (it.hasNext()) {
			Bean=it.next();
		
			System.out.print("\t"+Bean.getId());
			System.out.print("\t"+Bean.getRoll_no());
			System.out.print("\t"+Bean.getFname());
			System.out.print("\t"+Bean.getLname());
			System.out.print("\t"+Bean.getPhysics());
			System.out.print("\t"+Bean.getChemistry());
			System.out.println("\t"+Bean.getMath());
			
		}
}
}
