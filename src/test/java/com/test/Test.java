package com.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.zgljl2012.framework.aoptracer.Agent;

import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

public class Test {
	
	static{
		Agent.initialize();
	}
	
    public static void main(String[] args) throws AttachNotSupportedException,
            IOException, AgentLoadException, AgentInitializationException, MonitorException, URISyntaxException {
        VirtualMachine vm = VirtualMachine.attach(""+getProcess(Target.class));
        vm.loadAgent("C:\\Users\\Administrator\\.m2\\repository\\com\\zgljl2012\\framework"
        		+ "\\aoptracer\\0.0.1-SNAPSHOT\\aoptracer-0.0.1-SNAPSHOT.jar","");
        vm.detach();
    }
    
    public static int getProcess(Class<?> cls) throws MonitorException, URISyntaxException {
		if(cls == null) {
			return -1;
		}
		// 获取监控主机
		MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
		// 取得所有在活动的虚拟机集合
		Set<?> vmlist = new HashSet<Object>(local.activeVms());
		// 遍历集合，输出PID和进程名
		for(Object process : vmlist) {
			MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
			// 获取类名
			String processname = MonitoredVmUtil.mainClass(vm, true);
			if(cls.getName().equals(processname)) {
				return ((Integer)process).intValue();
			}
		}
		return -1;
	}

}