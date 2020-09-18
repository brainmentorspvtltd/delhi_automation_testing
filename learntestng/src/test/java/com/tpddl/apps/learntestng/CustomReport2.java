package com.tpddl.apps.learntestng;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReport2 implements IReporter {
	@Override
	public void generateReport(
		      List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		    	for(ISuite suite : suites) {
		    		Map<String, ISuiteResult> map = suite.getResults();
		    		for(ISuiteResult result : map.values()) {
		    			ITestContext ctx = result.getTestContext();
		    			System.out.println(ctx.getName());
		    			//ctx.getAllTestMethods().
		    			//ctx.getFailedTests().
		    			Object obj [] = ctx.getPassedTests().getAllResults().toArray();
		    			for(Object o : obj) {
		    				System.out.println(o);
		    			}
		    			System.out.println("Pass "+ctx.getPassedTests().size());
		    			System.out.println("Fail "+ctx.getFailedTests().size());
		    		}
		    	}
		  }
}
