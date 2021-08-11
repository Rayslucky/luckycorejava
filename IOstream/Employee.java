package IOstream;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Employee implements Externalizable
{
		private int id ;
		private String fname;
		private String lname;
		private String add;
		private transient int salary;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getAdd() {
			return add;
		}
		public void setAdd(String add) {
			this.add = add;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", add=" + add + ", salary="
					+ salary + "]";
		}
		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			id = in.readInt();
			fname = (String) in.readObject();
		    lname= (String) in.readObject();
		    add= (String) in.readObject();
		    salary =in.readInt();
		}
		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeInt(id);
			out.writeObject(fname);
			out.writeObject(lname);
			out.writeObject(add);
			out.writeInt(salary);
			
		}
		
		
		
		
	

	

}
