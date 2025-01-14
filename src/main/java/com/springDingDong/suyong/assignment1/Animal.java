package com.springDingDong.suyong.assignment1;

public interface Animal {
    public String NAME = "동물";
    public void move();
    public void eat(String name);
    public void bark();

    default String walk(String name) {
        System.out.println();
        System.out.println(name + "산책하러 가자");
        System.out.println("공원으로 향하는 중");
        System.out.println("날이 어두워져서 이제 집 가자");
        return "너무 재밌는 하루였어";
    }

    static void wash(String name) {
        System.out.println();
        System.out.println("자 씻을 시간이야");
        System.out.println("끝났다");
    }


}
