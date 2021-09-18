package in.co.rays.project4.Test;

import in.co.rays.project4.bean.TimetableBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.TimetableModel;

public class TEST_TimetableModel {
	
  public static TimetableModel model = new TimetableModel();
	  
	  public static void main(String[] args) throws DuplicateRecordException {
	       //  testAdd();
		 //testDelete();
		  //testUpdate();
		  testFindByPK();
	
		 }

	public static void testAdd() throws DuplicateRecordException {
		
		try {
          TimetableBean bean = new TimetableBean();
          
          
         bean.setCourse_Name("Corporate java");
         bean.setCourse_Id(55);
         bean.setSubject_Name("java");
         bean.setSubject_Id(550);
       // bean.setExam_Date();
          bean.setExam_Time("12:00");
          bean.setSemester(1);
          bean.setCreatedBy("sunilos");
          bean.setModifiedBy("sunilos");
          bean.getCreatedDatetime();
          bean.getModifiedDatetime();
          
          
          long pk = model.add(bean);
          System.out.println("Test add succ");
         TimetableBean addedBean = model.findByPk(pk);
          if (addedBean == null) {
              System.out.println("Test add fail");
          }
      } catch (ApplicationException e) {
          e.printStackTrace();
      }

  }
		
		
	
public static void testDelete() {

  try {
    TimetableBean bean = new TimetableBean();
      long pk = 3;
      bean.setId(pk);
      model.delete(bean);
      System.out.println("Test Delete succ");
      TimetableBean deletedBean = model.findByPk(pk);
      if (deletedBean != null) {
          System.out.println("Test Delete fail");
      }
  } catch (ApplicationException e) {
      e.printStackTrace();
  }
}

public static void testUpdate() {

  try {
      TimetableBean bean = model.findByPk(2);
      
      bean.setCourse_Name("Corporate python");
      bean.setCourse_Id(55);
      bean.setSubject_Name("java");
      bean.setSubject_Id(550);
  // bean.setExam_Date();
      bean.setExam_Time("12:00");
      bean.setSemester(1);
      bean.setCreatedBy("sunilos");
      bean.setModifiedBy("sunilos");
      bean.getCreatedDatetime();
      bean.getModifiedDatetime();
      model.update(bean);
      System.out.println("Test Update succ");
      TimetableBean  updateBean = model.findByPk(2);
      
  } catch (ApplicationException e) {
      e.printStackTrace();
  } catch (DuplicateRecordException e) {
      e.printStackTrace();
  }
}

public static void testFindByPK() {
  try {
    TimetableBean  bean = new TimetableBean();
      long pk = 1;
      bean = model.findByPk(pk);
      if (bean == null) {
          System.out.println("Test Find By PK fail");
      }
      System.out.println(bean.getId());
     System.out.println(bean.getCourse_Name());
     System.out.println(bean.getCourse_Id());
     System.out.println(bean.getSubject_Name());
     System.out.println(bean.getSubject_Id());
     System.out.println(bean.getExam_Date());
     System.out.println(bean.getExam_Time());
     System.out.println(bean.getSemester());
     System.out.println(bean.getCreatedBy());
      System.out.println(bean.getModifiedBy());
      System.out.println(bean.getCreatedDatetime());
      System.out.println(bean.getModifiedDatetime());
      
  } catch (ApplicationException e) {
      e.printStackTrace();
  }
}
	
}