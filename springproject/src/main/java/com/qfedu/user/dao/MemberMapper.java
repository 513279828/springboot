package com.qfedu.user.dao;

import com.qfedu.user.entity.Member;
import com.qfedu.user.entity.MemberExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    int insert(Member record);
    Member selectByMsg(String msg);
    List<Member> selectPage(@Param("page")int page, @Param("size") int size);
    long selectCount();

    /*int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);*/
}