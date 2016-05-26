/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.admin.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class AdminAccessBrandBean extends org.apache.struts.action.ActionForm {
    
    private int accessry_brand_id;
    private String accessoty_brand_name;

    /**
     * @return the accessry_brand_id
     */
    public int getAccessry_brand_id() {
        return accessry_brand_id;
    }

    /**
     * @param accessry_brand_id the accessry_brand_id to set
     */
    public void setAccessry_brand_id(int accessry_brand_id) {
        this.accessry_brand_id = accessry_brand_id;
    }

    /**
     * @return the accessoty_brand_name
     */
    public String getAccessoty_brand_name() {
        return accessoty_brand_name;
    }

    /**
     * @param accessoty_brand_name the accessoty_brand_name to set
     */
    public void setAccessoty_brand_name(String accessoty_brand_name) {
        this.accessoty_brand_name = accessoty_brand_name;
    }
}
