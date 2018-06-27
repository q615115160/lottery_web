package com.czc.utils;

import java.util.UUID;

/**
 * ClassName:UUIDUtils
 * Description:
 */
public class UUIDUtils {
    /**
     * 随机生成id
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 生成随机码
     * @return
     */
    public static String getCode(){
        return getId();
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}
