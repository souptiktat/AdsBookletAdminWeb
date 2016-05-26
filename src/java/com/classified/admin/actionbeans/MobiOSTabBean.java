/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actionbeans;

import com.classified.admin.vo.MobiOSTabVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class MobiOSTabBean extends org.apache.struts.action.ActionForm {
    
    private int os_id;
    private String os_name;
    private List<MobiOSTabVO> listOfMobiOSTab;

    /**
     * @return the os_id
     */
    public int getOs_id() {
        return os_id;
    }

    /**
     * @param os_id the os_id to set
     */
    public void setOs_id(int os_id) {
        this.os_id = os_id;
    }

    /**
     * @return the os_name
     */
    public String getOs_name() {
        return os_name;
    }

    /**
     * @param os_name the os_name to set
     */
    public void setOs_name(String os_name) {
        this.os_name = os_name;
    }

    /**
     * @return the listOfMobiOSTab
     */
    public List<MobiOSTabVO> getListOfMobiOSTab() {
        return listOfMobiOSTab;
    }

    /**
     * @param listOfMobiOSTab the listOfMobiOSTab to set
     */
    public void setListOfMobiOSTab(List<MobiOSTabVO> listOfMobiOSTab) {
        this.listOfMobiOSTab = listOfMobiOSTab;
    }
}
