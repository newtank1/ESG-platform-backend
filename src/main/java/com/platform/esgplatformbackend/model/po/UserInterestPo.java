package com.platform.esgplatformbackend.model.po;


import com.platform.esgplatformbackend.model.vo.CorporationStockVo;
import com.platform.esgplatformbackend.model.vo.UserInterestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInterestPo {
    /**
     * 用户id
     */
    private int uid;
    /**
     * 公司id
     */
    private int interest_corporation_id;

    public UserInterestPo(UserInterestVo userInterestVo) {
        BeanUtils.copyProperties(userInterestVo, this);
    }
}
