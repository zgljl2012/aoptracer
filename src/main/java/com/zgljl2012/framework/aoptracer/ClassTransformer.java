package com.zgljl2012.framework.aoptracer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.framework.aoptracer.pointcuts.PointCut;

public class ClassTransformer implements ClassFileTransformer{
	
	List<PointCut> pointCuts;
	
	public ClassTransformer() {
		this.pointCuts = new ArrayList<>();
	}
	
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		System.out.println("transform");
		return classfileBuffer;
	}
	
}
