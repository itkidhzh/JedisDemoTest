package com.kidhh;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * @ClassName
 * @Description: TODO
 * @Author: kidhzh@outlook.com
 */
public class Server {
    private String id; // 用户等级
    private int num; // 用户可操作的次数

    public Server(String id,int num){
        this.id = id;
        this.num = num;
    }

    /**
     * 权限单元
     */
    public void server(){
        Jedis jedis = JedisUtils.getJedis();
        String value = jedis.get("USERID:" + id);

        try {
            if(null == value){
                jedis.setex("USERID:" + id,50,Long.MAX_VALUE - num + "");
            }else {
                // 如果存在，先自增再下载
                Long val = jedis.incr("USERID:" + id);
                downLoad(id,num - (Long.MAX_VALUE - val) );
            }
        }catch (JedisDataException e){
            System.out.println(Thread.currentThread().getName() + "会员等级不足，请提升会员等级 ！~");
            return;
        }finally {
            jedis.close();
        }

    }
    public void downLoad(String id,Long val){
        System.out.println("用户 ：" + id + "下载第" + val + "次");
    }


}
