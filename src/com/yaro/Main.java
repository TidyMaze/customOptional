package com.yaro;

public class Main {

    public static void main(String[] args) {
        Optional<Integer> opt1 = Optional.of(1);
        System.out.println(opt1.orElse(2));
        Optional<Integer> opt2 = Optional.empty();
        System.out.println(opt2.orElse(2));
    }
}
