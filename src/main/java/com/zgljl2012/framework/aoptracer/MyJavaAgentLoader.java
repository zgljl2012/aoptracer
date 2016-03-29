package com.zgljl2012.framework.aoptracer;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.sun.tools.attach.VirtualMachine;

public class MyJavaAgentLoader {
	
	public static String jarFilePath = "C:\\Users\\Administrator\\.m2\\repository\\com\\zgljl2012\\framework"
    		+ "\\aoptracer\\0.0.1-SNAPSHOT\\aoptracer-0.0.1-SNAPSHOT.jar";
	
	public static void loadAgent() {
       String pid = getProcessID();
       try {
           VirtualMachine vm = VirtualMachine.attach(pid);
           vm.loadAgent(jarFilePath, "");
           vm.detach();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
	
	private static final String getProcessID() {  
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return ""+Integer.valueOf(runtimeMXBean.getName().split("@")[0])  
                .intValue();  
    }
	
}
