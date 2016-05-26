/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.vo;

import java.io.Serializable;

/**
 *
 * @author a
 */
public class AccessoryTypeVO implements Serializable{
    private int accessory_id;
    private String accessory_name;
    private String access_posting_date;

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
     * @return the accessory_name
     */
    public String getAccessory_name() {
        return accessory_name;
    }

    /**
     * @param accessory_name the accessory_name to set
     */
    public void setAccessory_name(String accessory_name) {
        this.accessory_name = accessory_name;
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
}
