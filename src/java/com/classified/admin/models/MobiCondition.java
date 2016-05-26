/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiConditionVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MobiCondition {
    public ResultVO storeMobiCondInfo(MobiConditionVO mobiCondVO);
    public MobiConditionVO populateMobiCondInfo(String cond_id);
    public ResultVO deleteMobiCondInfo(String cond_id);
    public MobiConditionVO modifyMobiCondInfo(MobiConditionVO mobiCondVO);
    public ResultVO searchMobiCondInfo(String cond_id);
    public List<MobiConditionVO> viewAllMobiCondInfo();
}
