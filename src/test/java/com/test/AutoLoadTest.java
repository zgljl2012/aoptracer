package com.test;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class AutoLoadTest {
	
	interface B {
		
	}
	
	public class A implements B{
		public void hello() {
			System.out.println("Hello, World");
		}
		
		public A copy(String a) {
			return null;
		}
		
		public void hello2() {
			System.out.println("Hello, World1");
			System.out.println("Hello, World");
		}
	}
	
    public static void main(String[] args){
        
    	new AutoLoadTest().new A().hello();
    	
    }
    
    static {
    	VirtualMachine vm;
    	try {
    		// 将Agent附加在当前Java进程之上
			vm = VirtualMachine.attach(""+getProcessID());
			vm.loadAgent("C:\\Users\\Administrator\\.m2\\repository\\com\\zgljl2012\\framework"
	        		+ "\\aoptracer\\0.0.1-SNAPSHOT\\aoptracer-0.0.1-SNAPSHOT.jar");
		} catch (AttachNotSupportedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AgentLoadException e) {
			e.printStackTrace();
		} catch (AgentInitializationException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 获取当前Java进程的ID
     * @return
     */
    public static final int getProcessID() {  
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();  
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])  
                .intValue();  
    } 

}