package com.springDingDong.suyong.assignment1;

public class Cat implements Animal {

    @Override
    public void move() {
        System.out.println("사뿐사뿐");
    }

    @Override
    public void bark() {
        System.out.println("야옹");
    }

    @Override
    public void eat(String name) {
        System.out.println(name + ", 빨리 밥 먹으러 와라~");
    }
}
