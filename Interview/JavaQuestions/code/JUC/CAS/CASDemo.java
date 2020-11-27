/*
 * @author yangjiewei
 * @date 2020/11/21 19:23
 */
package com.yjiewei.CAS;

import java.util.concurrent.atomic.AtomicInteger;

// CAS 比较并交换
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.compareAndSet(1,2020)+ " " +atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(1,1024)+ " " +atomicInteger.get());
    }
}
