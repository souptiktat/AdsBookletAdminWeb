/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actionbeans;

import com.classified.admin.vo.PostAccessoryVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class PostAccessoryBean extends org.apache.struts.action.ActionForm {
    
    private int accessory_adv_id;
    private double access_img_id;
    private String access_title;
    private String access_condition;
    private int accessry_brand_id;
    private int accessory_id;
    private String access_descript;
    private String access_typof_ad;
    private double access_price;
    private double access_xpect_price;
    private String access_posting_date;
    private int access_subcat_id;
    private List<PostAccessoryVO> listOfPostAccessory;

    /**
     * @return the accessory_adv_id
     */
    public int getAccessory_adv_id() {
        return accessory_adv_id;
    }

    /**
     * @param accessory_adv_id the accessory_adv_id to set
     */
    public void setAccessory_adv_id(int accessory_adv_id) {
        this.accessory_adv_id = accessory_adv_id;
    }

    /**
     * @return the access_img_id
     */
    public double getAccess_img_id() {
        return access_img_id;
    }

    /**
     * @param access_img_id the access_img_id to set
     */
    public void setAccess_img_id(double access_img_id) {
        this.access_img_id = access_img_id;
    }

    /**
     * @return the access_title
     */
    public String getAccess_title() {
        return access_title;
    }

    /**
     * @param access_title the access_title to set
     */
    public void setAccess_title(String access_title) {
        this.access_title = access_title;
    }

    /**
     * @return the access_condition
     */
    public String getAccess_condition() {
        return access_condition;
    }

    /**
     * @param access_condition the access_condition to set
     */
    public void setAccess_condition(String access_condition) {
        this.access_condition = access_condition;
    }

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
     * @return the accessory_id
     */
    public int getAccessory_id() {
        return accessory_id;
    }

    /**
     * @param accessory_id the accessory_id to set
     */
    public void setAccessory_id(int accessory_id) {
        this.accessory_id = accessory_id;
    }

    /**
     * @return the access_descript
     */
    public String getAccess_descript() {
        return access_descript;
    }

    /**
     * @param access_descript the access_descript to set
     */
    public void setAccess_descript(String access_descript) {
        this.access_descript = access_descript;
    }

    /**
     * @return the access_typof_ad
     */
    public String getAccess_typof_ad() {
        return access_typof_ad;
    }

    /**
     * @param access_typof_ad the access_typof_ad to set
     */
    public void setAccess_typof_ad(String access_typof_ad) {
        this.access_typof_ad = access_typof_ad;
    }

    /**
     * @return the access_price
     */
    public double getAccess_price() {
        return access_price;
    }

    /**
     * @param access_price the access_price to set
     */
    public void setAccess_price(double access_price) {
        this.access_price = access_price;
    }

    /**
     * @return the access_xpect_price
     */
    public double getAccess_xpect_price() {
        return access_xpect_price;
    }

    /**
     * @param access_xpect_price the access_xpect_price to set
     */
    public void setAccess_xpect_price(double access_xpect_price) {
        this.access_xpect_price = access_xpect_price;
    }

    /**
     * @return the access_posting_date
     */
    public String getAccess_posting_date() {
        return access_posting_date;
    }

    /**
     * @param access_posting_date the access_posting_date to set
     */
    public void setAccess_posting_date(String access_posting_date) {
        this.access_posting_date = access_posting_date;
    }

    /**
     * @return the access_subcat_id
     */
    public int getAccess_subcat_id() {
        return access_subcat_id;
    }

    /**
     * @param access_subcat_id the access_subcat_id to set
     */
    public void setAccess_subcat_id(int access_subcat_id) {
        this.access_subcat_id = access_subcat_id;
    }

    /**
     * @return the listOfPostAccessory
     */
    public List<PostAccessoryVO> getListOfPostAccessory() {
        return listOfPostAccessory;
    }

    /**
     * @param listOfPostAccessory the listOfPostAccessory to set
     */
    public void setListOfPostAccessory(List<PostAccessoryVO> listOfPostAccessory) {
        this.listOfPostAccessory = listOfPostAccessory;
    }
    
    
}
