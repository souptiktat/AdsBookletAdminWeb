/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiModelVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MobiModel {
    
    public ResultVO storeMobiModelInfo(MobiModelVO mobiModelVO);
    public MobiModelVO populateMobiModelInfo(int model_id);
    public ResultVO deleteMobiModelInfo(int model_id);
    public MobiModelVO modifyMobiModelInfo(MobiModelVO mobiModelVO);
    public ResultVO searchMobiModelInfo(int model_id);
    public List<MobiModelVO> viewAllMobiModelInfo();
    
}
