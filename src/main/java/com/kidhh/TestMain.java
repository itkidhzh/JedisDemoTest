package com.kidhh;

/**
 * @ClassName
 * @Description: TODO
 * @Author: kidhzh@outlook.com
 */
public class TestMain {
    public static void main(String[] args) {
        Thread thread01 = new Thread(new MyRun("游客", 5));
        Thread thread02 = new Thread(new MyRun("普通用户", 10));
        Thread thread03 = new Thread(new MyRun("VIP用户", 50));

        thread01.start();
        thread02.start();
        thread03.start();
    }
}
