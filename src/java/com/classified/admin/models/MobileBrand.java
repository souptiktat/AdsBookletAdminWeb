/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobileBrandVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MobileBrand {
    public ResultVO storeMobileBrandInfo(MobileBrandVO mobileBrandVO);
    public MobileBrandVO populateMobileBrandInfo(int brand_id);
    public ResultVO deleteMobileBrandInfo(int brand_id);
    public MobileBrandVO modifyMobileBrandInfo(MobileBrandVO mobileBrandVO);
    public ResultVO searchMobileBrandInfo(int brand_id);
    public List<MobileBrandVO> viewAllMobileBrandInfo();
}
