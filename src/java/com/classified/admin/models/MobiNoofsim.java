/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiNoofsimVO;
import com.classified.admin.vo.ResultVO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MobiNoofsim {
    
    public ResultVO storeMobiNoofsimInfo(MobiNoofsimVO mobiNoofsimVO);
    public MobiNoofsimVO populateMobiNoofsimInfo(int noof_id);
    public ResultVO deleteMobiNoofsimInfo(int noof_id);
    public MobiNoofsimVO modifyMobiNoofsimInfo(MobiNoofsimVO mobiNoofsimVO);
    public ResultVO searchMobiNoofsimInfo(int noof_id);
    public List<MobiNoofsimVO> viewAllMobiNoofsimInfo();
}
