package com.brainmentors.datadriven.mycompanion.reports;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.brainmentors.datadriven.mycompanion.utils.Constants;
import com.brainmentors.datadriven.mycompanion.utils.MailSender;
import com.brainmentors.datadriven.mycompanion.utils.PDFReader;
import com.brainmentors.datadriven.mycompanion.utils.PropertyReader;
import com.itextpdf.text.DocumentException;

public class CustomReport implements IReporter {
	@Override
	public void generateReport(
		      List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		String msg  = "";
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% TESTNG CUSTOM REPORT %%%%%%%%%%%%%%%%%%%");
		for(ISuite suite : suites) {
			String name = suite.getName();
			System.out.println("Suite Name "+name);
			Map<String, ISuiteResult> map = suite.getResults();
			for(Map.Entry<String, ISuiteResult> m : map.entrySet()) {
				ISuiteResult result = m.getValue();
				ITestContext test = result.getTestContext();
				Set<ITestResult> set = test.getPassedTests().getAllResults();
				/*for(ITestResult r : set) {
					
				}*/
				msg+="Pass Result "+test.getPassedTests().size()+"\n";
				msg+="Fail Result "+test.getFailedTests().size()+"\n";
				msg+="Skip Result "+test.getSkippedTests().size()+"\n";
				
				//System.out.println("Pass Result "+test.getPassedTests().size());
				//System.out.println("Fail Result "+test.getFailedTests().size());
				//System.out.println("Skip Result "+test.getSkippedTests().size());
				
			}
		}
		boolean result = false;
		try {
			result = PDFReader.writePDF(msg);
			if(result) {
				System.out.println("PDF Write");
				boolean r = MailSender.sendMail(PropertyReader.getValue(Constants.PDF_REPORT_KEY));
				System.out.println(r?"Mail Send":"Mail Not Send");
			}
			//String o = result?"PDF Write ":"Not Write";
			//System.out.println(o);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% TESTNG CUSTOM REPORT ENDS%%%%%%%%%%%%%%%%%%%");
	}

}
