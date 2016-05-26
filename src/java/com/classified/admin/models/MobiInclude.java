/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiIncludeVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MobiInclude {
    
    public ResultVO storeMobileIncludeInfo(MobiIncludeVO mobiIncludeVO);
    public MobiIncludeVO populateMobileIncludeInfo(int includ_tab_id);
    public ResultVO deleteMobileIncludeInfo(int includ_tab_id);
    public MobiIncludeVO modifyMobileIncludeInfo(MobiIncludeVO mobiIncludeVO);
    public ResultVO searchMobileIncludeInfo(int includ_tab_id);
    public List<MobiIncludeVO> viewAllMobileIncludeInfo();
}
