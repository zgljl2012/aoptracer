package com.test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Target {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(getProcessID());
		while(true) {
			Thread.sleep(10000);
		}
	}
	
	public static final int getProcessID() {  
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])  
                .intValue();  
    } 
	
	/*
	 * 
	 * 首先，从JDK1.5之后，Java开始提供包：java.lang.management
	java.lang.management 提供了一系列的用来在运行时管理和监督JVM和OS的管理接口。
	 */
}
