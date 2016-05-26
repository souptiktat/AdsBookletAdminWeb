/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actionbeans;

import com.classified.admin.vo.MobiNoofsimVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class MobiNoofsimBean extends org.apache.struts.action.ActionForm {
    
    private int noof_id;
    private String noof_name;
    private List<MobiNoofsimVO> listOfMobiNoofsim;

    /**
     * @return the noof_id
     */
    public int getNoof_id() {
        return noof_id;
    }

    /**
     * @param noof_id the noof_id to set
     */
    public void setNoof_id(int noof_id) {
        this.noof_id = noof_id;
    }

    /**
     * @return the noof_name
     */
    public String getNoof_name() {
        return noof_name;
    }

    /**
     * @param noof_name the noof_name to set
     */
    public void setNoof_name(String noof_name) {
        this.noof_name = noof_name;
    }

    /**
     * @return the listOfMobiNoofsim
     */
    public List<MobiNoofsimVO> getListOfMobiNoofsim() {
        return listOfMobiNoofsim;
    }

    /**
     * @param listOfMobiNoofsim the listOfMobiNoofsim to set
     */
    public void setListOfMobiNoofsim(List<MobiNoofsimVO> listOfMobiNoofsim) {
        this.listOfMobiNoofsim = listOfMobiNoofsim;
    }
}
