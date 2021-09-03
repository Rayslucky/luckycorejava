package TEST;

import bean.UserBean;
import model.UserModel;

public class TEST_UserModel {
	public static void main(String[] args) throws Exception {
		// add();
		// del();
		updt();

	}

	public static void updt() throws Exception {

		UserBean UB = new UserBean();

		// UB.setId(2);
		UB.setFirstName("Lucky");
		UB.setLastName("rajpoot");
		UB.setLogin("lucky@gmail.com");
		UB.setPassword("10008");
		UB.setConfirmPassword("10008");
		// UB.setDob("03/12/2021");
		UB.setMobileNo("7789766353");
		UB.setRoleId(9888);
		UB.setUnSuccessfulLogin(5);
		UB.setGender("M");
		UB.getLastLogin();
		UB.getUserlock();
		// UB.getRegisteredIP("?");
		// UB.getLastLoginIP("");
		UB.setCreatedBy("?");
		UB.setModifiedBy("?");
		// UB.setCreatedDatetime("?");
		// UB.setModifiedDatetime("?");
		UB.setId(1);

		UserModel um = new UserModel();
		// um.add(UB);
		// um.delete(UB);
		um.update(UB);

		System.out.println(" UPDATe successfully");

	}
}
