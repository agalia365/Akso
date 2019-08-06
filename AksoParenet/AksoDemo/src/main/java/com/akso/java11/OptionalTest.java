package com.akso.java11;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("");
        System.out.println(optional.isEmpty()); // false
        System.out.println(optional.isPresent()); // true
        optional = Optional.empty();
        System.out.println(optional.isEmpty()); // true
        System.out.println(optional.isPresent()); // false

        var obj = optional.orElseThrow();
        System.out.println(obj);
    }

    @Test
    public void test() {
        Consumer<String> con = (@Deprecated var x) -> System.out.println(x);
    }
}
