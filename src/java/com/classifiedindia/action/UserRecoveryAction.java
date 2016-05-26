/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.action;

import com.classifiedindia.formbean.LoginActionForm;
import com.classifiedindia.formbean.PasswordActionForm;
import com.classifiedindia.model.AdminForgotPasswordModel;
import com.classifiedindia.model.PasswordFetchImp;
import com.classifiedindia.model.UserPassChangeModel;
import com.classifiedindia.vo.AdminForgotPasswordVO;
import com.classifiedindia.vo.UserPassChangeVO;
import com.classifiedindia.vo.UserProfileVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author HP PC
 */
public class UserRecoveryAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String FORGOTPASSWORD = "forgotpassword";
      private final static String FAILTOREGISTER = "failtoregister";
      private final static String USERPASSCHANGESUCCESS = "userpasschangesuccess";
      private final static String USERPASSCHANGEFAILURE = "userpasschangefailure";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward passwordrecovery (ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
           
               
           LoginActionForm pp=(LoginActionForm) form;
           
            PasswordFetchImp pf = new PasswordFetchImp();
            UserProfileVO up= new UserProfileVO();
            
//            up.setUsername(pp.getUsername());
//           up.setSecure(pp.getSecure());
//          up.setAnswer(pp.getAns());
//            
            String uname= request.getParameter("username");
            String secure= request.getParameter("secure");
            String ans= request.getParameter("ans");
            
            
            System.out.println("checking" + request.getParameter("username"));

             System.out.println("checking" + request.getParameter("secure"));
              System.out.println("checking" + request.getParameter("ans"));
//            pf.saveDetails(up);
//            
//             
//               pp.setUsername(up.getUsername());
//               pp.setSecure(up.getSecure());
//               pp.setAns(up.getAnswer());
            
            boolean status = pf.saveDetails(uname,secure,ans);
            
            if(status==true){
                HttpSession session = request.getSession(true);
                session.setAttribute("username", uname);
                session.setAttribute("secure", secure);
                session.setAttribute("ans", ans);
                 return mapping.findForward(FORGOTPASSWORD);
                
            
            }
            else{
            
                request.setAttribute("message", "Please fill up with your correct details");
                return mapping.findForward(FAILTOREGISTER);
            }
               
               
//               System.out.println(""+pp.getUsername());
            
       
    
 }
    
      public ActionForward Userforgotpassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
            UserPassChangeVO sd=new UserPassChangeVO();
            UserPassChangeModel ud=new UserPassChangeModel();
            sd.setNewpassword(request.getParameter("newpassword"));
            sd.setConfirmpassword(request.getParameter("confirmpassword"));
           
            ud.doUpdate(sd);
            if (sd.getNewpassword() != null) {
                request.setAttribute("newpassword", sd.getNewpassword());
                request.setAttribute("confirmpassword", sd.getConfirmpassword());                
                return mapping.findForward("userpasschangesuccess");
            } 
            else {
                request.setAttribute("msg2","Sorry! Username is incorrect");
                return mapping.findForward("userpasschangefailure");
            }
      }}