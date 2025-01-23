package com.springDingDong.suyong.Week2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("member")
    public String postMember(@RequestBody final Member member) {
        return member.getName();

    }

    @PutMapping("member")
    public String putMember(@RequestBody final Member member) {
        return member.getName();
    }
}
