/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.MobiNoofsimBean;
import com.classified.admin.models.MobiNoofsimModel;
import com.classified.admin.vo.MobiNoofsimVO;
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
public class MobiNoofsimAction extends org.apache.struts.actions.MappingDispatchAction {

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
    public ActionForward viewAllMobiNoofsimRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiNoofsimModel mobiNoofsimInfo=new MobiNoofsimModel();
        List<MobiNoofsimVO> listOfMobiNoofsim=mobiNoofsimInfo.viewAllMobiNoofsimInfo();
        MobiNoofsimBean mobiNoofsimBean=(MobiNoofsimBean)form;
        mobiNoofsimBean.setListOfMobiNoofsim(listOfMobiNoofsim);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteMobiNoofsimRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiNoofsimBean mobiNoofsimBean=(MobiNoofsimBean)form;
        MobiNoofsimModel mobiNoofsimModel= new MobiNoofsimModel();
        int noof_id=0;
        if(null!=request.getParameter("noof_id")){
            noof_id=Integer.parseInt(request.getParameter("noof_id"));
        }
        if(0!=mobiNoofsimBean.getNoof_id()){
            noof_id=mobiNoofsimBean.getNoof_id();
        }
        if(0!=noof_id){
            ResultVO resultVO=mobiNoofsimModel.deleteMobiNoofsimInfo(noof_id);
            List<MobiNoofsimVO> listOfMobiNoofsim1=mobiNoofsimModel.viewAllMobiNoofsimInfo();
            mobiNoofsimBean.setListOfMobiNoofsim(listOfMobiNoofsim1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiNoofsimInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Type Record........");
        MobiNoofsimBean mobiNoofsimBean1=(MobiNoofsimBean)form;
        MobiNoofsimModel mobiNoofsimModel1= new MobiNoofsimModel();
        MobiNoofsimVO mobiNoofsimVO = new MobiNoofsimVO();
        int noof_id=0;
        if(null!=request.getParameter("noof_id")){
            noof_id=Integer.parseInt(request.getParameter("noof_id"));
        }
        if(0!=mobiNoofsimBean1.getNoof_id()){
            noof_id=mobiNoofsimBean1.getNoof_id();
        }
        if(0!=noof_id){
            MobiNoofsimVO mobiNoofsimVO1 = mobiNoofsimModel1.populateMobiNoofsimInfo(noof_id);
            mobiNoofsimBean1.setNoof_id(mobiNoofsimVO.getNoof_id());
            mobiNoofsimBean1.setNoof_name(mobiNoofsimVO.getNoof_name());
            
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyMobiNoofsimRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiNoofsimBean mobiNoofsimBean2 = (MobiNoofsimBean)form;
        MobiNoofsimModel mobiNoofsimModel2= new MobiNoofsimModel();
        int noof_id=mobiNoofsimBean2.getNoof_id();
        String noof_name=mobiNoofsimBean2.getNoof_name();
        MobiNoofsimVO mobiNoofsimVO1=new MobiNoofsimVO();
        mobiNoofsimVO1.setNoof_id(noof_id);
        mobiNoofsimVO1.setNoof_name(noof_name);
        mobiNoofsimVO1=mobiNoofsimModel2.modifyMobiNoofsimInfo(mobiNoofsimVO1);
        List<MobiNoofsimVO> listOfmobiNoofsim1= mobiNoofsimModel2.viewAllMobiNoofsimInfo();
        mobiNoofsimBean2.setListOfMobiNoofsim(listOfmobiNoofsim1);
        return mapping.findForward(SUCCESS);
    }
    
    
    
    public ActionForward addMobiNoofsimRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiNoofsimBean mobiNoofsimBean3= (MobiNoofsimBean)form;
        MobiNoofsimModel mobiNoofsimModel3= new MobiNoofsimModel();
        MobiNoofsimVO mobiNoofsimVO= new MobiNoofsimVO();
        int noof_id= mobiNoofsimBean3.getNoof_id();
        String noof_name= mobiNoofsimBean3.getNoof_name();
        boolean status= mobiNoofsimModel3.checkMobiNoofsimCredential(noof_id);
        if(status== true){
            request.setAttribute("message", "Sim Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            mobiNoofsimVO.setNoof_id(noof_id);
            mobiNoofsimVO.setNoof_name(noof_name);
            mobiNoofsimModel3.postMobiNoofsim(mobiNoofsimVO);
        return mapping.findForward(SUCCESS);
        }
    }
}
