package TEST;

import bean.CollegeBean;
import model.CollegeModel;

public class TEST_CollegeModel {

	public static void main(String[] args) throws Exception {
		//TESTadd();
		 TESTdelete();

		//TESTUpdate();
	}

	private static void TESTdelete() throws Exception {

		// public static Long TESTadd() throws Exception {
		// public static void TESTdelete() throws Exception {

		CollegeBean CB = new CollegeBean();

		// cB.setId(2);
		//CB.setName("gaurav");
//		CB.setAddress("sector144");
//		CB.setState("MP");
//		CB.setCity("indore");
//		CB.setPhoneNo("74899999");
//		CB.setCreatedBy("?");
//		CB.setModifiedBy("?");
		// CB.setCreatedDatetime("?");
		// CB.setModifiedDatetime("?");
		CB.setId(3);

		CollegeModel cm = new CollegeModel();
		//cm.add(CB);
		 cm.delete(CB);
		//cm.update(CB);

		System.out.println("delete successfully");
	

	}
}
