package com.springDingDong.suyong.assignment1;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Cat();
        System.out.println("고양이는 " + animal.NAME + "이다.");
        animal.move();
        animal.bark();
        animal.eat("깜아");

        System.out.println("\n***************");
        System.out.println("\n");

        animal = new Dog();
        System.out.println("강아지는 " + animal.NAME +"이다.");
        animal.move();
        animal.bark();
        animal.eat("맥스");
        animal.walk("맥스");
        Animal.wash(" 맥스");
    }
}
