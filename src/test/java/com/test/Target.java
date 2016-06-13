package com.test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.zgljl2012.framework.aoptracer.Agent;

public class Target {
	
	static {
		Agent.initialize();
	}
	
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
