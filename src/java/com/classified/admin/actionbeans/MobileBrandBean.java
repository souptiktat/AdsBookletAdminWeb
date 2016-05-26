/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.actionbeans;

import com.classified.admin.vo.MobileBrandVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author a
 */
public class MobileBrandBean extends org.apache.struts.action.ActionForm {
    
    private int brand_id;
    private String brand_name;
    private List<MobileBrandVO> listOfMobileBrand;

    /**
     * @return the brand_id
     */
    public int getBrand_id() {
        return brand_id;
    }

    /**
     * @param brand_id the brand_id to set
     */
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    /**
     * @return the brand_name
     */
    public String getBrand_name() {
        return brand_name;
    }

    /**
     * @param brand_name the brand_name to set
     */
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    /**
     * @return the listOfMobileBrand
     */
    public List<MobileBrandVO> getListOfMobileBrand() {
        return listOfMobileBrand;
    }

    /**
     * @param listOfMobileBrand the listOfMobileBrand to set
     */
    public void setListOfMobileBrand(List<MobileBrandVO> listOfMobileBrand) {
        this.listOfMobileBrand = listOfMobileBrand;
    }
}
