package com.jeff.admin.service.member;

import org.springframework.stereotype.Component;

@Component
public class MemberServiceHystrix implements MemberService{
    @Override
    public String sayHi(String name) {
        return "sorry"+name;
    }
}
