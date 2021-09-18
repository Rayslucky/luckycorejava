package in.co.rays.project4.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.bean.FacultyBean;
import in.co.rays.project4.bean.StudentBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.FacultyModel;

public class TEST_FacultyModel {
	
	
	  public static FacultyModel model = new FacultyModel();
	  
	  public static void main(String[] args) throws DuplicateRecordException {
	        // testAdd();
		 // testDelete();
		 // testUpdate();
		  //testFindByPK();
		 // testFindByEmailId();
		 //    testfindByPk();
		 // testsearch();
		  testlist();
		  
		  

}

	public static void testAdd() throws DuplicateRecordException {
		
		try {
            FacultyBean bean = new FacultyBean();
      
            bean.setFirst_Name("java");
            bean.setLast_Name("raystech");
            bean.setGender("M");
           // bean.setDOB(10/10/2010);
            bean.setQualification("B.E");
            bean.setEmail_id("raytech@gmail.com");
            bean.setMobile_No("999999999");
            bean.setCreatedBy("sunilos");
            bean.setModifiedBy("sunilos");
            
            
            long pk = model.add(bean);
            System.out.println("Test add succ");
            FacultyBean addedBean = model.findByPk(pk);
            if (addedBean == null) {
                System.out.println("Test add fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
		
		
	
public static void testDelete() {

    try {
        FacultyBean bean = new FacultyBean();
        long pk = 2;
        bean.setId(pk);
        model.delete(bean);
        System.out.println("Test Delete succ");
        FacultyBean deletedBean = model.findByPk(pk);
        if (deletedBean != null) {
            System.out.println("Test Delete fail");
        }
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

public static void testUpdate() {

    try {
        FacultyBean bean = model.findByPk(4);
        bean.setFirst_Name("john");
        bean.setLast_Name("Cena");
        model.update(bean);
        System.out.println("Test Update succ");
        FacultyBean updateBean = model.findByPk(4);
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    } catch (DuplicateRecordException e) {
        e.printStackTrace();
    }
}

public static void testfindByPk() {
    try {
        FacultyBean bean = new FacultyBean();
        long pk = 3;
        bean = model.findByPk(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getFirst_Name());
        System.out.println(bean.getLast_Name());
        System.out.println(bean.getGender());
      //  System.out.println(bean.getDOB());
        System.out.println(bean.getQualification());
        System.out.println(bean.getEmail_id());
        System.out.println(bean.getMobile_No());
        System.out.println(bean.getCollege_id());
        System.out.println(bean.getCollege_Name());
        System.out.println(bean.getCourse_id());
        System.out.println(bean.getCourse_Name());
        System.out.println(bean.getSubject_id());
        System.out.println(bean.getSubject_Name());
        System.out.println(bean.getCreatedBy());
        System.out.println(bean.getModifiedBy());
        System.out.println(bean.getCreatedDatetime());
        System.out.println(bean.getModifiedDatetime());
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}public static void testFindByEmailId() {
    try {
        FacultyBean bean = new FacultyBean();
        bean = model.findByEmail("kk@gmail.com");
        if (bean != null) {
            System.out.println("Test Find By EmailId fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getFirst_Name());
        System.out.println(bean.getLast_Name());
        System.out.println(bean.getGender());
        //  System.out.println(bean.getDOB());
          System.out.println(bean.getQualification());
          System.out.println(bean.getEmail_id());
          System.out.println(bean.getMobile_No());
          System.out.println(bean.getCollege_id());
          System.out.println(bean.getCollege_Name());
          System.out.println(bean.getCourse_id());
          System.out.println(bean.getCourse_Name());
          System.out.println(bean.getSubject_id());
          System.out.println(bean.getSubject_Name());
          System.out.println(bean.getCreatedBy());
          System.out.println(bean.getModifiedBy());
          System.out.println(bean.getCreatedDatetime());
          System.out.println(bean.getModifiedDatetime());
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

public static void testFindByPK() {
    try {
        FacultyBean bean = new FacultyBean();
        long pk = 3;
        bean = model.findByPk(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
            System.out.println(bean.getId());
            System.out.println(bean.getFirst_Name());
            System.out.println(bean.getLast_Name());
            System.out.println(bean.getGender());
            //  System.out.println(bean.getDOB());
              System.out.println(bean.getQualification());
              System.out.println(bean.getEmail_id());
              System.out.println(bean.getMobile_No());
              System.out.println(bean.getCollege_id());
              System.out.println(bean.getCollege_Name());
              System.out.println(bean.getCourse_id());
              System.out.println(bean.getCourse_Name());
              System.out.println(bean.getSubject_id());
              System.out.println(bean.getSubject_Name());
              System.out.println(bean.getCreatedBy());
              System.out.println(bean.getModifiedBy());
              System.out.println(bean.getCreatedDatetime());
              System.out.println(bean.getModifiedDatetime());
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
}
public static void testsearch() {

    try {
        FacultyBean bean = new FacultyBean();
        List list = new ArrayList();
        bean.setFirst_Name("tia");
        list = model.search(bean, 0, 0);
        if (list.size() < 0) {
            System.out.println("Test Serach fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (FacultyBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getFirst_Name());
            System.out.println(bean.getLast_Name());
            System.out.println(bean.getGender());
            //  System.out.println(bean.getDOB());
              System.out.println(bean.getQualification());
              System.out.println(bean.getEmail_id());
              System.out.println(bean.getMobile_No());
              System.out.println(bean.getCollege_id());
              System.out.println(bean.getCollege_Name());
              System.out.println(bean.getCourse_id());
              System.out.println(bean.getCourse_Name());
              System.out.println(bean.getSubject_id());
              System.out.println(bean.getSubject_Name());
              System.out.println(bean.getCreatedBy());
              System.out.println(bean.getModifiedBy());
              System.out.println(bean.getCreatedDatetime());
              System.out.println(bean.getModifiedDatetime());
        }
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
}

public static void testlist() {

    try {
        FacultyBean bean = new FacultyBean();
        List list = new ArrayList();
        list = model.list(1, 10);
        if (list.size() < 0) {
            System.out.println("Test list fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (FacultyBean) it.next();
            
            System.out.println(bean.getId());
            System.out.println(bean.getFirst_Name());
            System.out.println(bean.getLast_Name());
            System.out.println(bean.getGender());
            //  System.out.println(bean.getDOB());
              System.out.println(bean.getQualification());
              System.out.println(bean.getEmail_id());
              System.out.println(bean.getMobile_No());
              System.out.println(bean.getCollege_id());
              System.out.println(bean.getCollege_Name());
              System.out.println(bean.getCourse_id());
              System.out.println(bean.getCourse_Name());
              System.out.println(bean.getSubject_id());
              System.out.println(bean.getSubject_Name());
              System.out.println(bean.getCreatedBy());
              System.out.println(bean.getModifiedBy());
              System.out.println(bean.getCreatedDatetime());
              System.out.println(bean.getModifiedDatetime());
        }
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
}
}
