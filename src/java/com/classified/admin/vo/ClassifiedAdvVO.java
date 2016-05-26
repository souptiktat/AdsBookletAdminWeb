/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.vo;

import java.sql.Blob;
//import com.mysql.jdbc.Blob;


/**
 *
 * @author a
 */
public class ClassifiedAdvVO {
    private int classified_image_id;
    private int classified_id;
    private Blob classified_small_image;
    private Blob classified_large_image;

    /**
     * @return the classified_image_id
     */
    public int getClassified_image_id() {
        return classified_image_id;
    }

    /**
     * @param classified_image_id the classified_image_id to set
     */
    public void setClassified_image_id(int classified_image_id) {
        this.classified_image_id = classified_image_id;
    }

    /**
     * @return the classified_id
     */
    public int getClassified_id() {
        return classified_id;
    }

    /**
     * @param classified_id the classified_id to set
     */
    public void setClassified_id(int classified_id) {
        this.classified_id = classified_id;
    }

    /**
     * @return the classified_small_image
     */
    public Blob getClassified_small_image() {
        return classified_small_image;
    }

    /**
     * @param classified_small_image the classified_small_image to set
     */
    public void setClassified_small_image(Blob classified_small_image) {
        this.classified_small_image = classified_small_image;
    }

    /**
     * @return the classified_large_image
     */
    public Blob getClassified_large_image() {
        return classified_large_image;
    }

    /**
     * @param classified_large_image the classified_large_image to set
     */
    public void setClassified_large_image(Blob classified_large_image) {
        this.classified_large_image = classified_large_image;
    }
    
}
