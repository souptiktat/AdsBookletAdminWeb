/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.MobiModelBean;
import com.classified.admin.models.MobiModelModel;
import com.classified.admin.vo.MobiModelVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author a
 */
public class MobiModelAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward viewAllMobiModelRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiModelModel mobiModelInfo=new MobiModelModel();
        List<MobiModelVO> listOfMobiModel=mobiModelInfo.viewAllMobiModelInfo();
        MobiModelBean mobiModelBean=(MobiModelBean)form;
        mobiModelBean.setListMobiModel(listOfMobiModel);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteMobiModelRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiModelBean mobiModelBean=(MobiModelBean)form;
        MobiModelModel mobiModelModel= new MobiModelModel();
        int model_id=0;
        if(null!=request.getParameter("model_id")){
            model_id=Integer.parseInt(request.getParameter("model_id"));
        }
        if(0!=mobiModelBean.getModel_id()){
            model_id=mobiModelBean.getModel_id();
        }
        if(0!=model_id){
            ResultVO resultVO=mobiModelModel.deleteMobiModelInfo(model_id);
            List<MobiModelVO> listOfMobiModel1=mobiModelModel.viewAllMobiModelInfo();
            mobiModelBean.setListMobiModel(listOfMobiModel1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiModelInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Type Record........");
        MobiModelBean mobiModelBean1=(MobiModelBean)form;
        MobiModelModel mobiModelModel1= new MobiModelModel();
        MobiModelVO mobiModelVO = new MobiModelVO();
        int model_id=0;
        if(null!=request.getParameter("model_id")){
            model_id=Integer.parseInt(request.getParameter("model_id"));
        }
        if(0!=mobiModelBean1.getModel_id()){
            model_id=mobiModelBean1.getModel_id();
        }
        if(0!=model_id){
            MobiModelVO mobiModelVO1 = mobiModelModel1.populateMobiModelInfo(model_id);
            mobiModelBean1.setModel_id(mobiModelVO.getModel_id());
            mobiModelBean1.setBrand_id(mobiModelVO.getBrand_id());
            mobiModelBean1.setModel_name(mobiModelVO.getModel_name());
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiModelRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiModelBean mobiModelBean2 = (MobiModelBean)form;
        MobiModelModel mobiModelModel2= new MobiModelModel();
        int model_id=mobiModelBean2.getModel_id();
        int brand_id=mobiModelBean2.getBrand_id();
        String model_name=mobiModelBean2.getModel_name();
        MobiModelVO mobiModelVO1=new MobiModelVO();
        mobiModelVO1.setModel_id(model_id);
        mobiModelVO1.setBrand_id(brand_id);
        mobiModelVO1.setModel_name(model_name);
        mobiModelVO1=mobiModelModel2.modifyMobiModelInfo(mobiModelVO1);
        List<MobiModelVO> listOfMobiModel1= mobiModelModel2.viewAllMobiModelInfo();
        mobiModelBean2.setListMobiModel(listOfMobiModel1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addMobiModelRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiModelBean mobiModelBean3= (MobiModelBean)form;
        MobiModelModel mobiModelModel3= new MobiModelModel();
        MobiModelVO mobiModelVO= new MobiModelVO();
        int model_id= mobiModelBean3.getModel_id();
        int brand_id= mobiModelBean3.getBrand_id();
        String model_name= mobiModelBean3.getModel_name();
        boolean status= mobiModelModel3.checkMobiModelCredential(model_id);
        if(status== true){
            request.setAttribute("message", "Model Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            mobiModelVO.setModel_id(model_id);
            mobiModelVO.setBrand_id(brand_id);
            mobiModelVO.setModel_name(model_name);
            mobiModelModel3.postMobiModel(mobiModelVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
