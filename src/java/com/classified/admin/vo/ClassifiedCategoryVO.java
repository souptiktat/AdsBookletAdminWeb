/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.vo;

/**
 *
 * @author a
 */
public class ClassifiedCategoryVO {
    private int classified_category_id;
    private String classified_category_name;

    /**
     * @return the classified_category_id
     */
    public int getClassified_category_id() {
        return classified_category_id;
    }

    /**
     * @param classified_category_id the classified_category_id to set
     */
    public void setClassified_category_id(int classified_category_id) {
        this.classified_category_id = classified_category_id;
    }

    /**
     * @return the classified_category_name
     */
    public String getClassified_category_name() {
        return classified_category_name;
    }

    /**
     * @param classified_category_name the classified_category_name to set
     */
    public void setClassified_category_name(String classified_category_name) {
        this.classified_category_name = classified_category_name;
    }
}
