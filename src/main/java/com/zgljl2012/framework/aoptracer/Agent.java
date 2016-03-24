package com.zgljl2012.framework.aoptracer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class Agent {
	
	public static void agentmain(String args, Instrumentation inst) {
		ClassTransformer transformer = new ClassTransformer(); 
		System.out.println(inst.toString());
		inst.addTransformer((ClassFileTransformer) transformer);
	}

}
