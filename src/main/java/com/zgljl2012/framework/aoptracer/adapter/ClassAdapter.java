package com.zgljl2012.framework.aoptracer.adapter;

import java.util.List;

import com.zgljl2012.framework.aoptracer.pointcuts.PointCut;

public class ClassAdapter {
	
	private List<PointCut> pointCuts;
	
	private String className;
	
	public ClassAdapter visit() {
		return null;
	}
	
	public ClassAdapter visitEnd() {
		return null;
	}
	
	public ClassAdapter visitField() {
		return null;
	}
	
	public ClassAdapter visitMethod() {
		return null;
	}
	
	public ClassAdapter visitAnnotations() {
		return null;
	}
	
}
