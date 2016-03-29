package com.zgljl2012.framework.aoptracer;

import java.lang.instrument.Instrumentation;

public class Agent {
	
	private static Instrumentation inst;
	
	public static void agentmain(String args, Instrumentation inst) {
		ClassTransformer transformer = new ClassTransformer();
		Agent.inst = inst;
		System.out.println("Hello Agent");
		inst.addTransformer(transformer);
	}
	
	public static void premain(String args, Instrumentation inst) {
		agentmain(args, inst);
	}
	
	public static void initialize() {
		if(inst == null) {
			MyJavaAgentLoader.loadAgent();
		}
	}

}
