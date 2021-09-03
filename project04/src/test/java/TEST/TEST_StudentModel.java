package TEST;
import bean.StudentBean;
import model.StudentModel;

public class TEST_StudentModel {
	
	public static void main(String[] args) throws Exception {
		 //TESTadd();
		 //del();
		 updt();
		
	}

	
		 public static void updt() throws Exception {
	

		StudentBean SB = new StudentBean();
		  

		// sB.setId(2);
		SB.setCollegeid(505);
		SB.setCollegeName("jNCT");
		SB.setFirstName("rahul");
		SB.setLastName("pal");
		//SB.setDob("03/12/2021");
		SB.setMobileNo("7999987889");
		SB.setCreatedBy("?");
		SB.setModifiedBy("?");
		// SB.setCreatedDatetime("?");
		// SB.setModifiedDatetime("?");
		SB.setId(2);

		StudentModel sm = new StudentModel();
		 //sm.delete(SB);
		// cm.delete(cB);
		sm.update(SB);

		System.out.println(" update successfully");
		

	}
}



