/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.AccessoryTypeVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface AdminInterface {
    public ResultVO storeAccessoryInfo(AccessoryTypeVO accessTypeVO);
    public AccessoryTypeVO populateAccessoryInfo(int accessory_id);
    public ResultVO deleteAccessoryInfo(int accessory_id);
    public AccessoryTypeVO modifyAccessoryInfo(AccessoryTypeVO accessTypeVO);
    public ResultVO searchAccessoryInfo(int accessory_id);
    public List<AccessoryTypeVO> viewAllAccessoryInfo(); 
}
