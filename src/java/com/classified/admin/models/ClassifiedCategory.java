/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.ClassifiedCategoryVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface ClassifiedCategory {
    public ResultVO storeClassifiedInfo(ClassifiedCategoryVO classifiedCatVO);
    public ClassifiedCategoryVO populateClassifiedInfo(int classified_category_id);
    public ResultVO deleteClassifiedInfo(int classified_category_id);
    public ClassifiedCategoryVO modifyClassifiedInfo(ClassifiedCategoryVO classifiedCatVO);
    public ResultVO searchClassifiedInfo(int classified_category_id);
    public List<ClassifiedCategoryVO> viewAllClassifiedInfo(); 
}
