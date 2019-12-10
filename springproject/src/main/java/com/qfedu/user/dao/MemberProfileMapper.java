package com.qfedu.user.dao;

import com.qfedu.user.entity.MemberProfile;
import com.qfedu.user.entity.MemberProfileExample;
import java.util.List;

public interface MemberProfileMapper {
    int insert(MemberProfile record);

    int insertSelective(MemberProfile record);

    List<MemberProfile> selectByExample(MemberProfileExample example);
}