package com.springDingDong.suyong.assignment1;

public class Dog implements Animal {
    @Override
    public void move() {
        System.out.println("성큼성큼");
    }

    @Override
    public void bark() {
        System.out.println("왈왈");
    }

    @Override
    public void eat(String name) {
        System.out.println(name + ", 이거 먹으렴.");
    }

    @Override
    public String walk(String name) {
        System.out.println(name + ", 밥 먹었으니깐 산책하러 가자~");
        System.out.println("오늘은 다른 공원 가보자~");
        System.out.println("날씨가 너무 춥다. 빨리 집 가자!");
        return name + "는 항상 나랑 몇 시간동안 산책하는 것을 즐긴다.";
    }

}
