package com.rico.HS;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Rico_dds
 * @date 2020/10/9 18:21
 */
public class HS_01 {
    static class Person{
        private Integer age;

        public Person(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
    public static void main(String[] args) {

        TreeMap<Person,String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(0,o1.getAge() - o2.getAge());
            }
        });

        treeMap.put(new Person(1),"1");
        treeMap.put(new Person(3),"3");
        treeMap.put(new Person(5),"5");
        treeMap.put(new Person(4),"4");
        treeMap.put(new Person(2),"2");
        treeMap.entrySet().stream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });
    }
}
