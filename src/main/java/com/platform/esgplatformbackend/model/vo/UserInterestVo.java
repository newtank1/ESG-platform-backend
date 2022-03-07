package com.platform.esgplatformbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInterestVo {

    /**
     * 用户id
     */
    private int uid;
    /**
     * 公司id
     */
    private int interest_corporation_id;

}
