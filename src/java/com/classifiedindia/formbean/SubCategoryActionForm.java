

package com.classifiedindia.formbean;

import com.classifiedindia.vo.CategoryVO;
import java.util.ArrayList;


public class SubCategoryActionForm extends org.apache.struts.action.ActionForm {
    
    private String category;
    private String subcategoryName;
    private String subcategoryId;
    private ArrayList<CategoryVO> subcatlist;

    public ArrayList<CategoryVO> getSubcatlist() {
        return subcatlist;
    }

    public void setSubcatlist(ArrayList<CategoryVO> subcatlist) {
        this.subcatlist = subcatlist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }


}
    