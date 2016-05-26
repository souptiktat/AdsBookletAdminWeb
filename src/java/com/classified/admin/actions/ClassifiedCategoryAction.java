/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.ClassifiedCategoryBean;
import com.classified.admin.models.ClassifiedCategoryModel;
import com.classified.admin.vo.ClassifiedCategoryVO;
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
public class ClassifiedCategoryAction extends org.apache.struts.actions.MappingDispatchAction{

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
    public ActionForward viewAllClassifiedCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedCategoryModel classifiedCatInfo=new ClassifiedCategoryModel();
        List<ClassifiedCategoryVO> listOfClassifiedCat=classifiedCatInfo.viewAllClassifiedInfo();
        ClassifiedCategoryBean accessoryBrandBean=(ClassifiedCategoryBean)form;
        accessoryBrandBean.setListOfClassifiedCategory(listOfClassifiedCat);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteClassifiedCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedCategoryBean classifiedCatBean=(ClassifiedCategoryBean)form;
        ClassifiedCategoryModel classifiedCatModel= new ClassifiedCategoryModel();
        int classified_category_id=0;
        if(null!=request.getParameter("classified_category_id")){
            classified_category_id=Integer.parseInt(request.getParameter("classified_category_id"));
        }
        if(0!=classifiedCatBean.getClassified_category_id()){
            classified_category_id=classifiedCatBean.getClassified_category_id();
        }
        if(0!=classified_category_id){
            ResultVO resultVO=classifiedCatModel.deleteClassifiedInfo(classified_category_id);
            List<ClassifiedCategoryVO> listOfClassifiedCat1=classifiedCatModel.viewAllClassifiedInfo();
            classifiedCatBean.setListOfClassifiedCategory(listOfClassifiedCat1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyClassifiedCategoryInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Brand Record........");
        ClassifiedCategoryBean classifiedCatBean1=(ClassifiedCategoryBean)form;
        ClassifiedCategoryModel classifiedCatModel1= new ClassifiedCategoryModel();
        ClassifiedCategoryVO classifiedCatVO = new ClassifiedCategoryVO();
        int classified_category_id=0;
        if(null!=request.getParameter("classified_category_id")){
            classified_category_id=Integer.parseInt(request.getParameter("classified_category_id"));
        }
        if(0!=classifiedCatBean1.getClassified_category_id()){
            classified_category_id=classifiedCatBean1.getClassified_category_id();
        }
        if(0!=classified_category_id){
            ClassifiedCategoryVO classifiedCatVO1 = classifiedCatModel1.populateClassifiedInfo(classified_category_id);
            classifiedCatBean1.setClassified_category_id(classifiedCatVO.getClassified_category_id());
            classifiedCatBean1.setClassified_category_name(classifiedCatVO.getClassified_category_name());          
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyClassifiedCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedCategoryBean classifiedCatBean2 = (ClassifiedCategoryBean)form;
        ClassifiedCategoryModel classifiedCatModel2= new ClassifiedCategoryModel();
        int classified_category_id=classifiedCatBean2.getClassified_category_id();
        String classified_category_name=classifiedCatBean2.getClassified_category_name();
        ClassifiedCategoryVO classifiedCatVO1=new ClassifiedCategoryVO();
        classifiedCatVO1.setClassified_category_id(classified_category_id);
        classifiedCatVO1.setClassified_category_name(classified_category_name);
        classifiedCatVO1=classifiedCatModel2.modifyClassifiedInfo(classifiedCatVO1);
        List<ClassifiedCategoryVO> listOfAccessoryType1= classifiedCatModel2.viewAllClassifiedInfo();
        classifiedCatBean2.setListOfClassifiedCategory(listOfAccessoryType1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addClassifiedCategoryRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ClassifiedCategoryBean classifiedCatBean3= (ClassifiedCategoryBean)form;
        ClassifiedCategoryModel classifiedCatModel3= new ClassifiedCategoryModel();
        ClassifiedCategoryVO classifiedCatVO= new ClassifiedCategoryVO();
        int classified_category_id= classifiedCatBean3.getClassified_category_id();
        String classified_category_name= classifiedCatBean3.getClassified_category_name();
        boolean status= classifiedCatModel3.checkClassifiedCatCredential(classified_category_id);
        if(status== true){
            request.setAttribute("message", "Classified Category Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            classifiedCatVO.setClassified_category_id(classified_category_id);
            classifiedCatVO.setClassified_category_name(classified_category_name);
            classifiedCatModel3.postClassifiedCat(classifiedCatVO);
        return mapping.findForward(SUCCESS);
        }
    }
}
