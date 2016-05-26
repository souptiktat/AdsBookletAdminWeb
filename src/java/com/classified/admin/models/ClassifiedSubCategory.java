/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.ClassifiedSubCategoryVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface ClassifiedSubCategory {
    public ResultVO storeClassifiedSubInfo(ClassifiedSubCategoryVO classifiedSubCatVO);
    public ClassifiedSubCategoryVO populateClassifiedSubInfo(int classified_sub_category_id);
    public ResultVO deleteClassifiedSubInfo(int classified_sub_category_id);
    public ClassifiedSubCategoryVO modifyClassifiedSubInfo(ClassifiedSubCategoryVO classifiedSubCatVO);
    public ResultVO searchClassifiedSubInfo(int classified_sub_category_id);
    public List<ClassifiedSubCategoryVO> viewAllClassifiedSubInfo(); 
}
