package com.zgljl2012.framework.aoptracer.pointcuts;

import com.zgljl2012.framework.aoptracer.tracer.Tracer;

public interface PointCut {
	
	public boolean isMatch();
	
	public Tracer getTracer();
	
}
