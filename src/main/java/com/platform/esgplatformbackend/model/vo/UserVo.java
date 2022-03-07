package com.platform.esgplatformbackend.model.vo;


import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import com.platform.esgplatformbackend.model.po.UserPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {

    private int uid;

    private String username;

    private String password;

    private String is_admin;
    public UserVo(UserPo po){
        BeanUtils.copyProperties(po,this);
    }

}
