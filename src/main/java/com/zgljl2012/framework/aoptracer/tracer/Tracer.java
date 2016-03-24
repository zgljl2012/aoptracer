package com.zgljl2012.framework.aoptracer.tracer;

import java.util.Map;

public interface Tracer {
	
	public long getStartTime();
	
	public long getEndTime();
	
	public Map<String, String> getParameters();
	
	public void finish();
	
}
