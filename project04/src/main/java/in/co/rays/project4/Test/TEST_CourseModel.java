package in.co.rays.project4.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.CollegeBean;
import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CourseModel;

public class TEST_CourseModel {
	  
  static	CourseModel  model = new CourseModel();
  
  public static void main(String[] args) throws DuplicateRecordException {
	    // testAdd();
     //  testDelete();
     // testUpdate();
	//  testfindByName();
	 // testFindByPK();
	  testsearch();
	//  testList();
  }

public static void testAdd() throws DuplicateRecordException {
	try {
		CourseBean bean = new CourseBean();
		bean.setCourse_Name("corporate");
		bean.setDiscription("job");
		bean.setCreatedBy("sunilos");
		bean.setModifiedBy("rays");
		//bean.setCreatedDatetime(createdDatetime);
		//bean.setModifiedDatetime(modifiedDatetime);
		long pk = model.add(bean);
        System.out.println("Test add succ");
        CourseBean addedBean = model.findByPk(pk);
        if (addedBean == null) {
            System.out.println("Test add fail");
        }
		
		} catch (Exception e) {
			 e.printStackTrace();
	}
	
}


public static void testDelete() {

    try {
        CourseBean bean = new CourseBean();
        long pk = 3;
        bean.setId(pk);
        model.delete(bean);
        System.out.println("Test Delete succ");
        CourseBean deletedBean = model.findByPk(pk);
        if (deletedBean != null) {
            System.out.println("Test Delete fail");
        }
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
} public static void testUpdate() {

    try {
        CourseBean bean = model.findByPk(2);
        bean.setCourse_Name("corporate java");
        bean.setDiscription("min pack. 5lacks");
        model.update(bean);
        System.out.println("Test Update succ");
        CourseBean updateBean = model.findByPk(2);
        if (!"corporate".equals(updateBean.getCourse_Name())) {
            System.out.println("Test Update fail");
        }
    } catch (ApplicationException e) {
        e.printStackTrace();
    } catch (DuplicateRecordException e) {
        e.printStackTrace();
    }

}
public static void testfindByName() throws DuplicateRecordException {
	
	  try {
          CourseBean bean = model.findByName("corejava");
          if (bean == null) {
              System.out.println("Test Find By Name fail");
          }
          System.out.println(bean.getId());
          System.out.println(bean.getCourse_Name());
          System.out.println(bean.getDiscription());
           System.out.println(bean.getCreatedBy());
          System.out.println(bean.getCreatedDatetime());
          System.out.println(bean.getModifiedBy());
          System.out.println(bean.getModifiedDatetime());
          System.out.println(bean.getDuration());
          
      } catch (ApplicationException e) {
          e.printStackTrace();
      }

  }
public static void testFindByPK() {
    try {
        CourseBean bean = new CourseBean();
        long pk = 3;
        bean = model.findByPk(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getCourse_Name());
        System.out.println(bean.getDiscription());
        System.out.println(bean.getCreatedBy());
        System.out.println(bean.getCreatedDatetime());
        System.out.println(bean.getModifiedBy());
        System.out.println(bean.getModifiedDatetime());
        System.out.println(bean.getDuration());
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

public static void testsearch() {
    try {
        CourseBean bean = new CourseBean();
        List list = new ArrayList();
        bean.setCourse_Name("kavalya");
        // bean.setDiscription("psc");
        list = model.search(bean, 1, 10);
        if (list.size() < 0) {
            System.out.println("Test Search fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (CourseBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getCourse_Name());
            System.out.println(bean.getDiscription());
            System.out.println(bean.getCreatedBy());
            System.out.println(bean.getCreatedDatetime());
            System.out.println(bean.getModifiedBy());
            System.out.println(bean.getModifiedDatetime());
            System.out.println(bean.getDuration());
        }
    } catch (ApplicationException e) {
        e.printStackTrace();

    }
}

public static void testList() {

    try {
        CourseBean bean = new CourseBean();
        List list = new ArrayList();
        list = model.list(1, 10);
        if (list.size() < 0) {
            System.out.println("Test list fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (CourseBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getCourse_Name());
            System.out.println(bean.getDiscription());
            System.out.println(bean.getCreatedBy());
            System.out.println(bean.getCreatedDatetime());
            System.out.println(bean.getModifiedBy());
            System.out.println(bean.getModifiedDatetime());
            System.out.println(bean.getDuration());
        }

    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}
}
