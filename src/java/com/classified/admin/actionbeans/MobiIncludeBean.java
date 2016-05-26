/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actionbeans;

import com.classified.admin.vo.MobiIncludeVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class MobiIncludeBean extends org.apache.struts.action.ActionForm {
    
    private int includ_tab_id;
    private int mobile_adv_id;
    private int includ_id;
    private List<MobiIncludeVO> listOfMobiIncludes;

    /**
     * @return the includ_tab_id
     */
    public int getInclud_tab_id() {
        return includ_tab_id;
    }

    /**
     * @param includ_tab_id the includ_tab_id to set
     */
    public void setInclud_tab_id(int includ_tab_id) {
        this.includ_tab_id = includ_tab_id;
    }

    /**
     * @return the mobile_adv_id
     */
    public int getMobile_adv_id() {
        return mobile_adv_id;
    }

    /**
     * @param mobile_adv_id the mobile_adv_id to set
     */
    public void setMobile_adv_id(int mobile_adv_id) {
        this.mobile_adv_id = mobile_adv_id;
    }

    /**
     * @return the includ_id
     */
    public int getInclud_id() {
        return includ_id;
    }

    /**
     * @param includ_id the includ_id to set
     */
    public void setInclud_id(int includ_id) {
        this.includ_id = includ_id;
    }

    /**
     * @return the listOfMobiIncludes
     */
    public List<MobiIncludeVO> getListOfMobiIncludes() {
        return listOfMobiIncludes;
    }

    /**
     * @param listOfMobiIncludes the listOfMobiIncludes to set
     */
    public void setListOfMobiIncludes(List<MobiIncludeVO> listOfMobiIncludes) {
        this.listOfMobiIncludes = listOfMobiIncludes;
    }
}
