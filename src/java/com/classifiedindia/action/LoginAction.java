package com.classifiedindia.action;

import com.classifiedindia.formbean.LoginActionForm;
import com.classifiedindia.formbean.UserLoginForm;
import com.classifiedindia.formbean.UserProfileActionForm;
import com.classifiedindia.model.ClassifiedModel;
import com.classifiedindia.vo.UserProfileVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends org.apache.struts.actions.MappingDispatchAction {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String ADSUCCESS = "adsuccess";
    public static final String ADFAILURE = "adfailure";

    public ActionForward userLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

//UserProfileActionForm loginActionForm = (UserProfileActionForm) form;
    /*    LoginActionForm loginActionForm = (LoginActionForm) form;
         String userName = loginActionForm.getUsername();
         String password = loginActionForm.getPassword();
         System.out.println(" userName :: " + userName);
         System.out.println(" password :: " + password);

         if (null != userName && null != password) {
         ClassifiedModel classifiedModel = new ClassifiedModel();
         UserProfileVO userProfileVO = new UserProfileVO();
         userProfileVO.setUsername(userName);
         userProfileVO.setPassword(password);
         boolean userFlag = classifiedModel.validateUserCredential(userProfileVO);

         if (userFlag) {
         return mapping.findForward("success");
         } else {
         return mapping.findForward("failure");
         }
         } else {
         // not allowed

         return mapping.findForward("failure");
         }*/
        UserLoginForm loginActionForm = (UserLoginForm) form;
        ClassifiedModel classifiedModel = new ClassifiedModel();
        UserProfileVO userProfileVO = new UserProfileVO();
        
        String umail = request.getParameter("username");
        String upass = request.getParameter("password");
        
        boolean statuss = classifiedModel.validateUserCredential(umail, upass);
        if(statuss==true){
            HttpSession session = request.getSession(true);
            session.setAttribute("username", umail);
            session.setAttribute("password", upass);
            session.setAttribute("message1", umail);
            session.setAttribute("flash_message", "Hello "+umail+". .You are now logged in!");
            return mapping.findForward(SUCCESS);
        }else{        
        return mapping.findForward(FAILURE);
        }
    }
    public ActionForward adminuserlogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginActionForm loginActionForm = (LoginActionForm) form;
        ClassifiedModel classifiedModel = new ClassifiedModel();
        UserProfileVO userProfileVO = new UserProfileVO();
        
        String umail = request.getParameter("username");
        String upass = request.getParameter("password");
        
        boolean statuss = classifiedModel.validateUserCredential(umail, upass);
        if(statuss==true){
            HttpSession session = request.getSession(true);
            session.setAttribute("username", umail);
            session.setAttribute("password", upass);
            System.out.println("vvv"+umail+" "+upass);
            return mapping.findForward(ADSUCCESS);
        }else{        
        return mapping.findForward(ADFAILURE);
        }
    }
    
}
