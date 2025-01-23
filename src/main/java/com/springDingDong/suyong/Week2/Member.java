package com.springDingDong.suyong.Week2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {
    @Id
    private Long id;

    private String name;
    private int age;

    public Member() { // 기본 생성자 (필수), 자바 빈즈 규약에서 필수다. 의존성 주입하는 곳에는 기본 생성자가 필요하다
    } // jpa에서 엔티티는 기본 생성자를 가져야 한다.

    public Member(Long id, String name, int age) { // 일반 생성자 
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
