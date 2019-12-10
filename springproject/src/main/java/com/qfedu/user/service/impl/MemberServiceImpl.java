package com.qfedu.user.service.impl;

import com.qfedu.common.result.ResultCode;
import com.qfedu.common.vo.PageBean;
import com.qfedu.common.vo.R;
import com.qfedu.dto.MemberQueryDto;
import com.qfedu.user.dao.MemberMapper;
import com.qfedu.user.entity.Member;
import com.qfedu.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public R queryByMsg(String msg) {
        Member member = memberMapper.selectByMsg(msg);

        if (member == null) {
            // 名称不存在 可用
            return R.Ok();
        } else {
            return R.fail();
        }
    }

    @Override
    public R register(Member member) {
        // 校验是否存在
        if (queryByMsg(member.getUsername()).getCode() == ResultCode.OK.getVal()) {
           int c = memberMapper.insert(member);
           if (c > 0) {
               return R.Ok();
           } else {
               return R.fail();
           }
        } else {
            return R.fail("用户名已经被注册");
        }
    }

    @Override
    public R login(String name, String pass) {
        // 根据用户名查询用户信息
        Member m = memberMapper.selectByMsg(name);
        // 校验用户是否存在
        if (m != null) {
            // 校验密码是否正确
            if (m.getPassword().equals(pass)) {
                // 成功
                // 令牌 Token 有效期 Redis 有效期
                return R.Ok(m.getId());
            }
        }
        return R.fail("用户名或密码错误");
    }

    @Override
    public R search(MemberQueryDto memberQueryDto) {
        // 查询所有的数据
        List<Member> memberList = memberMapper.selectPage(memberQueryDto.getPage(), memberQueryDto.getSize());
        // 实例化分页类
        PageBean<Member> pageBean = new PageBean<>();
        pageBean.setData(memberList);
        pageBean.setPage(memberQueryDto.getPage());
        pageBean.setSize(memberQueryDto.getSize());
        pageBean.setTotalPage(memberMapper.selectCount());
        // 计算总页数
        pageBean.setTotalPage(pageBean.getTotal() % memberQueryDto.getSize() == 0 ?
                pageBean.getTotal() / pageBean.getSize() : pageBean.getTotal() / pageBean.getSize() + 1);
        return R.Ok(pageBean);
    }
}
