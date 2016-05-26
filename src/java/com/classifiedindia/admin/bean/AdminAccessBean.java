/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.admin.bean;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class AdminAccessBean extends org.apache.struts.validator.ValidatorForm {
    
    ArrayList<AdminAccessTypeBean> list = new ArrayList<AdminAccessTypeBean>();
    ArrayList<AdminAccessBrandBean> list1 = new ArrayList<AdminAccessBrandBean>();
    public ArrayList<AdminAccessTypeBean> getList() {
        return list;
    }

    public void setList(ArrayList<AdminAccessTypeBean> list) {
        this.list = list;
    }

    

    public ArrayList<AdminAccessBrandBean> getList1() {
        return list1;
    }

    public void setList1(ArrayList<AdminAccessBrandBean> list) {
        this.list1 = list1;
    }
    
}
