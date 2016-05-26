/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.ClassifiedAdvVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface ClassifiedAdvPhoto {
    public ResultVO storeClassifiedAdvInfo(ClassifiedAdvVO classifiedAdvVO);
    public ClassifiedAdvVO populateClassifiedAdvInfo(int classified_image_id);
    public ResultVO deleteClassifiedAdvInfo(int classified_image_id);
    public ClassifiedAdvVO modifyClassifiedAdvInfo(ClassifiedAdvVO classifiedAdvVO);
    public ResultVO searchClassifiedAdvInfo(int classified_image_id);
    public List<ClassifiedAdvVO> viewAllClassifiedAdvInfo();
}
