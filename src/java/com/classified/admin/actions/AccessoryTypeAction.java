/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.AccessoryTypeBean;
import com.classified.admin.models.AccessoryTypeModel;
import com.classified.admin.vo.AccessoryTypeVO;
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
public class AccessoryTypeAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE= "failure"; 
    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward viewAllAccessoryTypeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryTypeModel accessTypeInfo=new AccessoryTypeModel();
        List<AccessoryTypeVO> listOfAccessoryType=accessTypeInfo.viewAllAccessoryInfo();
        AccessoryTypeBean accessoryTypeBean=(AccessoryTypeBean)form;
        accessoryTypeBean.setListOfAccessoryType(listOfAccessoryType);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteAccessoryTypeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryTypeBean accessTypeBean=(AccessoryTypeBean)form;
        AccessoryTypeModel accessTypeModel= new AccessoryTypeModel();
        int accessory_id=0;
        if(null!=request.getParameter("accessory_id")){
            accessory_id=Integer.parseInt(request.getParameter("accessory_id"));
        }
        if(0!=accessTypeBean.getAccessory_id()){
            accessory_id=accessTypeBean.getAccessory_id();
        }
        if(0!=accessory_id){
            ResultVO resultVO=accessTypeModel.deleteAccessoryInfo(accessory_id);
            List<AccessoryTypeVO> listOfAccessoryType1=accessTypeModel.viewAllAccessoryInfo();
            accessTypeBean.setListOfAccessoryType(listOfAccessoryType1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyAccessoryTypeInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Type Record........");
        AccessoryTypeBean accessTypeBean1=(AccessoryTypeBean)form;
        AccessoryTypeModel accessTypeModel1= new AccessoryTypeModel();
        AccessoryTypeVO accessTypeVO = new AccessoryTypeVO();
        int accessory_id=0;
        if(null!=request.getParameter("accessory_id")){
            accessory_id=Integer.parseInt(request.getParameter("accessory_id"));
        }
        if(0!=accessTypeBean1.getAccessory_id()){
            accessory_id=accessTypeBean1.getAccessory_id();
        }
        if(0!=accessory_id){
            AccessoryTypeVO accessoryTypeVO = accessTypeModel1.populateAccessoryInfo(accessory_id);
            accessTypeBean1.setAccessory_id(accessTypeVO.getAccessory_id());
            accessTypeBean1.setAccessory_name(accessTypeVO.getAccessory_name());
            accessTypeBean1.setAccess_posting_date(accessTypeVO.getAccess_posting_date());
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyAccessoryTypeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryTypeBean accessTypeBean2 = (AccessoryTypeBean)form;
        AccessoryTypeModel accessTypeModel2= new AccessoryTypeModel();
        int accessory_id=accessTypeBean2.getAccessory_id();
        String accessory_name=accessTypeBean2.getAccessory_name();
        String access_posting_date=accessTypeBean2.getAccess_posting_date();
        AccessoryTypeVO accessoryTypeVO1=new AccessoryTypeVO();
        accessoryTypeVO1.setAccessory_id(accessory_id);
        accessoryTypeVO1.setAccessory_name(accessory_name);
        accessoryTypeVO1.setAccess_posting_date(access_posting_date);
        accessoryTypeVO1=accessTypeModel2.modifyAccessoryInfo(accessoryTypeVO1);
        List<AccessoryTypeVO> listOfAccessoryType1= accessTypeModel2.viewAllAccessoryInfo();
        accessTypeBean2.setListOfAccessoryType(listOfAccessoryType1);
        return mapping.findForward(SUCCESS);
    }
    
    
    
    public ActionForward addAccessoryTypeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AccessoryTypeBean accessTypeBean3= (AccessoryTypeBean)form;
        AccessoryTypeModel accessTypeModel3= new AccessoryTypeModel();
        AccessoryTypeVO accessTypeVO= new AccessoryTypeVO();
        int accessory_id= accessTypeBean3.getAccessory_id();
        String accessory_name= accessTypeBean3.getAccessory_name();
        String access_posting_date= accessTypeBean3.getAccess_posting_date();
        boolean status= accessTypeModel3.checkAccessoryTypeCredential(accessory_id);
        if(status== true){
            request.setAttribute("message", "Accessory Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            accessTypeVO.setAccessory_id(accessory_id);
            accessTypeVO.setAccessory_name(accessory_name);
            accessTypeVO.setAccess_posting_date(access_posting_date);
            accessTypeModel3.postAccessoryType(accessTypeVO);
        return mapping.findForward(SUCCESS);
        }
    }
}
