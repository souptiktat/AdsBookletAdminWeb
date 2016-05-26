/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiOSTabVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MobiOSTab {
    
    public ResultVO storeMobiOSTabInfo(MobiOSTabVO mobiOSTabVO);
    public MobiOSTabVO populateMobiOSTabInfo(int os_id);
    public ResultVO deleteMobiOSTabInfo(int os_id);
    public MobiOSTabVO modifyMobiOSTabInfo(MobiOSTabVO mobiOSTabVO);
    public ResultVO searchMobiOSTabInfo(int os_id);
    public List<MobiOSTabVO> viewAllMobiOSTabInfo();
}
