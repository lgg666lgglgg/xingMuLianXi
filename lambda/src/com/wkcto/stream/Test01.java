package com.wkcto.stream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的创建
 * Author : 动力节点老崔
 */
public class Test01 {
    public static void main(String[] args) {
        //1 如何获得流,可以通过Collection集合,数据, 根据字面量获得流
        //1.1 通过Collection获得流
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"wkcto","hello", "jj", "dd", "mm", "bjpowernode");
        Stream<String> stream1 = list.stream();
//        System.out.println(stream1);
        stream1.forEach(System.out::println);

        //1.2 根据数据获得流
        String[]data = {"zhangsan","lisi","wangwu"};
        Stream<String> stream2 = Arrays.stream(data);
        stream2.forEach(s -> System.out.print(s + "  "));
        System.out.println();

        //1.3 直接通过值获得流
        Stream<String> stream3 = Stream.of("1", "2", "3", "4");
        stream3.forEach(s -> System.out.print(s + "  "));
        System.out.println();

        //1.4 无限流
        Stream.iterate(100, x->x+3).limit(10).forEach(s -> System.out.print(s + "  "));
        System.out.println();

    }
}
