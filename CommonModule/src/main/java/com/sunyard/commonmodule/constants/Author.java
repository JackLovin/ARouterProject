package com.sunyard.commonmodule.constants;

/**
 * @package name：com.sunyard.arouterdemo
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/15 10:05 AM
 */
public class Author {
     String name;
     int age;
     String county;

     public Author(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }
}