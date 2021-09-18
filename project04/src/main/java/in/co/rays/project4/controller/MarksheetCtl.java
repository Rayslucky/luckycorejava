package in.co.rays.project4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.MarksheetBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.MarksheetModel;
import in.co.rays.project4.model.StudentModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * Servlet implementation class MarksheetCtl
 */
@WebServlet(name="MarksheetCtl",urlPatterns={"/ctl/MarksheetCtl"})
public class MarksheetCtl extends BaseCtl{
	// private static Logger log = Logger.getLogger(MarksheetCtl.class);
	
	@Override
	protected void preload(HttpServletRequest request){
		StudentModel model=new StudentModel();
		try{
			List l=model.list();
			request.setAttribute("Studentlist", l);
			}catch(ApplicationException e){
				//log.error(e);
			}
	}
	
@Override
protected boolean validate(HttpServletRequest request){
    //log.debug("MarksheetCtl Method validate Started");
boolean pass = true;
if(DataValidator.isNull(request.getParameter("rollNo"))){
	request.setAttribute("rollNo", PropertyReader.getValue("error.require", "RollNumber"));
	pass = false;
}
if(DataValidator.isNotNull(request.getParameter("Physics"))&&!DataValidator.isInteger(request.getParameter("Physics"))){
	request.setAttribute("Physics", PropertyReader.getValue("error.integer", "Marks"));
	pass = false;
}
if(DataUtility.getInt(request.getParameter("Physics"))>100){
	request.setAttribute("Physics", "Marks can not be greater than 100");
	pass = false;
	
}if(DataValidator.isNotNull(request.getParameter("Chemistry"))&&!DataValidator.isInteger(request.getParameter("Chemistry"))){
	request.setAttribute("Chemistry", PropertyReader.getValue("error.integer", "Marks"));
	pass = false;
}
if(DataUtility.getInt(request.getParameter("Chemistry"))>100){
	request.setAttribute("Chemistry", "Marks can not be greater than 100");
	pass = false;
}if(DataValidator.isNotNull(request.getParameter("Maths"))&&!DataValidator.isInteger(request.getParameter("Maths"))){
	request.setAttribute("Maths", PropertyReader.getValue("error.integer", "Maths"));
	pass = false;
}if(DataUtility.getInt(request.getParameter("Maths"))>100){
	request.setAttribute("Maths", "Marks can not greater than 100");
	pass = false;
}if(DataValidator.isNull(request.getParameter("StudentId"))){
	request.setAttribute("StudentId", PropertyReader.getValue("erroe.require", "StudentName"));
}
//log.debug("MarksheetCtl Method validate Ended");
	return pass;
	
}
protected BaseBean populateBean(HttpServletRequest request){

   // log.debug("MarksheetCtl Method populatebean Started");
	MarksheetBean bean = new MarksheetBean();
	bean.setId(DataUtility.getInt(request.getParameter("id")));
	bean.setRollNo(DataUtility.getString(request.getParameter("rollNo")));
	bean.setName(DataUtility.getString(request.getParameter("name")));
	bean.setPhysics(DataUtility.getInt(request.getParameter("Physics")));
	bean.setChemistry(DataUtility.getInt(request.getParameter("Chemistry")));
	bean.setMaths(DataUtility.getInt(request.getParameter("Maths")));
	bean.setStudentid(DataUtility.getInt(request.getParameter("StudentId")));
	populateDTO(bean, request);
	System.out.println("Populate is done");
    //log.debug("MarksheetCtl Method populatebean Ended");

	return bean;
	}
/**Contain display logics
 * @throws ServletException 
 * @throws IOException **/
protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException, ServletException{
//    log.debug("MarksheetCtl Method doGet Started");
String op =DataUtility.getString(request.getParameter("operation"));
MarksheetModel model =new MarksheetModel();
int id =DataUtility.getInt(request.getParameter("id"));
if(id>0){
	MarksheetBean bean ;
	try{
		bean=model.findByPK(id);
		ServletUtility.setBean(bean, request);
		
	}catch(ApplicationException e){
		//log.error(e);
		ServletUtility.handleException(e, request, response);
		return;
	}
}
ServletUtility.forward(getView(), request, response);
//log.debug("MarksheetCtl Method doGet Ended");

}
/**Contain Submit Logic
 * @throws ServletException 
 * @throws IOException **/
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
   // log.debug("MarksheetCtl Method doPost Started");
	String op=DataUtility.getString(request.getParameter("operation"));
	//getmodel
	MarksheetModel model =new MarksheetModel();
	int id=DataUtility.getInt(request.getParameter("id"));
	if(OP_SAVE.equalsIgnoreCase(op)){
		System.out.println("Inside save op");
		MarksheetBean bean=(MarksheetBean)populateBean(request);
		System.out.println("Inside populate bean");
		try{
			if(id>0){
				model.update(bean);
			}else{
				System.out.println("upper & model");
				int pk=model.add(bean);
				bean.setId(pk);
			}
			ServletUtility.setBean(bean, request);
			ServletUtility.setSuccessMessage("Data is Succesfully saved", request);
		}catch(ApplicationException e){
			e.printStackTrace();
			//log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("Rollno is already exist", request);
			
		}
	}else if(OP_DELETE.equalsIgnoreCase(op)){
		MarksheetBean bean =(MarksheetBean)populateBean(request);
		System.out.println("inside in try");
		try{
			model.delete(bean);
			ServletUtility.redirect(ORSView.MARKSHEET_LIST_CTL, request, response);
			System.out.println("In try block");
			
		}catch(ApplicationException e){
			System.out.println("In catch block");
			//log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.MARKSHEET_LIST_CTL, request, response);
			
	}
	//ServletUtility.setBean(bean, request);
	ServletUtility.forward(getView(), request, response);
//	log.debug("MarksheetCtl Method doPost Ended");
}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.MARKSHEET_VIEW;
	}

}
