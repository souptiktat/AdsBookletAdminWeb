/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.MobiIncludeBean;
import com.classified.admin.models.MobiIncludeModel;
import com.classified.admin.vo.MobiIncludeVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author a
 */
public class MobiIncludeAction extends org.apache.struts.actions.MappingDispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
   
    public ActionForward viewAllMobiIncludeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiIncludeModel mobiIncludeInfo=new MobiIncludeModel();
        List<MobiIncludeVO> listOfMobiInclude=mobiIncludeInfo.viewAllMobileIncludeInfo();
        MobiIncludeBean mobiIncludeBean=(MobiIncludeBean)form;
        mobiIncludeBean.setListOfMobiIncludes(listOfMobiInclude);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteMobiIncludeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiIncludeBean mobiIncludeBean1=(MobiIncludeBean)form;
        MobiIncludeModel mobiIncludeModel= new MobiIncludeModel();
        int includ_tab_id=0;
        if(null!=request.getParameter("includ_tab_id")){
            includ_tab_id=Integer.parseInt(request.getParameter("includ_tab_id"));
        }
        if(0!=mobiIncludeBean1.getInclud_tab_id()){
            includ_tab_id=mobiIncludeBean1.getInclud_tab_id();
        }
        if(0!=includ_tab_id){
            ResultVO resultVO=mobiIncludeModel.deleteMobileIncludeInfo(includ_tab_id);
            List<MobiIncludeVO> listOfMobiInclude1=mobiIncludeModel.viewAllMobileIncludeInfo();
            mobiIncludeBean1.setListOfMobiIncludes(listOfMobiInclude1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiIncludeInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Type Record........");
        MobiIncludeBean mobiIncludeBean2=(MobiIncludeBean)form;
        MobiIncludeModel mobiIncludeModel2= new MobiIncludeModel();
        MobiIncludeVO mobiIncludeVO2 = new MobiIncludeVO();
        int includ_tab_id=0;
        if(null!=request.getParameter("includ_tab_id")){
            includ_tab_id=Integer.parseInt(request.getParameter("includ_tab_id"));
        }
        if(0!=mobiIncludeBean2.getInclud_tab_id()){
            includ_tab_id=mobiIncludeBean2.getInclud_tab_id();
        }
        if(0!=includ_tab_id){
            MobiIncludeVO accessoryTypeVO = mobiIncludeModel2.populateMobileIncludeInfo(includ_tab_id);
            mobiIncludeBean2.setInclud_tab_id(mobiIncludeVO2.getInclud_tab_id());
            mobiIncludeBean2.setMobile_adv_id(mobiIncludeVO2.getMobile_adv_id());
            mobiIncludeBean2.setInclud_id(mobiIncludeVO2.getInclud_id());
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiIncludeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiIncludeBean mobiIncludeBean3 = (MobiIncludeBean)form;
        MobiIncludeModel mobiIncludeModel3= new MobiIncludeModel();
        int includ_tab_id=mobiIncludeBean3.getInclud_tab_id();
        int mobile_adv_id=mobiIncludeBean3.getMobile_adv_id();
        int includ_id=mobiIncludeBean3.getInclud_id();
        MobiIncludeVO mobiIncludeVO3=new MobiIncludeVO();
        mobiIncludeVO3.setInclud_tab_id(includ_tab_id);
        mobiIncludeVO3.setMobile_adv_id(mobile_adv_id);
        mobiIncludeVO3.setInclud_id(includ_id);
        mobiIncludeVO3=mobiIncludeModel3.modifyMobileIncludeInfo(mobiIncludeVO3);
        List<MobiIncludeVO> listOfMobiInclude3= mobiIncludeModel3.viewAllMobileIncludeInfo();
        mobiIncludeBean3.setListOfMobiIncludes(listOfMobiInclude3);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addMobiIncludeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiIncludeBean mobiIncludeBean4= (MobiIncludeBean)form;
        MobiIncludeModel mobiIncludeModel4= new MobiIncludeModel();
        MobiIncludeVO mobiIncludeVO4= new MobiIncludeVO();
        int includ_tab_id= mobiIncludeBean4.getInclud_tab_id();
        int mobile_adv_id= mobiIncludeBean4.getMobile_adv_id();
        int includ_id= mobiIncludeBean4.getInclud_id();
        boolean status= mobiIncludeModel4.checkMobileIncludeCredential(includ_tab_id);
        if(status== true){
            request.setAttribute("message", "Mobile Inclusion Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            mobiIncludeVO4.setInclud_tab_id(includ_tab_id);
            mobiIncludeVO4.setMobile_adv_id(mobile_adv_id);
            mobiIncludeVO4.setInclud_id(includ_id);
            mobiIncludeModel4.postMobileInclude(mobiIncludeVO4);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
