/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classifiedindia.action;

import com.classifiedindia.admin.bean.AdminAccessBrandBean;
import com.classifiedindia.admin.bean.AdminAccessTypeBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author a
 */
public class AdminAccessAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String ACCESSTYPE = "accesstype";
    private final static String ACCESSBRAND = "accessbrand";
    private final static String ACCESSORYDETAILS = "accessorydetails";
    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    ArrayList<AdminAccessTypeBean> list = new ArrayList<AdminAccessTypeBean>();

    public ArrayList<AdminAccessTypeBean> getList() {
        return list;
    }

    public void setList(ArrayList<AdminAccessTypeBean> list) {
        this.list = list;
    }

    ArrayList<AdminAccessBrandBean> list1 = new ArrayList<AdminAccessBrandBean>();

    public ArrayList<AdminAccessBrandBean> getList1() {
        return list1;
    }

    public void setList1(ArrayList<AdminAccessBrandBean> list) {
        this.list1 = list1;
    }

    public ActionForward accessTypeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classifiedindia", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from accessories_type_table");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AdminAccessTypeBean adminaccess = new AdminAccessTypeBean();
                adminaccess.setAccessory_id(rs.getInt(1));
                adminaccess.setAccessory_name(rs.getString(2));
                adminaccess.setAccess_posting_date(rs.getString(3));
                list.add(adminaccess);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward(ACCESSTYPE);
    }

    public ActionForward accessBrandAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classifiedindia", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from accessoty_brand_table");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AdminAccessBrandBean adminbrand = new AdminAccessBrandBean();
                adminbrand.setAccessry_brand_id(rs.getInt(1));
                adminbrand.setAccessoty_brand_name(rs.getString(2));
                list1.add(adminbrand);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward(ACCESSBRAND);
    }
    
    public ActionForward accessorydetails(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) {
        return mapping.findForward(ACCESSORYDETAILS);
    }
    
}
