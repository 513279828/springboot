package com.qfedu.user.dao;

import com.qfedu.user.entity.MemberTag;
import com.qfedu.user.entity.MemberTagExample;
import java.util.List;

public interface MemberTagMapper {
    int insert(MemberTag record);

    int insertSelective(MemberTag record);

    List<MemberTag> selectByExample(MemberTagExample example);
}