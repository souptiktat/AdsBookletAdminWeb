/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.action;

import com.classifiedindia.formbean.ClassifiedIndiaFormBean;
import com.classifiedindia.model.ClassifiedModel;
import com.classifiedindia.vo.ClassifiedIndiaVO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sunit
 */
public class SearchAction extends org.apache.struts.actions.MappingDispatchAction {

    private static final String SEARCHPAGE = "searchpage";

    public ActionForward searchResult(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ClassifiedIndiaFormBean classifiedIndiaFormBean=(ClassifiedIndiaFormBean) form;
        ArrayList<ClassifiedIndiaVO> searchList = new ArrayList<ClassifiedIndiaVO>();
        ClassifiedIndiaVO classifiedIndiaVO = new ClassifiedIndiaVO();
        ClassifiedModel classifiedModel = new ClassifiedModel();
        
        classifiedIndiaFormBean.setSearchWord(request.getParameter("searchWord"));
        //String searchWord = request.getParameter("searchWord");
        //System.out.println("vvv"+searchWord);
        classifiedIndiaVO.setSearchWord(classifiedIndiaFormBean.getSearchWord());
        try{
        //searchList = classifiedModel.populateClassifiedSearchList(classifiedIndiaVO);
        classifiedIndiaFormBean.setSearchList(searchList);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return mapping.findForward(SEARCHPAGE);
    }
}
