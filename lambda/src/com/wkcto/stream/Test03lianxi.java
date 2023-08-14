package com.wkcto.stream;

import com.wkcto.stream.Car;
import com.wkcto.stream.CarType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Author : 动力节点老崔
 */
public class Test03lianxi {
    public static void main(String[] args) {
        //把Car小汽车的数据保存到List集合中
        List<Car> carshop = new ArrayList<>();
        carshop.add(new Car("Benz", false, 68, CarType.SUV));
        carshop.add(new Car("Audi", true, 28, CarType.HATCHBACK));
        carshop.add(new Car("BMW", false, 88, CarType.HATCHBACK));
        carshop.add(new Car("Geeley", true, 18, CarType.HATCHBACK));
        carshop.add(new Car("Xiali", true, 8, CarType.THREECOMPARTMENT));
        carshop.add(new Car("Haval", false, 18, CarType.SUV));
        carshop.add(new Car("Jeep", true, 38, CarType.SUV));
        carshop.add(new Car("Honda", false, 28, CarType.THREECOMPARTMENT));
        carshop.add(new Car("Chery", true, 18, CarType.THREECOMPARTMENT));
        carshop.add(new Car("Benz", false, 58, CarType.THREECOMPARTMENT));

        //1根据价格降序排序后,显示汽车品牌
        carshop.stream()
                .sorted((c1,c2) -> c2.getPrice()-c1.getPrice())
                .map(Car::getBrand)
                .distinct()
                .forEach(System.out::println);
        System.out.println("---------------------");

        //2 找出已卖的车, 按价格升序排序
        carshop.stream()
                .filter(car -> car.isSold() )
                .sorted(Comparator.comparing(Car::getPrice))
                .forEach(System.out::println);
        System.out.println("---------------------");

        //3 查看有哪些车型
        carshop.stream().map(x->x.getType()).distinct().forEach(System.out::println);
        System.out.println("---------------------");

        //4SUV型号的车有哪些

        carshop.stream().filter(x->x.getType()==CarType.SUV)
                .map(car -> car.getBrand())
                .forEach(System.out::println);

        System.out.println("---------------------");
        // 40万以下的车的品牌, 排序
        carshop.stream().filter(x->x.getPrice()<40)
                        .map(Car::getBrand)
                                .forEach(System.out::println);

        System.out.println("---------------------");

        //6)统计没有卖出去的车的数量

        long count = carshop.stream().filter(x -> !x.isSold())
                .count();
        System.out.println(count);
        System.out.println("---------------------");
        //7)判断是否有Geeley品牌的汽车
        boolean anyMatch = carshop.stream().anyMatch(s -> s.getBrand().equals("Geeley"));

        System.out.println(anyMatch);
        //8)最贵的车的价格
        System.out.println("---------------------");
        //9)显示已卖出去最贵的车
    }
}
