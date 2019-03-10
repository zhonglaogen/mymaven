package com.rentbook;

public class Test {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        try{
            System.out.println(1);
        }catch (Exception e){

        }finally {
            System.out.println(2);
        }
        System.out.println(3);

    }

}
