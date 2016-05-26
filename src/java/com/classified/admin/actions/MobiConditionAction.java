/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.MobiConditionBean;
import com.classified.admin.models.MobiConditionModel;
import com.classified.admin.vo.MobiConditionVO;
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
public class MobiConditionAction extends org.apache.struts.actions.MappingDispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private Object mobileBrandInfo;

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
  
    public ActionForward viewAllMobiCondInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiConditionModel mobiCondInfo=new MobiConditionModel();
        List<MobiConditionVO> listOfMobiCondition=mobiCondInfo.viewAllMobiCondInfo();
        MobiConditionBean mobiCondBean=(MobiConditionBean)form;
        mobiCondBean.setListOfMobileCond(listOfMobiCondition);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteMobiCondRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiConditionBean mobiCondBean=(MobiConditionBean)form;
        MobiConditionModel mobiCondModel= new MobiConditionModel();
        String cond_id=null;
        if(null!=request.getParameter("cond_id")){
            cond_id=request.getParameter("cond_id");
        }
        if(null!=mobiCondBean.getCond_id()){
            cond_id=mobiCondBean.getCond_id();
        }
        if(null!=cond_id){
            ResultVO resultVO=mobiCondModel.deleteMobiCondInfo(cond_id);
            List<MobiConditionVO> listOfMobiCondition1=mobiCondModel.viewAllMobiCondInfo();
            mobiCondBean.setListOfMobileCond(listOfMobiCondition1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiCondInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Brand Record........");
        MobiConditionBean mobiCondBean1=(MobiConditionBean)form;
        MobiConditionModel mobiCondModel1= new MobiConditionModel();
        MobiConditionVO mobiCondVO1 = new MobiConditionVO();
        String cond_id=null;
        if(null!=request.getParameter("cond_id")){
            cond_id=request.getParameter("cond_id");
        }
        if(null!=mobiCondBean1.getCond_id()){
            cond_id=mobiCondBean1.getCond_id();
        }
        if(null!=cond_id){
            MobiConditionVO mobileBrandVO = mobiCondModel1.populateMobiCondInfo(cond_id);
            mobiCondBean1.setCond_id(mobiCondVO1.getCond_id());
            mobiCondBean1.setCond_name(mobiCondVO1.getCond_name());          
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiCondRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiConditionBean mobiCondBean2 = (MobiConditionBean)form;
        MobiConditionModel mobiCondModel2= new MobiConditionModel();
        String cond_id=mobiCondBean2.getCond_id();
        String cond_name=mobiCondBean2.getCond_name();
        MobiConditionVO mobileBrandVO1=new MobiConditionVO();
        mobileBrandVO1.setCond_id(cond_id);
        mobileBrandVO1.setCond_name(cond_name);
        mobileBrandVO1=mobiCondModel2.modifyMobiCondInfo(mobileBrandVO1);
        List<MobiConditionVO> listOfMobiCond1= mobiCondModel2.viewAllMobiCondInfo();
        mobiCondBean2.setListOfMobileCond(listOfMobiCond1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addMobiCondRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)  
            throws Exception {
        MobiConditionBean mobiCondBean3= (MobiConditionBean)form;
        MobiConditionModel mobiCondModel3= new MobiConditionModel();
        MobiConditionVO mobiCondVO= new MobiConditionVO();
        String cond_id= mobiCondBean3.getCond_id();
        String cond_name= mobiCondBean3.getCond_name();
        boolean status= mobiCondModel3.checkMobiCondCredential(cond_id);
        if(status== true){
            request.setAttribute("message", "Mobile Condition Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            mobiCondVO.setCond_id(cond_id);
            mobiCondVO.setCond_name(cond_name);
            mobiCondModel3.postMobiCond(mobiCondVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
