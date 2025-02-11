package com.springDingDong.suyong.Week2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("request")
@RequiredArgsConstructor
public class RequestController {
    @PersistenceContext
    private final EntityManager em;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/member")
    @Transactional
    public Long testPost(@RequestBody Member member) {
        System.out.println("member : " + member);
        em.persist(member);
        return member.getId();
    }
}
