package in.co.rays.project4.bean;


import java.util.Date;

public class StudentBean extends BaseBean {

	    private long collegeid;
	    private String collegeName; 
		private String firstName;
		private String lastName;
		private Date dob;
		private String mobileNo;
		private String email;
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getCollegeid() {
			return collegeid;
		}
		public void setCollegeid(long collegeid) {
			this.collegeid = collegeid;
		}
		public String getCollegeName() {
			return collegeName;
		}
		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}
		public String getKey() {
			// TODO Auto-generated method stub
			return id+"";
		}
		public String getValue() {
			// TODO Auto-generated method stub
			return firstName;
		}
}
