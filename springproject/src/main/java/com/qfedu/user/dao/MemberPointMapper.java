package com.qfedu.user.dao;

import com.qfedu.user.entity.MemberPoint;
import com.qfedu.user.entity.MemberPointExample;
import java.util.List;

public interface MemberPointMapper {
    int insert(MemberPoint record);

    int insertSelective(MemberPoint record);

    List<MemberPoint> selectByExample(MemberPointExample example);
}