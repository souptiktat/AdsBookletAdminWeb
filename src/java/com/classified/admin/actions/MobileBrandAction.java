/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.MobileBrandBean;
import com.classified.admin.models.MobileBrandModel;
import com.classified.admin.vo.MobileBrandVO;
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
public class MobileBrandAction extends org.apache.struts.actions.MappingDispatchAction {

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
    public ActionForward viewAllMobileBrandInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobileBrandModel mobileBrandInfo=new MobileBrandModel();
        List<MobileBrandVO> listOfMobileBrand=mobileBrandInfo.viewAllMobileBrandInfo();
        MobileBrandBean mobileBrandBean=(MobileBrandBean)form;
        mobileBrandBean.setListOfMobileBrand(listOfMobileBrand);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteMobileBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobileBrandBean mobileBrandBean=(MobileBrandBean)form;
        MobileBrandModel mobileBrandModel= new MobileBrandModel();
        int brand_id=0;
        if(null!=request.getParameter("brand_id")){
            brand_id=Integer.parseInt(request.getParameter("brand_id"));
        }
        if(0!=mobileBrandBean.getBrand_id()){
            brand_id=mobileBrandBean.getBrand_id();
        }
        if(0!=brand_id){
            ResultVO resultVO=mobileBrandModel.deleteMobileBrandInfo(brand_id);
            List<MobileBrandVO> listOfMobileBrand1=mobileBrandModel.viewAllMobileBrandInfo();
            mobileBrandBean.setListOfMobileBrand(listOfMobileBrand1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyMobileBrandInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Brand Record........");
        MobileBrandBean mobileBrandBean1=(MobileBrandBean)form;
        MobileBrandModel mobileBrandModel1= new MobileBrandModel();
        MobileBrandVO mobileBrandVO1 = new MobileBrandVO();
        int brand_id=0;
        if(null!=request.getParameter("brand_id")){
            brand_id=Integer.parseInt(request.getParameter("brand_id"));
        }
        if(0!=mobileBrandBean1.getBrand_id()){
            brand_id=mobileBrandBean1.getBrand_id();
        }
        if(0!=brand_id){
            MobileBrandVO mobileBrandVO = mobileBrandModel1.populateMobileBrandInfo(brand_id);
            mobileBrandBean1.setBrand_id(mobileBrandVO1.getBrand_id());
            mobileBrandBean1.setBrand_name(mobileBrandVO1.getBrand_name());          
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyMobileBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobileBrandBean mobileBrandBean2 = (MobileBrandBean)form;
        MobileBrandModel mobileBrandModel2= new MobileBrandModel();
        int brand_id=mobileBrandBean2.getBrand_id();
        String brand_name=mobileBrandBean2.getBrand_name();
        MobileBrandVO mobileBrandVO1=new MobileBrandVO();
        mobileBrandVO1.setBrand_id(brand_id);
        mobileBrandVO1.setBrand_name(brand_name);
        mobileBrandVO1=mobileBrandModel2.modifyMobileBrandInfo(mobileBrandVO1);
        List<MobileBrandVO> listOfMobileBrand1= mobileBrandModel2.viewAllMobileBrandInfo();
        mobileBrandBean2.setListOfMobileBrand(listOfMobileBrand1);
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward addMobileBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)  
            throws Exception {
        MobileBrandBean mobileBrandBean3= (MobileBrandBean)form;
        MobileBrandModel mobileBrandModel3= new MobileBrandModel();
        MobileBrandVO mobileBrandVO= new MobileBrandVO();
        int brand_id= mobileBrandBean3.getBrand_id();
        String brand_name= mobileBrandBean3.getBrand_name();
        boolean status= mobileBrandModel3.checkMobileBrandCredential(brand_id);
        if(status== true){
            request.setAttribute("message", "Accessory Brand Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            mobileBrandVO.setBrand_id(brand_id);
            mobileBrandVO.setBrand_name(brand_name);
            mobileBrandModel3.postMobileBrand(mobileBrandVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
