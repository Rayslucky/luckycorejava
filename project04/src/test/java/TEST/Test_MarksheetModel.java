package TEST;

import bean.MarksheetBean;
import model.MarksheetModel;

public class Test_MarksheetModel {
	
		public static void main(String[] args) throws Exception {
			    // Add();
			    // del();
			     updt();

		}

		public static void updt() throws Exception {
			MarksheetBean bean = new MarksheetBean();

			
			bean.setRollNo("105");
			bean.setStudentid(305);
			bean.setName("gaurav");
			bean.setPhysics(55);
			bean.setChemistry(66);
			bean.setMaths(88);
			bean.setId(3);
		
			MarksheetModel MM = new MarksheetModel();
			
			MM.update(bean);
			
			
			System.out.println("UPDATE successfully");



}
}
