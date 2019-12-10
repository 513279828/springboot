package com.qfedu.user.dao;

import com.qfedu.user.entity.MemberFav;
import com.qfedu.user.entity.MemberFavExample;
import java.util.List;

public interface MemberFavMapper {
    int insert(MemberFav record);

    int insertSelective(MemberFav record);

    List<MemberFav> selectByExample(MemberFavExample example);
}