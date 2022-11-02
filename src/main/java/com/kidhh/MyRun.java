package com.kidhh;

/**
 * @ClassName
 * @Description: TODO
 * @Author: kidhzh@outlook.com
 */
public class MyRun implements Runnable{
    private Server sc = null;

    /**
     *
     * @param id 用户操作等级
     * @param num 用户操作数量
     */
    public MyRun(String id,int num){
        sc = new Server(id,num);
    }

    public void run() {
        while (true){
            sc.server();
            // 让当前的 server 休眠 1000 毫秒后执行一次
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
