/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actionbeans;

import com.classified.admin.vo.MobiConditionVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class MobiConditionBean extends org.apache.struts.action.ActionForm {
    
    private String cond_id;
    private String cond_name;
    private List<MobiConditionVO> listOfMobileCond;

    /**
     * @return the cond_id
     */
    public String getCond_id() {
        return cond_id;
    }

    /**
     * @param cond_id the cond_id to set
     */
    public void setCond_id(String cond_id) {
        this.cond_id = cond_id;
    }

    /**
     * @return the cond_name
     */
    public String getCond_name() {
        return cond_name;
    }

    /**
     * @param cond_name the cond_name to set
     */
    public void setCond_name(String cond_name) {
        this.cond_name = cond_name;
    }

    /**
     * @return the listOfMobileCond
     */
    public List<MobiConditionVO> getListOfMobileCond() {
        return listOfMobileCond;
    }

    /**
     * @param listOfMobileCond the listOfMobileCond to set
     */
    public void setListOfMobileCond(List<MobiConditionVO> listOfMobileCond) {
        this.listOfMobileCond = listOfMobileCond;
    }
}
