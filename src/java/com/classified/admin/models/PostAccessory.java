/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.PostAccessoryVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface PostAccessory {
    
    public ResultVO storePostAccessoryInfo(PostAccessoryVO postAccessoryVO);
    public PostAccessoryVO populatePostAccessoryInfo(int accessory_adv_id);
    public ResultVO deletePostAccessoryInfo(int accessory_adv_id);
    public PostAccessoryVO modifyPostAccessoryInfo(PostAccessoryVO postAccessoryVO);
    public ResultVO searchPostAccessoryInfo(int accessory_adv_id);
    public List<PostAccessoryVO> viewAllPostAccessoryInfo(); 
}
