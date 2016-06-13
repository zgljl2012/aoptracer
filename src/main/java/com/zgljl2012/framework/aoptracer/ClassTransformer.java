package com.zgljl2012.framework.aoptracer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import com.zgljl2012.framework.aoptracer.pointcuts.PointCut;

public class ClassTransformer implements Opcodes, ClassFileTransformer{
	
	List<PointCut> pointCuts;
	
	public ClassTransformer() {
		this.pointCuts = new ArrayList<>();
	}
	
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		try {
			ClassReader cr = new ClassReader(classfileBuffer);
			ClassWriter cw = new ClassWriter(0);
			ClassPrinter cp = new ClassPrinter(ASM4, cw);
			cr.accept(cp, ClassReader.SKIP_DEBUG);
			return cw.toByteArray();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
