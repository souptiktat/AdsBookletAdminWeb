/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.AccessoryBrandBean;
import com.classified.admin.models.AccessoryBrandModel;
import com.classified.admin.vo.AccessoryBrandVO;
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
public class AccessoryBrandAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward viewAllAccessoryBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryBrandModel accessBrandInfo=new AccessoryBrandModel();
        List<AccessoryBrandVO> listOfAccessoryBrand=accessBrandInfo.viewAllAccessoryInfo();
        AccessoryBrandBean accessoryBrandBean=(AccessoryBrandBean)form;
        accessoryBrandBean.setListOfAccessoryBrand(listOfAccessoryBrand);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteAccessoryBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryBrandBean accessBrandBean=(AccessoryBrandBean)form;
        AccessoryBrandModel accessBrandModel= new AccessoryBrandModel();
        int accessry_brand_id=0;
        if(null!=request.getParameter("accessry_brand_id")){
            accessry_brand_id=Integer.parseInt(request.getParameter("accessry_brand_id"));
        }
        if(0!=accessBrandBean.getAccessry_brand_id()){
            accessry_brand_id=accessBrandBean.getAccessry_brand_id();
        }
        if(0!=accessry_brand_id){
            ResultVO resultVO=accessBrandModel.deleteAccessoryInfo(accessry_brand_id);
            List<AccessoryBrandVO> listOfAccessoryType1=accessBrandModel.viewAllAccessoryInfo();
            accessBrandBean.setListOfAccessoryBrand(listOfAccessoryType1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyAccessoryBrandInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Brand Record........");
        AccessoryBrandBean accessBrandBean1=(AccessoryBrandBean)form;
        AccessoryBrandModel accessBrandModel1= new AccessoryBrandModel();
        AccessoryBrandVO accessBrandVO = new AccessoryBrandVO();
        int accessry_brand_id=0;
        if(null!=request.getParameter("accessry_brand_id")){
            accessry_brand_id=Integer.parseInt(request.getParameter("accessry_brand_id"));
        }
        if(0!=accessBrandBean1.getAccessry_brand_id()){
            accessry_brand_id=accessBrandBean1.getAccessry_brand_id();
        }
        if(0!=accessry_brand_id){
            AccessoryBrandVO accessoryBrandVO = accessBrandModel1.populateAccessoryInfo(accessry_brand_id);
            accessBrandBean1.setAccessry_brand_id(accessBrandVO.getAccessry_brand_id());
            accessBrandBean1.setAccessoty_brand_name(accessBrandVO.getAccessoty_brand_name());          
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyAccessoryBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryBrandBean accessBrandBean2 = (AccessoryBrandBean)form;
        AccessoryBrandModel accessBrandModel2= new AccessoryBrandModel();
        int accessry_brand_id=accessBrandBean2.getAccessry_brand_id();
        String accessory_name=accessBrandBean2.getAccessoty_brand_name();
        AccessoryBrandVO accessoryBrandVO1=new AccessoryBrandVO();
        accessoryBrandVO1.setAccessry_brand_id(accessry_brand_id);
        accessoryBrandVO1.setAccessoty_brand_name(accessory_name);
        accessoryBrandVO1=accessBrandModel2.modifyAccessoryInfo(accessoryBrandVO1);
        List<AccessoryBrandVO> listOfAccessoryType1= accessBrandModel2.viewAllAccessoryInfo();
        accessBrandBean2.setListOfAccessoryBrand(listOfAccessoryType1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addAccessoryBrandRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)  
            throws Exception {
        AccessoryBrandBean accessTypeBean3= (AccessoryBrandBean)form;
        AccessoryBrandModel accessTypeModel3= new AccessoryBrandModel();
        AccessoryBrandVO accessTypeVO= new AccessoryBrandVO();
        int accessry_brand_id= accessTypeBean3.getAccessry_brand_id();
        String accessoty_brand_name= accessTypeBean3.getAccessoty_brand_name();
        boolean status= accessTypeModel3.checkAccessoryBrandCredential(accessry_brand_id);
        if(status== true){
            request.setAttribute("message", "Accessory Brand Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            accessTypeVO.setAccessry_brand_id(accessry_brand_id);
            accessTypeVO.setAccessoty_brand_name(accessoty_brand_name);
            accessTypeModel3.postAccessoryBrand(accessTypeVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
