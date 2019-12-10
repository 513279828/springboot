package com.qfedu.user.service;

import com.qfedu.common.vo.R;
import com.qfedu.dto.MemberQueryDto;
import com.qfedu.user.entity.Member;

public interface MemberService {
    //查询
    R queryByMsg(String msg);
    //注册
    R register(Member member);
    //登录
    R login(String name,String pass);
    //后台管理系统 搜索接口 分页
    R search(MemberQueryDto memberQueryDto);
}
