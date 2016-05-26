package com.classifiedindia.action;

import com.classified.dateconvert.DateConversion;
import com.classifiedindia.admin.bean.AdminActionForm;
import com.classifiedindia.formbean.BuyerSellerInfoBean;
import com.classifiedindia.formbean.SubCategoryActionForm;
import com.classifiedindia.formbean.ClassifiedIndiaFormBean;
import com.classifiedindia.formbean.LoginActionForm;
import com.classifiedindia.formbean.MobilePhonesFormBean;
import com.classifiedindia.model.AdminForgotPasswordModel;
import com.classifiedindia.model.AdminModel;
import com.classifiedindia.model.ClassifiedModel;
import com.classifiedindia.vo.AdminForgotPasswordVO;
import com.classifiedindia.vo.AdminProfileVO;
import com.classifiedindia.vo.CategoryVO;
import com.classifiedindia.vo.ClassifiedIndiaVO;
import com.classifiedindia.vo.UserProfileVO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ClassifiedIndiaAction extends org.apache.struts.actions.MappingDispatchAction {

    private static final String REGISTER = "register";
    private static final String POSTREGISTER = "postregister";
    private static final String FAILTOREGISTER = "failtoregister";
    private static final String VIEWADS = "viewads";
    private static final String MYDASHBOARD = "mydashboard";
    private static final String MYDASHEDIT = "mydashedit";
    private static final String PROPERTY_FOR_SALE = "propertyforsale";
    private static final String GUESTHOUSES = "guesthouses";
    private static final String BUSINESS_PROPOSAL = "businessproposal";
    private static final String HOLIDAY_TIMES = "holidaytimes";
    private static final String CULTURAL_EVENTS = "culturalevents";
    private static final String ESCORTS = "escorts";
    private static final String INSERTDATA = "insertdata";
    private static final String HINT = "hint";
    private static final String POST_CLASSIFIED_ADVS = "postclassifiedadvs";
    private static final String CATEGORY = "category";
    private static final String POSTCATEGORY = "postcategory";
    private static final String SUBCATEGORY = "subcategory";
    private static final String POSTSUBCATEGORY = "postsubcategory";
    private static final String HOME = "home";
    private static final String ABOUTUS = "aboutus";
    private static final String HELP = "help";
    private static final String TERM = "term";
    private static final String ADVERTISE = "advertise";
    private static final String PRIVACY = "privacy";
    private static final String USERPROFILE = "userprofile";
    private static final String POSTUSERPROFILE = "postuserprofile";
    private static final String PAYMENTCATEGORY = "paymentcategory";
    private static final String ORGANIZATIONDETAILS = "organizationDetails";
    private static final String ADMINDETAILS = "admindetails";
    private static final String ADMINUSERLOGIN = "adminuserlogin";
    private static final String EDITDATA = "editdata";
    private static final String UPDATE = "update";
    private static final String SUB_CATEGORY_TYPE="subcategorytype";    
    private static final String CATEGOTYPAGE = "categorypage";
     private static final String ADSUCCESS="adsuccess";
    private static final String ADFAILURE="adfailure";
    
     private static final String FORGOTPASSWORD= "forgotpassword";
    private static final String ADMINFORGOTSUCCESS= "adminforgotsuccess";
    private static final String ADMINFORGOTFAILURE= "adminforgotfailure";
    

    public ActionForward categoryaction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int category = Integer.parseInt(request.getParameter("Category"));
        SubCategoryActionForm subCategoryActionForm = (SubCategoryActionForm) form;
        ClassifiedModel classifiedModel = new ClassifiedModel();
        ArrayList<CategoryVO> subcatlist = new ArrayList<CategoryVO>();
        subcatlist = classifiedModel.selectSubCate(category);
        subCategoryActionForm.setSubcatlist(subcatlist);
        return mapping.findForward(CATEGOTYPAGE);
    }

    public ActionForward subCategory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        //MobilePhonesFormBean mobilePhonesFormBean = (MobilePhonesFormBean) form;
        //BuyerSellerInfoBean buyerSellerInfoBean = (BuyerSellerInfoBean) request.getAttribute("BuyerSellerInfoBean");
        //HttpSession session = request.getSession(false);
        //classifiedIndiaFormBean.setClassifiedEmailId((String) session.getAttribute("username"));
        
        String subcategory = request.getParameter("subcatid");
        System.out.println("sneha" + subcategory);
        HttpSession session = request.getSession(true);
        session.setAttribute("subcategory", subcategory);
        return mapping.findForward(SUB_CATEGORY_TYPE);
    }

    public ActionForward hint(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(HINT);
    }

    public ActionForward adminuserlogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException {

        AdminActionForm adminActionForm = (AdminActionForm) form;
        AdminModel adminModel = new AdminModel();
        AdminProfileVO adminProfileVO = new AdminProfileVO();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");   
        boolean statuss = adminModel.validateAdminCredential(username, password);
        if(statuss==true){
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            System.out.println("vvv"+username+" "+password);
            return mapping.findForward(ADSUCCESS);
        }else{    
            request.setAttribute("msg1","Sorry! Username and password mismatch");
        return mapping.findForward(ADFAILURE);
        }
    }

    public ActionForward admindetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(ADMINDETAILS);
    }
    
        public ActionForward forgotpassword(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) {
        return mapping.findForward(FORGOTPASSWORD);
    }
    
    
    public ActionForward adminforgotpassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
            AdminForgotPasswordVO sd=new AdminForgotPasswordVO();
            AdminForgotPasswordModel ud=new AdminForgotPasswordModel();
            sd.setUsername(request.getParameter("username"));
            sd.setPassword(request.getParameter("password"));
            ud.doUpdate(sd);
            if (sd.getUsername() != null) {
                request.setAttribute("username", sd.getUsername());
                request.setAttribute("password", sd.getPassword());                
                return mapping.findForward("adminforgotsuccess");
            } 
            else {
                request.setAttribute("msg2","Sorry! Username is incorrect");
                return mapping.findForward("adminforgotfailure");
            }
    }
       

    /*public ActionForward organizationDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
     System.out.println("bbbbbbbbbbbbbbbbbbbbbbb");
     ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
     String classifiedId = request.getParameter("classifiedid");
     String photoId = request.getParameter("photoId");
     System.out.println(" photoId ::::::::::::::: " + photoId);
     /*  if(null == photoId || photoId.equalsIgnoreCase("")){
     photoId ="1";
     } 
     //String classifiedWebUrl = request.getParameter("classifiedweburl");
     ClassifiedModel classifiedModel = new ClassifiedModel();
     //ClassifiedIndiaVO classifiedIndiaVO = classifiedModel.populateClassifiedAdvDetails(classifiedId);

     System.out.println("  classified title  :: " + classifiedIndiaVO.getClassifiedTitle());

     List<Integer> classifiedsPhotoIds = classifiedModel.populateClassifiedPhotoIds(classifiedIndiaVO.getClassifiedId());
     System.out.println(" Number of Ids : " + classifiedsPhotoIds.size());
     classifiedIndiaFormBean.setClassifiedId(classifiedIndiaVO.getClassifiedId());
     classifiedIndiaFormBean.setClassifiedTitle(classifiedIndiaVO.getClassifiedTitle());
     classifiedIndiaFormBean.setClassifiedContactPerson(classifiedIndiaVO.getClassifiedContactPerson());
     classifiedIndiaFormBean.setClassifiedPrimaryContact(classifiedIndiaVO.getClassifiedPrimaryContact());
     classifiedIndiaFormBean.setClassifiedSecondaryContact(classifiedIndiaVO.getClassifiedSecondaryContact());
     classifiedIndiaFormBean.setClassifiedPostingDate(classifiedIndiaVO.getClassifiedPostingDate());
     classifiedIndiaFormBean.setClassifiedImage(classifiedIndiaVO.getClassifiedImage());
     classifiedIndiaFormBean.setClassifiedWebUrl(classifiedIndiaVO.getClassifiedWebUrl());
     classifiedIndiaFormBean.setClassifiedsPhotoIds(classifiedsPhotoIds);
     classifiedIndiaFormBean.setClassifiedPhotoId(photoId);

     //request.setAttribute("title", title);
     // request.setAttribute("contactperson", contactperson);
     // request.setAttribute("primarynumber", primarynumber);
     // request.setAttribute("secondarynumber", secondarynumber);
     // request.setAttribute("website", website);
     // request.setAttribute("postingdate", postingdate);
     //setAttribute("image", image);
     return mapping.findForward(ORGANIZATIONDETAILS);
     }
     */
    public ActionForward paymentcategory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(PAYMENTCATEGORY);
    }

    public ActionForward privacy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(PRIVACY);
    }

    public ActionForward advertise(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(ADVERTISE);
    }

    public ActionForward term(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(TERM);

    }

    public ActionForward help(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(HELP);

    }

    public ActionForward register(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(REGISTER);

    }

    public ActionForward postregister(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException {

             LoginActionForm loginActionForm = (LoginActionForm) form;
        ClassifiedModel classifiedModel = new ClassifiedModel();
        UserProfileVO userProfileVO = new UserProfileVO();

        String umail = loginActionForm.getUsername();
        String upass = loginActionForm.getPassword();
        String mob = loginActionForm.getMob();
        String gender = loginActionForm.getGender();
        String address =loginActionForm.getAddress();
        String nation = loginActionForm.getNationality();
        String state= loginActionForm.getStateid();
        String fullname= loginActionForm.getFullname();
        String district = loginActionForm.getDistrictid();
        String pin = loginActionForm.getDistrictid();
        String secqs = loginActionForm.getSecure();
        String secans = loginActionForm.getAns();
        boolean status = classifiedModel.checkUserCredential(umail);
        if (status == true) {
            //loginActionForm.setUsername(userProfileVO.getUsername());
            //if (umail.equals(loginActionForm.getUsername())) {
            request.setAttribute("message", "You have already signed in with your valid email id");
            return mapping.findForward(FAILTOREGISTER);
        } else {
            userProfileVO.setFullname(fullname);
            userProfileVO.setMob(mob);
            userProfileVO.setGender(gender);
            userProfileVO.setNationality(nation);
            userProfileVO.setUsername(umail);
            userProfileVO.setPassword(upass);
            userProfileVO.setAddress(address);
            userProfileVO.setStateid(state);
            userProfileVO.setDistrictid(district);
            userProfileVO.setPincode(pin);
            userProfileVO.setSecure(secqs);
            userProfileVO.setAnswer(secans);
            
            System.out.println("vvv" + userProfileVO.getUsername() + " " + userProfileVO.getPassword());
            request.setAttribute("umail", umail);
            classifiedModel.postRegisterADV(userProfileVO);
            return mapping.findForward(POSTREGISTER);

        }

    

    }

    public ActionForward viewads(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        ClassifiedModel classifiedModel = new ClassifiedModel();
        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        ClassifiedIndiaVO classifiedIndiaVO = new ClassifiedIndiaVO();
        DateConversion dateconnversion = new DateConversion();

        HttpSession session = request.getSession(false);
        String classifiedEmailId = (String) session.getAttribute("username");
        classifiedIndiaFormBean.setClassifiedEmailId(classifiedEmailId);
        classifiedIndiaVO.setClassifiedEmailId(classifiedIndiaFormBean.getClassifiedEmailId());
        try {

            classifiedModel.populateClassifiedAdv(classifiedIndiaVO);
            //Integer.parseInt(classifiedIndiaFormBean.setClassifiedBookingDuration(classifiedIndiaVO.getClassifiedBookingDuration()));
            classifiedIndiaFormBean.setClassifiedId((String) classifiedIndiaVO.getClassifiedId());
            classifiedIndiaFormBean.setClassifiedCategory((String) classifiedIndiaVO.getClassifiedCategory());
            classifiedIndiaFormBean.setClassifiedCategoryName(classifiedIndiaVO.getClassifiedCategoryName());
            classifiedIndiaFormBean.setClassifiedSubCategory((String) classifiedIndiaVO.getClassifiedSubCategory());
            classifiedIndiaFormBean.setClassifiedSubCategoryName(classifiedIndiaVO.getClassifiedSubCategoryName());
            classifiedIndiaFormBean.setClassifiedSubject(classifiedIndiaVO.getClassifiedSubject());
            classifiedIndiaFormBean.setClassifiedContactPerson(classifiedIndiaVO.getClassifiedContactPerson());
            //classifiedIndiaFormBean.setClassifiedEmailId(classifiedIndiaVO.getClassifiedEmailId());
            classifiedIndiaFormBean.setClassifiedPrimaryContact(classifiedIndiaVO.getClassifiedPrimaryContact());
            classifiedIndiaFormBean.setClassifiedSecondaryContact(classifiedIndiaVO.getClassifiedSecondaryContact());
            classifiedIndiaFormBean.setClassifiedWebUrl(classifiedIndiaVO.getClassifiedWebUrl());
            classifiedIndiaFormBean.setClassifiedOrganizationName(classifiedIndiaVO.getClassifiedOrganizationName());
            classifiedIndiaFormBean.setClassifiedImageId(classifiedIndiaVO.getClassifiedImageId());

            String newpost = dateconnversion.convertDbDate(classifiedIndiaVO.getClassifiedPostingDate());
            String newexp = dateconnversion.convertDbDate(classifiedIndiaVO.getClassifiedExpireDate());
            String newexpwarn = dateconnversion.convertDbDate(classifiedIndiaVO.getClassifiedExpireWarrningDate());

            classifiedIndiaFormBean.setClassifiedPostingDate(newpost);
            classifiedIndiaFormBean.setClassifiedExpireDate(newexp);
            classifiedIndiaFormBean.setClassifiedExpireWarrningDate(newexpwarn);
            /* */

            /*  
             session.setAttribute("classifiedSubject", classifiedIndiaFormBean.getClassifiedSubject());
             session.setAttribute("classifiedPrimaryContact", classifiedIndiaFormBean.getClassifiedPrimaryContact());
             session.setAttribute("classifiedSecondaryContact", classifiedIndiaFormBean.getClassifiedSecondaryContact());
             session.setAttribute("classifiedContactPerson", classifiedIndiaFormBean.getClassifiedContactPerson());
             //session.setAttribute("classifiedEmailId", request.getParameter("classifiedEmailId"));
             session.setAttribute("classifiedWebUrl", classifiedIndiaFormBean.getClassifiedWebUrl());
             session.setAttribute("classifiedPostingDate", classifiedIndiaFormBean.getClassifiedPostingDate());
             //session.setAttribute("classifiedPaymentCategory", request.getParameter("classifiedPaymentCategory"));            
             session.setAttribute("classifiedCategory", classifiedIndiaFormBean.getClassifiedCategory());
             session.setAttribute("classifiedCategoryName", classifiedIndiaFormBean.getClassifiedCategoryName());
             session.setAttribute("classifiedSubCategory", classifiedIndiaFormBean.getClassifiedSubCategory());
             session.setAttribute("classifiedSubCategoryName", classifiedIndiaFormBean.getClassifiedSubCategoryName());
             System.out.println("www"+session.getAttribute("classifiedSubCategoryName"));
             //session.setAttribute("classifiedPostingDate", classifiedIndiaFormBean.getClassifiedPostingDate());
             session.setAttribute("classifiedExpireDate", classifiedIndiaFormBean.getClassifiedExpireDate());
             session.setAttribute("classifiedExpireWarrningDate", classifiedIndiaFormBean.getClassifiedExpireWarrningDate());
             session.setAttribute("classifiedOrganizationName", classifiedIndiaFormBean.getClassifiedOrganizationName());
             /*  */
            //request.setAttribute("classifiedadv", listOfClassifiedAdvs);
        } catch (Exception exception) {

        }
        return mapping.findForward(VIEWADS);

    }

    public ActionForward mydashboard(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        ArrayList<ClassifiedIndiaVO> mydashList = new ArrayList<ClassifiedIndiaVO>();
        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        ClassifiedIndiaVO classifiedIndiaVO = new ClassifiedIndiaVO();
        DateConversion dateconnversion = new DateConversion();
        ClassifiedModel classifiedModel = new ClassifiedModel();

        HttpSession session = request.getSession(false);
        String classifiedEmailId = (String) session.getAttribute("username");
        try {
            mydashList = classifiedModel.populateMyDashlist(classifiedEmailId);
            classifiedIndiaFormBean.setMydashList(mydashList);
            //request.setAttribute("classifiedads2", listofClassifiedAdvs);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return mapping.findForward(MYDASHBOARD);
    }

    public ActionForward mydashedit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        ClassifiedIndiaVO classifiedIndiaVO = new ClassifiedIndiaVO();
        ClassifiedModel classifiedModel = new ClassifiedModel();
        HttpSession session = request.getSession(true);
        session.setAttribute("classifiedId", request.getParameter("adsid"));
        //String classifiedId = (String) request.getParameter("adsid");
        classifiedIndiaFormBean.setClassifiedId((String) session.getAttribute("classifiedId"));
        classifiedIndiaVO.setClassifiedId(classifiedIndiaFormBean.getClassifiedId());
        classifiedModel.populateClassifiedAdvDetails(classifiedIndiaVO);

        classifiedIndiaFormBean.setClassifiedCategoryName(classifiedIndiaVO.getClassifiedCategoryName());
        classifiedIndiaFormBean.setClassifiedCategory(classifiedIndiaVO.getClassifiedCategory());
        classifiedIndiaFormBean.setClassifiedSubCategory(classifiedIndiaVO.getClassifiedSubCategory());
        classifiedIndiaFormBean.setClassifiedSubCategoryName(classifiedIndiaVO.getClassifiedSubCategoryName());
        classifiedIndiaFormBean.setClassifiedSubject(classifiedIndiaVO.getClassifiedSubject());
        classifiedIndiaFormBean.setClassifiedPrimaryContact(classifiedIndiaVO.getClassifiedPrimaryContact());
        classifiedIndiaFormBean.setClassifiedSecondaryContact(classifiedIndiaVO.getClassifiedSecondaryContact());
        classifiedIndiaFormBean.setClassifiedContactPerson(classifiedIndiaVO.getClassifiedContactPerson());
        classifiedIndiaFormBean.setClassifiedEmailId(classifiedIndiaVO.getClassifiedEmailId());
        classifiedIndiaFormBean.setClassifiedWebUrl(classifiedIndiaVO.getClassifiedWebUrl());
        classifiedIndiaFormBean.setClassifiedOrganizationName(classifiedIndiaVO.getClassifiedOrganizationName());
        classifiedIndiaFormBean.setClassifiedExpireDate(classifiedIndiaVO.getClassifiedExpireDate());
        classifiedIndiaFormBean.setClassifiedExpireWarrningDate(classifiedIndiaVO.getClassifiedExpireWarrningDate());
        return mapping.findForward(MYDASHEDIT);
    }
    /*
     public ActionForward matrimonial(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
     List<ClassifiedIndiaVO> listofClassifiedAdvs = new ArrayList<ClassifiedIndiaVO>();
     ClassifiedModel classifiedModel = new ClassifiedModel();
     String category = "2";
     try {
            
     listofClassifiedAdvs = classifiedModel.populateClassifiedAdv3(category);
     request.setAttribute("classifiedads3", listofClassifiedAdvs);
     } catch (Exception exception) {
            
     }
        
     return mapping.findForward(MATRIMONIAL);
        
     }*/

    public ActionForward propertyforsale(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        List<ClassifiedIndiaVO> listofClassifiedAdvs = new ArrayList<ClassifiedIndiaVO>();
        ClassifiedModel classifiedModel = new ClassifiedModel();
        String category = "3";
        try {

            listofClassifiedAdvs = classifiedModel.populateClassifiedAdv4(category);
            request.setAttribute("classifiedads4", listofClassifiedAdvs);
        } catch (Exception exception) {

        }

        return mapping.findForward(PROPERTY_FOR_SALE);
    }

    public ActionForward guesthouses(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(GUESTHOUSES);
    }

    public ActionForward businessproposal(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(BUSINESS_PROPOSAL);

    }

    public ActionForward holidaytimes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(HOLIDAY_TIMES);

    }

    public ActionForward culturalevents(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(CULTURAL_EVENTS);

    }

    public ActionForward escorts(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(ESCORTS);

    }

    public ActionForward insertdata(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        BuyerSellerInfoBean buyerSellerInfoBean = (BuyerSellerInfoBean) request.getAttribute("BuyerSellerInfoBean");
        HttpSession session = request.getSession(false);
        classifiedIndiaFormBean.setClassifiedEmailId((String) session.getAttribute("username"));
        
        /*classifiedIndiaFormBean.setClassifiedSubCategory(request.getParameter("param"));
         System.out.println("hhh"+classifiedIndiaFormBean.getClassifiedSubCategory());
         HttpSession session = request.getSession(false);
         classifiedIndiaFormBean.setClassifiedCategoryName((String)session.getAttribute("categoryname"));
         System.out.println("mm"+classifiedIndiaFormBean.getClassifiedCategoryName());
         classifiedIndiaFormBean.setClassifiedCategory(String.valueOf((Integer)session.getAttribute("categoryid")));
         System.out.println("oo"+classifiedIndiaFormBean.getClassifiedCategory());*/
        return mapping.findForward(INSERTDATA);

    }

    public ActionForward postclassifiedadvs(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        
        return mapping.findForward(POST_CLASSIFIED_ADVS);

    }

    public ActionForward classifiedCategory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(POST_CLASSIFIED_ADVS);

    }

    public ActionForward category(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(CATEGORY);

    }

    public ActionForward postcategory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubCategoryActionForm categoryActionForm = (SubCategoryActionForm) form;

        ClassifiedModel classifiedModel = new ClassifiedModel();

        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setCategory(categoryActionForm.getCategory());
        categoryVO.setSubcategoryName(categoryActionForm.getSubcategoryName());
        classifiedModel.postCategoryAdv(categoryVO);
        return mapping.findForward(POSTCATEGORY);

    }

    public ActionForward subcategory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(SUBCATEGORY);

    }

    public ActionForward postsubcategory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubCategoryActionForm categoryActionForm = (SubCategoryActionForm) form;
        ClassifiedModel classifiedModel = new ClassifiedModel();

        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setSubcategoryName(categoryActionForm.getSubcategoryName());
        classifiedModel.postSubcategoryAdv(categoryVO);
        return mapping.findForward(POSTSUBCATEGORY);

    }

    public ActionForward userprofile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(USERPROFILE);

    }

    public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(HOME);

    }

    public ActionForward aboutus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(ABOUTUS);

    }

    public ActionForward editdata(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        DateConversion dateconnversion = new DateConversion();
        HttpSession session = request.getSession(true);
        session.setAttribute("classifiedId", request.getParameter("adsid"));
        //String classifiedID = request.getParameter("adsid");
        //String newexp = dateconnversion.convertDbDate((String) session.getAttribute("classifiedExpireDate"));
        //String newexpwarn = dateconnversion.convertDbDate((String) session.getAttribute("classifiedExpireWarrningDate"));

        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        classifiedIndiaFormBean.setClassifiedId((String) session.getAttribute("classifiedId"));
        classifiedIndiaFormBean.setClassifiedCategoryName((String) session.getAttribute("classifiedCategoryName"));
        classifiedIndiaFormBean.setClassifiedCategory((String) session.getAttribute("classifiedCategory"));
        classifiedIndiaFormBean.setClassifiedSubCategory((String) session.getAttribute("classifiedSubCategory"));
        classifiedIndiaFormBean.setClassifiedSubCategoryName((String) session.getAttribute("classifiedSubCategoryName"));
        classifiedIndiaFormBean.setClassifiedSubject((String) session.getAttribute("classifiedSubject"));
        classifiedIndiaFormBean.setClassifiedPrimaryContact((String) session.getAttribute("classifiedPrimaryContact"));
        classifiedIndiaFormBean.setClassifiedSecondaryContact((String) session.getAttribute("classifiedSecondaryContact"));
        classifiedIndiaFormBean.setClassifiedContactPerson((String) session.getAttribute("classifiedContactPerson"));
        classifiedIndiaFormBean.setClassifiedEmailId((String) session.getAttribute("username"));
        classifiedIndiaFormBean.setClassifiedImageId((Double) session.getAttribute("generatedFloat"));
        classifiedIndiaFormBean.setClassifiedWebUrl((String) session.getAttribute("classifiedWebUrl"));
        classifiedIndiaFormBean.setClassifiedOrganizationName((String) session.getAttribute("classifiedOrganizationName"));
        classifiedIndiaFormBean.setClassifiedExpireDate((String) session.getAttribute("classifiedExpireDate"));
        classifiedIndiaFormBean.setClassifiedExpireWarrningDate((String) session.getAttribute("classifiedExpireWarrningDate"));

        return mapping.findForward(EDITDATA);
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        ClassifiedIndiaVO classifiedIndiaVO = new ClassifiedIndiaVO();
        ClassifiedModel classifiedModel = new ClassifiedModel();

        HttpSession session = request.getSession(false);
        classifiedIndiaFormBean.setClassifiedId((String) session.getAttribute("classifiedId"));
        System.out.println("sneh" + classifiedIndiaFormBean.getClassifiedId());
        classifiedIndiaFormBean.setClassifiedEmailId((String) session.getAttribute("username"));
        classifiedIndiaVO.setClassifiedId(classifiedIndiaFormBean.getClassifiedId());
        classifiedIndiaVO.setClassifiedCategory(classifiedIndiaFormBean.getClassifiedCategory());
        classifiedIndiaVO.setClassifiedSubCategory(classifiedIndiaFormBean.getClassifiedSubCategory());
        classifiedIndiaVO.setClassifiedSubject(classifiedIndiaFormBean.getClassifiedSubject());
        classifiedIndiaVO.setClassifiedPrimaryContact(classifiedIndiaFormBean.getClassifiedPrimaryContact());
        classifiedIndiaVO.setClassifiedSecondaryContact(classifiedIndiaFormBean.getClassifiedSecondaryContact());
        classifiedIndiaVO.setClassifiedContactPerson(classifiedIndiaFormBean.getClassifiedContactPerson());
        classifiedIndiaVO.setClassifiedEmailId(classifiedIndiaFormBean.getClassifiedEmailId());
        classifiedIndiaVO.setClassifiedWebUrl(classifiedIndiaFormBean.getClassifiedWebUrl());
        classifiedIndiaVO.setClassifiedActiveDeactiveStatus(Boolean.valueOf(classifiedIndiaFormBean.getClassifiedActiveDeactiveStatus()));
        //classifiedIndiaVO.setClassifiedBookingDuration(Integer.parseInt(classifiedIndiaFormBean.getClassifiedBookingDuration()));
        //classifiedIndiaVO.setClassifiedPostingDate(classifiedIndiaFormBean.getClassifiedPostingDate());
        classifiedIndiaVO.setClassifiedExpireDate(classifiedIndiaFormBean.getClassifiedExpireDate());
        classifiedIndiaVO.setClassifiedExpireWarrningDate(classifiedIndiaFormBean.getClassifiedExpireWarrningDate());
        classifiedIndiaVO.setClassifiedPaymentCategory(classifiedIndiaFormBean.getClassifiedPaymentCategory());

        boolean b = classifiedModel.updateClassifiedAd(classifiedIndiaVO);
        return mapping.findForward(UPDATE);
    }
    private static final String SEARCHPAGE = "searchpage";

    public ActionForward searchResult(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ClassifiedIndiaFormBean classifiedIndiaFormBean = (ClassifiedIndiaFormBean) form;
        ArrayList<ClassifiedIndiaVO> searchList = new ArrayList<ClassifiedIndiaVO>();
        ClassifiedIndiaVO classifiedIndiaVO = new ClassifiedIndiaVO();
        ClassifiedModel classifiedModel = new ClassifiedModel();
        String searchWord = request.getParameter("searchWord");
        classifiedIndiaVO.setSearchWord(classifiedIndiaFormBean.getSearchWord());

        searchList = classifiedModel.populateClassifiedSearchList(searchWord);
        classifiedIndiaFormBean.setSearchList(searchList);

        return mapping.findForward(SEARCHPAGE);
    }
}
