package com.qfedu.user.dao;

import com.qfedu.user.entity.MemberProfileLog;
import com.qfedu.user.entity.MemberProfileLogExample;
import java.util.List;

public interface MemberProfileLogMapper {
    int insert(MemberProfileLog record);

    int insertSelective(MemberProfileLog record);

    List<MemberProfileLog> selectByExample(MemberProfileLogExample example);
}