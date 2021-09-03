package TEST;

import bean.RoleBean;
import model.RoleModel;

public class TEST_RoleModel {
	public static void main(String[] args) throws Exception {
		//add();
		//dl();
		up();
		
	}

	
		 public static void up() throws Exception {
		
		RoleBean RB = new RoleBean();

	
	RB.setName("amar");	
	RB.setDescription("DR.");
        RB.setCreatedBy("?");
		RB.setModifiedBy("?");
		//RB.setCreatedDatetime("?");
		 //RB.setModifiedDatetime("?");
		RB.setId(2);
	

		RoleModel rm  = new RoleModel();
		//rm.add(RB);
		 //rm.delete(RB);
		rm.update(RB);

		System.out.println(" update successfully");
		

	}
}

	


