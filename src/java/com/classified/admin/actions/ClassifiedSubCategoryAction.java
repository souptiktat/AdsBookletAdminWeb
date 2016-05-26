/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.ClassifiedSubCategoryBean;
import com.classified.admin.models.ClassifiedSubCategoryModel;
import com.classified.admin.vo.ClassifiedSubCategoryVO;
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
public class ClassifiedSubCategoryAction extends org.apache.struts.actions.MappingDispatchAction {

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
    
    public ActionForward viewAllClassifiedSubCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedSubCategoryModel classifiedSubCatInfo=new ClassifiedSubCategoryModel();
        List<ClassifiedSubCategoryVO> listOfClassifiedSubCat=classifiedSubCatInfo.viewAllClassifiedSubInfo();
        ClassifiedSubCategoryBean classifiedSubCatBean=(ClassifiedSubCategoryBean)form;
        classifiedSubCatBean.setListOfClassifiedSubCategory(listOfClassifiedSubCat);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteClassifiedSubCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedSubCategoryBean classifiedSubCatBean=(ClassifiedSubCategoryBean)form;
        ClassifiedSubCategoryModel classifiedSubCatModel= new ClassifiedSubCategoryModel();
        int classified_sub_category_id=0;
        if(null!=request.getParameter("classified_sub_category_id")){
            classified_sub_category_id=Integer.parseInt(request.getParameter("classified_sub_category_id"));
        }
        if(0!=classifiedSubCatBean.getClassified_sub_category_id()){
            classified_sub_category_id=classifiedSubCatBean.getClassified_sub_category_id();
        }
        if(0!=classified_sub_category_id){
            ResultVO resultVO=classifiedSubCatModel.deleteClassifiedSubInfo(classified_sub_category_id);
            List<ClassifiedSubCategoryVO> listOfClassifiedSubCat1=classifiedSubCatModel.viewAllClassifiedSubInfo();
            classifiedSubCatBean.setListOfClassifiedSubCategory(listOfClassifiedSubCat1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyClassifiedSubCategoryInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Brand Record........");
        ClassifiedSubCategoryBean classifiedSubCatBean1=(ClassifiedSubCategoryBean)form;
        ClassifiedSubCategoryModel classifiedSubCatModel1= new ClassifiedSubCategoryModel();
        ClassifiedSubCategoryVO classifiedSubCatVO = new ClassifiedSubCategoryVO();
        int classified_sub_category_id=0;
        if(null!=request.getParameter("classified_sub_category_id")){
            classified_sub_category_id=Integer.parseInt(request.getParameter("classified_sub_category_id"));
        }
        if(0!=classifiedSubCatBean1.getClassified_sub_category_id()){
            classified_sub_category_id=classifiedSubCatBean1.getClassified_sub_category_id();
        }
        if(0!=classified_sub_category_id){
            ClassifiedSubCategoryVO classifiedSubCatVO1 = classifiedSubCatModel1.populateClassifiedSubInfo(classified_sub_category_id);
            classifiedSubCatBean1.setClassified_sub_category_id(classifiedSubCatVO.getClassified_sub_category_id());
            classifiedSubCatBean1.setClassified_category_id(classifiedSubCatVO.getClassified_category_id());
            classifiedSubCatBean1.setClassified_sub_category_name(classifiedSubCatVO.getClassified_sub_category_name());          
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyClassifiedSubCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedSubCategoryBean classifiedSubCatBean2 = (ClassifiedSubCategoryBean)form;
        ClassifiedSubCategoryModel classifiedSubCatModel2= new ClassifiedSubCategoryModel();
        int classified_sub_category_id=classifiedSubCatBean2.getClassified_sub_category_id();
        int classified_category_id=classifiedSubCatBean2.getClassified_category_id();
        String classified_sub_category_name=classifiedSubCatBean2.getClassified_sub_category_name();
        ClassifiedSubCategoryVO classifiedSubCatVO1=new ClassifiedSubCategoryVO();
        classifiedSubCatVO1.setClassified_sub_category_id(classified_sub_category_id);
        classifiedSubCatVO1.setClassified_category_id(classified_category_id);
        classifiedSubCatVO1.setClassified_sub_category_name(classified_sub_category_name);
        classifiedSubCatVO1=classifiedSubCatModel2.modifyClassifiedSubInfo(classifiedSubCatVO1);
        List<ClassifiedSubCategoryVO> listOfClassifiedSubCat1= classifiedSubCatModel2.viewAllClassifiedSubInfo();
        classifiedSubCatBean2.setListOfClassifiedSubCategory(listOfClassifiedSubCat1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addClassifiedSubCatRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedSubCategoryBean classifiedSubCatBean3= (ClassifiedSubCategoryBean)form;
        ClassifiedSubCategoryModel classifiedSubCatModel3= new ClassifiedSubCategoryModel();
        ClassifiedSubCategoryVO classifiedSubCatVO= new ClassifiedSubCategoryVO();
        int classified_sub_category_id= classifiedSubCatBean3.getClassified_sub_category_id();
        int classified_category_id= classifiedSubCatBean3.getClassified_category_id();
        String classified_sub_category_name= classifiedSubCatBean3.getClassified_sub_category_name();
        boolean status= classifiedSubCatModel3.checkClassifiedSubCatCredential(classified_sub_category_id);
        if(status== true){
            request.setAttribute("message", "Classified Sub Category Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            classifiedSubCatVO.setClassified_sub_category_id(classified_sub_category_id);
            classifiedSubCatVO.setClassified_category_id(classified_category_id);
            classifiedSubCatVO.setClassified_sub_category_name(classified_sub_category_name);
            classifiedSubCatModel3.postClassifiedSubCat(classifiedSubCatVO);
        return mapping.findForward(SUCCESS);
        }
    }
    
    
}
