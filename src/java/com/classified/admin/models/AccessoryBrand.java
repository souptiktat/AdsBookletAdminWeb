/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.AccessoryBrandVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface AccessoryBrand {
    public ResultVO storeAccessoryInfo(AccessoryBrandVO accessBrandVO);
    public AccessoryBrandVO populateAccessoryInfo(int accessry_brand_id);
    public ResultVO deleteAccessoryInfo(int accessry_brand_id);
    public AccessoryBrandVO modifyAccessoryInfo(AccessoryBrandVO accessBrandVO);
    public ResultVO searchAccessoryInfo(int accessry_brand_id);
    public List<AccessoryBrandVO> viewAllAccessoryInfo(); 
}
