package com.wkcto.stream;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的基本操作
 * Author : 动力节点老崔
 */
public class Test02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "wkcto", "good", "hello", "jj", "xx", "jj", "jj","bjpowernode","xx", "good");
        //1)通过List集合获得Stream流
        Stream<String> stream = list.stream();

        //2流的中间操作
        //2.1 流的筛选与切片
        //distinct()去掉重复的数据
        stream.distinct().forEach(System.out::println);
        System.out.println("-----------------------");

        //filter()过滤
//        stream.filter(x->x.length() > 4).forEach(System.out::println);  //java.lang.IllegalStateException: 流已关闭, 流只能使用一次
        list.stream().filter(x->x.length() > 4).forEach(System.out::println);
        System.out.println("-----------------------");

        //sort()排序
        list.stream().sorted(String::compareTo).forEach(System.out::println);
        System.out.println("-----------------------");

        //limt()截断操作
        list.stream().limit(5).forEach(System.out::println);
        System.out.println("-----------------------");

        //skip()跳过
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("-----------------------");

        //2.2 map映射
        //map映射转换元素, map方法接受一个函数, 把这个函数应用于每个元素上,并将它映射为一个新的元素
        list.stream()
                .map(String::toUpperCase)   //为每个元素应用toUpperCase()把小写转换为大写
                .forEach(System.out::println);
        System.out.println("-----------------------");

        list.stream()
                .map(String::length)
                .map(len -> len + "  ")
                .forEach(System.out::print);
        System.out.println();
        System.out.println("-----------------------");

        //转换为数值流
        List<Integer> integerList = Arrays.asList(54,1,78,90,345);
        IntStream intStream = integerList.stream().mapToInt(x -> x);
        intStream.forEach(x -> System.out.print( x + " "));
        System.out.println();
        System.out.println("-----------------------");

        //2.3 匹配与查找操作
        //allMatch()判断流中所有的元素是否都匹配给定的谓词
        System.out.println( list.stream().allMatch(s -> s.length() > 3 ) );     //false
        //anyMatch()判断流中是否有某个元素可以匹配指定的谓词
        System.out.println( list.stream().anyMatch(s -> s.equals("wkcto")));    //true
        //noneMathc()判断流中的元素是否都没有匹配指定谓词的
        System.out.println( list.stream().noneMatch(s -> s.equals("jj")));      //false

        //查找
        System.out.println(list.stream().filter(s -> s.length() > 10).findAny().get() );
        System.out.println( list.stream().filter(s -> s.length() > 20).findFirst().orElse("不存在"));

        //3 Stream流的终端操作
        //3.1 forEach遍历
        list.stream().forEach(System.out::println);

        //3.2 cout统计
        System.out.println( list.stream().filter(x->x.length() > 2).count());

        //3.3 reduce归纳合并
        Optional<String> reduce = list.stream().reduce((s1, s2) -> s1 + "--" + s2);
        System.out.println(reduce.get());
        reduce.ifPresent(System.out::println);

        //数值操作
        List<Integer> list2 = Arrays.asList(6,21,87,34,1,78,54);
        //求和,指定初始值
        System.out.println(list2.stream().reduce(0, Integer::sum) );
        //求和,没有初始值
        System.out.println(list2.stream().reduce((x,y)->x+y).orElse(0) );
        //最值
        System.out.println(list2.stream().reduce(Math::max).get() );
        System.out.println(list2.stream().reduce(Math::min).get() );

        //3.4映射到数值流
        System.out.println(list2.stream().mapToInt(x->x).sum() );       //求和
        System.out.println(list2.stream().mapToInt(x->x).max().getAsInt() );    //最大值
        System.out.println(list2.stream().mapToInt(x->x).min().orElse(0) );     //最小值
        System.out.println(list2.stream().mapToDouble(x->x).average().getAsDouble());   //平均值
        System.out.println(list2.stream().max(Integer::compareTo).get());
        list2.stream().min(Integer::compareTo).ifPresent(System.out::println);

        //3.5 collect归约
        //把stream流转换为集合
        Set<String> stringSet = list.stream().collect(Collectors.toSet());
        System.out.println( stringSet );

        //把Stream流转换为数组
        Object[] objects = list.stream().toArray();
        System.out.println( Arrays.toString(objects));
        String[] toArray = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(toArray));

        //Stream流转换为字符串
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
