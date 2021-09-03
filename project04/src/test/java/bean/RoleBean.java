package bean;

public class RoleBean extends BaseBean {
	
		public static int ADMIN;
		public static int STUDENT;
		public static int COLLEGE_SCHOOL;
		public static int KIOSK;
		private String name;
		private  String description;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
		

