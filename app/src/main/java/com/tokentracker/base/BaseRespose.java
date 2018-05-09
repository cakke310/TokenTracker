package com.tokentracker.base;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * on 2016.09.9:47
 */
public class BaseRespose<T> implements Serializable {
    public String ret;
    public String msg;

    public T data;

    public boolean success() {
        return "200".equals(ret);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "ret='" + ret + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
