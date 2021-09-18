package in.co.rays.project4.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class BaseBean implements DropdownlistBean,Serializable,Comparable<BaseBean>  {

		protected long id;
		private String createdBy;
		private String modifiedBy;
		private Timestamp createdDatetime;
		private Timestamp modifiedDatetime;
		public long getId() {
			
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public Timestamp getCreatedDatetime() {
			return createdDatetime;
		}
		public void setCreatedDatetime(Timestamp createdDatetime) {
			this.createdDatetime = createdDatetime;
		}
		public Timestamp getModifiedDatetime() {
			return modifiedDatetime;
		}
		public void setModifiedDatetime(Timestamp modifiedDatetime) {
			this.modifiedDatetime = modifiedDatetime;
		}
		
		public int compareTo(BaseBean next) {
			// TODO Auto-generated method stub
			return getValue().compareTo(next.getValue());
		}
		
}
