package com.tpddl.appiumtesting.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tpddl.appiumtesting.helpers.Command;
import com.tpddl.appiumtesting.models.CommandDO;
import com.tpddl.appiumtesting.utils.AssertReport;
import com.tpddl.appiumtesting.utils.CommandTypes;
import com.tpddl.appiumtesting.utils.ExcelReader;

public class CommandExecutor implements CommandTypes{
	private String[] breakExpression(String targetExpression) {
		String arr[] = targetExpression.split("=");
		return arr;
	}
	SoftAssert softAssert = new SoftAssert();
	int pass = 0;
	int fail = 0;
	@Test
	public void execute() {
		int testCaseNo = 0;
		try {
			// Read the Data
			List<Map<String,Object>> dataList = ExcelReader.readData(1);
			// Read the Commands
			List<CommandDO> commandList = ExcelReader.readCommands();
			
			// Loop for Reading Data Rows
			for(Map<String,Object> map : dataList) {
				testCaseNo++;
				// Loop for Reading Commands
				for(CommandDO commandDO : commandList) {
					if(OPEN.equals(commandDO.getCommand())) {
						Command.open(commandDO.getValue());
					}
					else
					if(TYPE.equals(commandDO.getCommand())) {
						String target = commandDO.getTarget();
						String expArr [] = breakExpression(target);
						String key = commandDO.getValue();
						Object value = map.get(key);
						Command.typeValue(expArr[0], expArr[1], value.toString());
					}
					else
					if(CLICK.equals(commandDO.getCommand())) {
						String target = commandDO.getTarget();
						String expArr [] = breakExpression(target);
						Command.click(expArr[0], expArr[1]);
					}
					else
					if(ASSERT_TRUE.equals(commandDO.getCommand())) {
						String target = commandDO.getTarget();
						String expArr [] = breakExpression(target);
						String key = commandDO.getValue();
						Object value = map.get(key);
						int result = Command.assertCountTrue(expArr[0], expArr[1], value);
						AssertReport<String> obj = new AssertReport<String>(String.valueOf(testCaseNo), String.valueOf(result), value.toString(),softAssert);
						//boolean result = Command.assertCountTrue(expArr[0], expArr[1], value);
						softAssert.onAssertSuccess(obj);
						String msg = obj.getMessage();
						System.out.println("Message is "+msg);
						
						try {
						//softAssert.assertTrue(String.valueOf(result).equals(value.toString()));
						obj.doAssert();
						}
						catch(AssertionError e) {
							softAssert.onAssertFailure(obj, e);
						}
						
					}
				}
			}
			softAssert.assertAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
