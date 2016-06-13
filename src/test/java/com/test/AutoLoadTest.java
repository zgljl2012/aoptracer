package com.test;

import com.zgljl2012.framework.aoptracer.Agent;

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
    	Agent.initialize();
    }
}