/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actions;

import com.classified.admin.actionbeans.MobiOSTabBean;
import com.classified.admin.models.MobiOSTabModel;
import com.classified.admin.vo.MobiOSTabVO;
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
public class MobiOSTabAction extends org.apache.struts.actions.MappingDispatchAction {

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
    public ActionForward viewAllMobiOSTabRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiOSTabModel mobiOSTabInfo=new MobiOSTabModel();
        List<MobiOSTabVO> listOfMobiOSTab=mobiOSTabInfo.viewAllMobiOSTabInfo();
        MobiOSTabBean mobiOSTabBean=(MobiOSTabBean)form;
        mobiOSTabBean.setListOfMobiOSTab(listOfMobiOSTab);
       return mapping.findForward(SUCCESS);
    }
    
    public ActionForward deleteMobiOSTabRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiOSTabBean mobiOSTabBean1=(MobiOSTabBean)form;
        MobiOSTabModel mobiOSTabModel1= new MobiOSTabModel();
        int os_id=0;
        if(null!=request.getParameter("os_id")){
            os_id=Integer.parseInt(request.getParameter("os_id"));
        }
        if(0!=mobiOSTabBean1.getOs_id()){
            os_id=mobiOSTabBean1.getOs_id();
        }
        if(0!=os_id){
            ResultVO resultVO=mobiOSTabModel1.deleteMobiOSTabInfo(os_id);
            List<MobiOSTabVO> listOfMobiOSTab1=mobiOSTabModel1.viewAllMobiOSTabInfo();
            mobiOSTabBean1.setListOfMobiOSTab(listOfMobiOSTab1);
            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward modifyMobiOSTabInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Begin Modify Accessory Type Record........");
        MobiOSTabBean mobiOSTabBean2=(MobiOSTabBean)form;
        MobiOSTabModel mobiOSTabModel1= new MobiOSTabModel();
        MobiOSTabVO mobiOSTabVO = new MobiOSTabVO();
        int os_id=0;
        if(null!=request.getParameter("os_id")){
            os_id=Integer.parseInt(request.getParameter("os_id"));
        }
        if(0!=mobiOSTabBean2.getOs_id()){
            os_id=mobiOSTabBean2.getOs_id();
        }
        if(0!=os_id){
            MobiOSTabVO mobiOSTabVO1 = mobiOSTabModel1.populateMobiOSTabInfo(os_id);
            mobiOSTabBean2.setOs_id(mobiOSTabVO.getOs_id());
            mobiOSTabBean2.setOs_name(mobiOSTabVO.getOs_name());
        }
        System.out.println("Hello -------------->");
        return mapping.findForward(SUCCESS);
    }
    
    
    public ActionForward modifyMobiOSTabRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiOSTabBean mobiOSTabBean3 = (MobiOSTabBean)form;
        MobiOSTabModel mobiOSTabModel3= new MobiOSTabModel();
        int os_id=mobiOSTabBean3.getOs_id();
        String os_name=mobiOSTabBean3.getOs_name();
        MobiOSTabVO mobiOSTabVO1=new MobiOSTabVO();
        mobiOSTabVO1.setOs_id(os_id);
        mobiOSTabVO1.setOs_name(os_name);
        mobiOSTabVO1=mobiOSTabModel3.modifyMobiOSTabInfo(mobiOSTabVO1);
        List<MobiOSTabVO> listOfMobiOSTab1= mobiOSTabModel3.viewAllMobiOSTabInfo();
        mobiOSTabBean3.setListOfMobiOSTab(listOfMobiOSTab1);
        return mapping.findForward(SUCCESS);
    }
    
    
    
    public ActionForward addMobiOSTabRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MobiOSTabBean mobiOSTabBean4= (MobiOSTabBean)form;
        MobiOSTabModel mobiOSTabModel4= new MobiOSTabModel();
        MobiOSTabVO mobiOSTabVO= new MobiOSTabVO();
        int os_id= mobiOSTabBean4.getOs_id();
        String os_name= mobiOSTabBean4.getOs_name();
        boolean status= mobiOSTabModel4.checkMobiOSTabCredential(os_id);
        if(status== true){
            request.setAttribute("message", "OS Id Already Exists");
            return mapping.findForward(FAILURE);
        }
        else{
            mobiOSTabVO.setOs_id(os_id);
            mobiOSTabVO.setOs_name(os_name);
            mobiOSTabModel4.postMobiOSTab(mobiOSTabVO);
        return mapping.findForward(SUCCESS);
        }
    }
}
