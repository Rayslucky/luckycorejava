package in.co.rays.project4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.CollegeBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CollegeModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * Servlet implementation class CollegeCtl
 */
@WebServlet("/CollegeCtl")
public class CollegeCtl extends BaseCtl {
	private static final int serialVersionUID = 1;

	   // private static Logger log = Logger.getLogger(CollegeCtl.class);

	    @Override
	    protected boolean validate(HttpServletRequest request) {

	       // log.debug("CollegeCtl Method validate Started");

	        boolean pass = true;

	        if (DataValidator.isNull(request.getParameter("name"))) {
	            request.setAttribute("name",
	                    PropertyReader.getValue("error.require", "Name"));
	            pass = false;
	        }

	        if (DataValidator.isNull(request.getParameter("address"))) {
	            request.setAttribute("address",
	                    PropertyReader.getValue("error.require", "Address"));
	            pass = false;
	        }

	        if (DataValidator.isNull(request.getParameter("state"))) {
	            request.setAttribute("state",
	                    PropertyReader.getValue("error.require", "State"));
	            pass = false;
	        }
	        if (DataValidator.isNull(request.getParameter("city"))) {
	            request.setAttribute("city",
	                    PropertyReader.getValue("error.require", "city"));
	            pass = false;
	        }
	        if (DataValidator.isNull(request.getParameter("phoneNo"))) {
	            request.setAttribute("phoneNo",
	                    PropertyReader.getValue("error.require", "Phone No"));
	            pass = false;
	        }

	       // log.debug("CollegeCtl Method validate Ended");

	        return pass;
	    }

	    @Override
	    protected BaseBean populateBean(HttpServletRequest request) {

	        //log.debug("CollegeCtl Method populatebean Started");

	        CollegeBean bean = new CollegeBean();

	        bean.setId(DataUtility.getInt(request.getParameter("id")));

	        bean.setName(DataUtility.getString(request.getParameter("name")));

	        bean.setAddress(DataUtility.getString(request.getParameter("address")));

	        bean.setState(DataUtility.getString(request.getParameter("state")));

	        bean.setCity(DataUtility.getString(request.getParameter("city")));

	        bean.setPhoneNo(DataUtility.getString(request.getParameter("phoneNo")));

	        populateDTO(bean, request);

	       // log.debug("CollegeCtl Method populatebean Ended");

	        return bean;
	    }

	    /**
	     * Contains display logic
	     */
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {

	        String op = DataUtility.getString(request.getParameter("operation"));

	        // get model
	        CollegeModel model = new CollegeModel();

	        int id = DataUtility.getInt(request.getParameter("id"));

	        if (id > 0) {
	            CollegeBean bean;
	            try {
	                bean = model.findByPK(id);
	                ServletUtility.setBean(bean, request);
	            } catch (ApplicationException e) {
	               // log.error(e);
	                ServletUtility.handleException(e, request, response);
	                return;
	            }
	        }

	        ServletUtility.forward(getView(), request, response);
	    }

	    /**
	     * Contains Submit logics
	     */
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {

	       // log.debug("CollegeCtl Method doPost Started");

	        String op = DataUtility.getString(request.getParameter("operation"));

	        // get model
	        CollegeModel model = new CollegeModel();

	        long id = DataUtility.getLong(request.getParameter("id"));

	        if (OP_SAVE.equalsIgnoreCase(op)) {

	            CollegeBean bean = (CollegeBean) populateBean(request);

	            try {
	                if (id > 0) {
	                    model.update(bean);
	                } else {
	                    long pk = model.add(bean);
	                    bean.setId(pk);
	                }
	                ServletUtility.setBean(bean, request);
	                ServletUtility.setSuccessMessage("Data is successfully saved",
	                        request);

	            } catch (ApplicationException e) {
	                e.printStackTrace();
	                ServletUtility.handleException(e, request, response);
	                return;
	            } catch (DuplicateRecordException e) {
	                ServletUtility.setBean(bean, request);
	                ServletUtility.setErrorMessage("College Name already exists",
	                        request);
	            }

	        } else if (OP_DELETE.equalsIgnoreCase(op)) {

	            CollegeBean bean = (CollegeBean) populateBean(request);
	            try {
	                model.delete(bean);
	                ServletUtility.redirect(ORSView.COLLEGE_LIST_CTL, request,
	                        response);
	                return;

	            } catch (ApplicationException e) {
	                //log.error(e);
	                ServletUtility.handleException(e, request, response);
	                return;
	            }

	        } else if (OP_CANCEL.equalsIgnoreCase(op)) {

	            ServletUtility
	                    .redirect(ORSView.COLLEGE_LIST_CTL, request, response);
	            return;

	        }

	        ServletUtility.forward(getView(), request, response);

	        //log.debug("CollegeCtl Method doGet Ended");
	    }

	    @Override
	    protected String getView() {
	        return ORSView.COLLEGE_VIEW;
	    }



	}


	