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
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])  
                .intValue();  
    } 
}
