package com.test;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Test {
	
    public static void main(String[] args) throws AttachNotSupportedException,
            IOException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach("5612");
        vm.loadAgent("C:\\Users\\Administrator\\.m2\\repository\\com\\zgljl2012\\framework"
        		+ "\\aoptracer\\0.0.1-SNAPSHOT\\aoptracer-0.0.1-SNAPSHOT.jar");

    }

}