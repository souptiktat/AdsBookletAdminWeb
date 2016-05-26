/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.PostAccessoryBean;
import com.classified.admin.models.PostAccessoryModel;
import com.classified.admin.vo.PostAccessoryVO;
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
public class PostAccessoryAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    public ActionForward viewAllPostAccessoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PostAccessoryModel postAccessInfo=new PostAccessoryModel();
        List<PostAccessoryVO> listOfPostAccessory=postAccessInfo.viewAllPostAccessoryInfo();
        PostAccessoryBean postAccessoryBean=(PostAccessoryBean)form;
        postAccessoryBean.setListOfPostAccessory(listOfPostAccessory);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deletePostAccessoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PostAccessoryBean postAccessBean=(PostAccessoryBean)form;
        PostAccessoryModel postAccessModel= new PostAccessoryModel();
        int accessory_adv_id=0;
        if(null!=request.getParameter("accessory_adv_id")){
            accessory_adv_id=Integer.parseInt(request.getParameter("accessory_adv_id"));
        }
        if(0!=postAccessBean.getAccessory_adv_id()){
            accessory_adv_id=postAccessBean.getAccessory_adv_id();
        }
        if(0!=accessory_adv_id){
            ResultVO resultVO=postAccessModel.deletePostAccessoryInfo(accessory_adv_id);
            List<PostAccessoryVO> listOfPostAccessory1=postAccessModel.viewAllPostAccessoryInfo();
            postAccessBean.setListOfPostAccessory(listOfPostAccessory1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyPostAccessoryInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Type Record........");
        PostAccessoryBean postAccessBean1=(PostAccessoryBean)form;
        PostAccessoryModel postAccessModel1= new PostAccessoryModel();
        PostAccessoryVO postAccessVO = new PostAccessoryVO();
        int accessory_adv_id=0;
        if(null!=request.getParameter("accessory_adv_id")){
            accessory_adv_id=Integer.parseInt(request.getParameter("accessory_adv_id"));
        }
        if(0!=postAccessBean1.getAccessory_adv_id()){
            accessory_adv_id=postAccessBean1.getAccessory_adv_id();
        }
        if(0!=accessory_adv_id){
            PostAccessoryVO postAccessoryVO = postAccessModel1.populatePostAccessoryInfo(accessory_adv_id);
            postAccessBean1.setAccessory_adv_id(postAccessVO.getAccessory_adv_id());
            postAccessBean1.setAccess_img_id(postAccessVO.getAccess_img_id());
            postAccessBean1.setAccess_title(postAccessVO.getAccess_title());
            postAccessBean1.setAccess_condition(postAccessVO.getAccess_condition());
            postAccessBean1.setAccessry_brand_id(postAccessVO.getAccessry_brand_id());
            postAccessBean1.setAccessory_id(postAccessVO.getAccessory_id());
            postAccessBean1.setAccess_descript(postAccessVO.getAccess_descript());
            postAccessBean1.setAccess_typof_ad(postAccessVO.getAccess_typof_ad());
            postAccessBean1.setAccess_price(postAccessVO.getAccess_price());
            postAccessBean1.setAccess_xpect_price(postAccessVO.getAccess_xpect_price());
            postAccessBean1.setAccess_posting_date(postAccessVO.getAccess_posting_date());
            postAccessBean1.setAccess_subcat_id(postAccessVO.getAccess_subcat_id());
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyPostAccessoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PostAccessoryBean postAccessBean2 = (PostAccessoryBean)form;
        PostAccessoryModel postAccessModel2= new PostAccessoryModel();
        int accessory_adv_id=postAccessBean2.getAccessory_adv_id();
        double access_img_id=postAccessBean2.getAccess_img_id();
        String access_title=postAccessBean2.getAccess_title();
        String access_condition=postAccessBean2.getAccess_condition();
        int accessry_brand_id=postAccessBean2.getAccessry_brand_id();
        int accessory_id=postAccessBean2.getAccessory_id();
        String access_descript=postAccessBean2.getAccess_descript();
        String access_typof_ad=postAccessBean2.getAccess_typof_ad();
        double access_price=postAccessBean2.getAccess_price();
        double access_xpect_price=postAccessBean2.getAccess_xpect_price();
        String access_posting_date=postAccessBean2.getAccess_posting_date();
        int access_subcat_id=postAccessBean2.getAccess_subcat_id();
        PostAccessoryVO postAccessoryVO1=new PostAccessoryVO();
        postAccessoryVO1.setAccessory_adv_id(accessory_adv_id);
        postAccessoryVO1.setAccess_img_id(access_img_id);
        postAccessoryVO1.setAccess_title(access_title);
        postAccessoryVO1.setAccess_condition(access_condition);
        postAccessoryVO1.setAccessry_brand_id(accessry_brand_id);
        postAccessoryVO1.setAccessory_id(accessory_id);
        postAccessoryVO1.setAccess_descript(access_descript);
        postAccessoryVO1.setAccess_typof_ad(access_typof_ad);
        postAccessoryVO1.setAccess_price(access_price);
        postAccessoryVO1.setAccess_xpect_price(access_xpect_price);
        postAccessoryVO1.setAccess_posting_date(access_posting_date);
        postAccessoryVO1.setAccess_subcat_id(access_subcat_id);
        postAccessoryVO1=postAccessModel2.modifyPostAccessoryInfo(postAccessoryVO1);
        List<PostAccessoryVO> listOfPostAccessory1= postAccessModel2.viewAllPostAccessoryInfo();
        postAccessBean2.setListOfPostAccessory(listOfPostAccessory1);
        return mapping.findForward(SUCCESS);
    }
    
    
    
    public ActionForward addPostAccessoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PostAccessoryBean postAccessBean3= (PostAccessoryBean)form;
        PostAccessoryModel postAccessModel3= new PostAccessoryModel();
        PostAccessoryVO postAccessVO= new PostAccessoryVO();
        int accessory_adv_id=postAccessBean3.getAccessory_adv_id();
        double access_img_id=postAccessBean3.getAccess_img_id();
        String access_title=postAccessBean3.getAccess_title();
        String access_condition=postAccessBean3.getAccess_condition();
        int accessry_brand_id=postAccessBean3.getAccessry_brand_id();
        int accessory_id=postAccessBean3.getAccessory_id();
        String access_descript=postAccessBean3.getAccess_descript();
        String access_typof_ad=postAccessBean3.getAccess_typof_ad();
        double access_price=postAccessBean3.getAccess_price();
        double access_xpect_price=postAccessBean3.getAccess_xpect_price();
        String access_posting_date=postAccessBean3.getAccess_posting_date();
        int access_subcat_id=postAccessBean3.getAccess_subcat_id();
        boolean status= postAccessModel3.checkPostAccessoryCredential(accessory_adv_id);
        if(status== true){
            request.setAttribute("message", "Post Accessory Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            postAccessVO.setAccessory_adv_id(accessory_adv_id);
            postAccessVO.setAccess_img_id(access_img_id);
            postAccessVO.setAccess_title(access_title);
            postAccessVO.setAccess_condition(access_condition);
            postAccessVO.setAccessry_brand_id(accessry_brand_id);
            postAccessVO.setAccessory_id(accessory_id);
            postAccessVO.setAccess_descript(access_descript);
            postAccessVO.setAccess_typof_ad(access_typof_ad);
            postAccessVO.setAccess_price(access_price);
            postAccessVO.setAccess_xpect_price(access_xpect_price);
            postAccessVO.setAccess_posting_date(access_posting_date);
            postAccessVO.setAccess_subcat_id(access_subcat_id);
            postAccessModel3.postAccessoryType(postAccessVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
