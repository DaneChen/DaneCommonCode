package com.dane.commonsample.test;

import java.util.ArrayList;
import java.util.List;

public class TestT {

    public static void testSuper() {
        List<Number> numberList = new ArrayList<>();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        List<Object> integerList2 = new ArrayList<>();
        integerList2.add("");

        copyAll(numberList, integerList);
        copyAll2(numberList, integerList);
    }

    private static <T> void copyAll(List<T> to, List<? extends T> from) {
        from.remove(0);
        to.addAll(from);
    }

    private static <T> void copyAll2(List<? super T> to, List<T> from) {
        to.addAll(from);
    }

    private static void test2(List<User2> userList){

        userList.add(new User2());
        userList.add(new Teacher());
        userList.add(new Student());
        userList.add(new HighSchoolStudent());

        User2 user = userList.get(0);

        List<? super User2> userList2 = new ArrayList<>();
        userList2.add(new User2());
        userList2.add(new Teacher());
        userList2.add(new Student());
        userList2.add(new HighSchoolStudent());
        //User2 user1 = userList2.get(0);
    }

    public static class User2{

    }

    public static class Teacher extends User2{

    }

    public static class Student extends User2{

    }

    public static class HighSchoolStudent extends Student{

    }
}
