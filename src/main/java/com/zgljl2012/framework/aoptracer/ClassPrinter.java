package com.zgljl2012.framework.aoptracer;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassPrinter extends ClassVisitor implements Opcodes {

	public ClassPrinter(int api, ClassVisitor cv) {
		super(api, cv);
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
	    if (!name.equals("hello"))
            return super.visitMethod(access, name, desc, signature, exceptions);;
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        return new AopMethod(this.api, mv);
	}
	
	public class AopMethod extends MethodVisitor implements Opcodes {
	    public AopMethod(int api, MethodVisitor mv) {
	        super(api, mv);
	    }
	    public void visitCode() {
	        super.visitCode();
	        this.visitMethodInsn(INVOKESTATIC, "com/zgljl2012/framework/aoptracer/AopInterceptor", "beforeInvoke", "()V");
	    }
	    public void visitInsn(int opcode) {
	        if (opcode == RETURN) {
	            mv.visitMethodInsn(INVOKESTATIC, "com/zgljl2012/framework/aoptracer/AopInterceptor", "afterInvoke", "()V");
	        }
	        super.visitInsn(opcode);
	    }
	}

}
