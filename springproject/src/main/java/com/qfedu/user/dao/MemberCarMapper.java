package com.qfedu.user.dao;

import com.qfedu.user.entity.MemberCar;
import com.qfedu.user.entity.MemberCarExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberCarMapper {
    int insert(MemberCar record);

    /*int insertSelective(MemberCar record);

    List<MemberCar> selectByExample(MemberCarExample example);*/
}