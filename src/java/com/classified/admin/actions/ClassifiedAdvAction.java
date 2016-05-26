/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.ClassifiedAdvBean;
import com.classified.admin.models.ClassifiedAdvPhotoModel;
import com.classified.admin.vo.ClassifiedAdvVO;
import com.classified.admin.vo.ResultVO;
import java.sql.Blob;
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
public class ClassifiedAdvAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE= "failure";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward viewAllClassifiedAdvRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedAdvPhotoModel classifiedAdvInfo=new ClassifiedAdvPhotoModel();
        List<ClassifiedAdvVO> listOfClassifiedAdv=classifiedAdvInfo.viewAllClassifiedAdvInfo();
        ClassifiedAdvBean classifiedAdvBean=(ClassifiedAdvBean)form;
        classifiedAdvBean.setListOfClassifiedAdv(listOfClassifiedAdv);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteClassifiedAdvRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        ClassifiedAdvBean classifiedAdvBean=(ClassifiedAdvBean)form;
        ClassifiedAdvPhotoModel classifiedAdvModel= new ClassifiedAdvPhotoModel();
        int classified_image_id=0;
        if(null!=request.getParameter("classified_image_id")){
            classified_image_id=Integer.parseInt(request.getParameter("classified_image_id"));
        }
        if(0!=classifiedAdvBean.getClassified_image_id()){
            classified_image_id=classifiedAdvBean.getClassified_image_id();
        }
        if(0!=classified_image_id){
            ResultVO resultVO=classifiedAdvModel.deleteClassifiedAdvInfo(classified_image_id);
            List<ClassifiedAdvVO> listOfClassifiedAdv1=classifiedAdvModel.viewAllClassifiedAdvInfo();
            classifiedAdvBean.setListOfClassifiedAdv(listOfClassifiedAdv1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyClassifiedAdvInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        System.out.println("Begin Modify Accessory Brand Record........");
        ClassifiedAdvBean classifiedAdvBean1=(ClassifiedAdvBean)form;
        ClassifiedAdvPhotoModel classifiedAdvModel1= new ClassifiedAdvPhotoModel();
        ClassifiedAdvVO classifiedAdvVO = new ClassifiedAdvVO();
        int classified_image_id=0;
        if(null!=request.getParameter("classified_image_id")){
            classified_image_id=Integer.parseInt(request.getParameter("classified_image_id"));
        }
        if(0!=classifiedAdvBean1.getClassified_image_id()){
            classified_image_id=classifiedAdvBean1.getClassified_image_id();
        }
        if(0!=classified_image_id){
            ClassifiedAdvVO classifiedCatVO1 = classifiedAdvModel1.populateClassifiedAdvInfo(classified_image_id);
            classifiedAdvBean1.setClassified_image_id(classifiedAdvVO.getClassified_image_id());
            classifiedAdvBean1.setClassified_id(classifiedAdvVO.getClassified_id());
            classifiedAdvBean1.setClassified_small_image(classifiedAdvVO.getClassified_small_image());  
            classifiedAdvBean1.setClassified_large_image(classifiedAdvVO.getClassified_large_image());
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyClassifiedAdvRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        ClassifiedAdvBean classifiedAdvBean2 = (ClassifiedAdvBean)form;
        ClassifiedAdvPhotoModel classifiedAdvModel2= new ClassifiedAdvPhotoModel();
        int classified_image_id=classifiedAdvBean2.getClassified_image_id();
        int classified_id=classifiedAdvBean2.getClassified_id();
        Blob classified_small_image=classifiedAdvBean2.getClassified_small_image();
        Blob classified_large_image=classifiedAdvBean2.getClassified_large_image();
        ClassifiedAdvVO classifiedAdvVO1=new ClassifiedAdvVO();
        classifiedAdvVO1.setClassified_image_id(classified_image_id);
        classifiedAdvVO1.setClassified_id(classified_id);
        classifiedAdvVO1.setClassified_small_image(classified_small_image);
        classifiedAdvVO1.setClassified_large_image(classified_large_image);
        classifiedAdvVO1=classifiedAdvModel2.modifyClassifiedAdvInfo(classifiedAdvVO1);
        List<ClassifiedAdvVO> listOfAccessoryType1= classifiedAdvModel2.viewAllClassifiedAdvInfo();
        classifiedAdvBean2.setListOfClassifiedAdv(listOfAccessoryType1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addClassifiedAdvRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        ClassifiedAdvBean classifiedAdvBean3= (ClassifiedAdvBean)form;
        ClassifiedAdvPhotoModel classifiedCatModel3= new ClassifiedAdvPhotoModel();
        ClassifiedAdvVO classifiedAdvVO= new ClassifiedAdvVO();
        int classified_image_id= classifiedAdvBean3.getClassified_image_id();
        int classified_id=classifiedAdvBean3.getClassified_id();
        Blob classified_small_image=classifiedAdvBean3.getClassified_small_image();
        Blob classified_large_image=classifiedAdvBean3.getClassified_large_image();
        boolean status= classifiedCatModel3.checkClassifiedAdvCredential(classified_image_id);
        if(status== true){
            request.setAttribute("message", "Classified Image Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            classifiedAdvVO.setClassified_image_id(classified_image_id);
            classifiedAdvVO.setClassified_id(classified_id);
            classifiedAdvVO.setClassified_small_image(classified_small_image);
            classifiedAdvVO.setClassified_large_image(classified_large_image);           
            classifiedCatModel3.postClassifiedAdv(classifiedAdvVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
}
