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
public class ClassifiedSubCategoryVO {
    private int classified_sub_category_id;
    private int classified_category_id;
    private String classified_sub_category_name;

    /**
     * @return the classified_sub_category_id
     */
    public int getClassified_sub_category_id() {
        return classified_sub_category_id;
    }

    /**
     * @param classified_sub_category_id the classified_sub_category_id to set
     */
    public void setClassified_sub_category_id(int classified_sub_category_id) {
        this.classified_sub_category_id = classified_sub_category_id;
    }

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
     * @return the classified_sub_category_name
     */
    public String getClassified_sub_category_name() {
        return classified_sub_category_name;
    }

    /**
     * @param classified_sub_category_name the classified_sub_category_name to set
     */
    public void setClassified_sub_category_name(String classified_sub_category_name) {
        this.classified_sub_category_name = classified_sub_category_name;
    }
}
