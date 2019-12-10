package com.qfedu.user.web;

import com.qfedu.common.vo.R;
import com.qfedu.dto.MemberQueryDto;
import com.qfedu.user.entity.Member;
import com.qfedu.user.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "实现会员的相关操作",tags = "实现会员的相关操作")
@RestController // 标记返回的是字符串 json/xml格式 代替@Controller + @ResponseBody
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "校验会员的注册名称是否重复",notes = "校验会员的注册名称是否重复")
    @GetMapping("/api/user/member/checkName.do")
    public R checkMsg(String msg) {
        return memberService.queryByMsg(msg);
    }

    @ApiOperation(value = "实现会员的注册",notes = "实现会员的注册")
    @PostMapping("/api/user/member/register.do")
    public R register(@RequestBody Member member) {
        return memberService.register(member);
    }

    @ApiOperation(value = "实现会员的登录", notes = "实现会员的登录")
    @GetMapping("/api/user/member/login.do")
    public R login(String name, String password) {
        return memberService.login(name, password);
    }

    @ApiOperation(value = "查询全部内容分页",notes = "查询全部内容分页")
    @PostMapping("/api/user/member/checkName.do")
    public R page(@RequestBody MemberQueryDto queryDto){
        return memberService.search(queryDto);
    }
}
