package com.brainmentors.frameworks.hybrid.test;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.brainmentors.frameworks.hybrid.exceptions.HybridException;
import com.brainmentors.frameworks.hybrid.helpers.Command;
import com.brainmentors.frameworks.hybrid.models.CommandDO;
import com.brainmentors.frameworks.hybrid.utils.CommandConstants;
import com.brainmentors.frameworks.hybrid.utils.ExcelReader;
import com.brainmentors.frameworks.hybrid.utils.Validation;



public class CommandExecutor implements CommandConstants{
	Logger logger = Logger.getLogger(CommandExecutor.class);
	private Command commandHelper = new Command();
	private HashMap<Integer, String> commandMap = new HashMap<>();
	
	@BeforeClass
	public void init() {
		logger.debug("Init Called And It Load the Browser and Open the URL");
		commandMap.put(1, BROWSER);
		commandMap.put(2, OPEN);
		
		
	}
	
	SoftAssert softAssert = new SoftAssert();
	
	
	@Test
	public void execute() {
		int executionCount = 1;
		// Call Data
		List<Map<String, Object>> dataList = ExcelReader.readDataXLS(1);
		// Call Commands
		List<CommandDO> commands = ExcelReader.readCommandsXLS();
		// Picking Data One After Another
		for(Map<String,Object> map : dataList) {
			// Picking Command One After Another
			for(CommandDO command : commands) {
				if(Validation.isEmpty(command.getCommand())) {
					throw new HybridException(commandMap.get(executionCount)+" Command is Missing");
				}
				if(BROWSER.equalsIgnoreCase(command.getCommand())) {
					if(CONSTANT_VALUE.equalsIgnoreCase(command.getType())) {
					commandHelper.browser(command.getValue());
					}
					else {
						throw new HybridException(BROWSER+"command can not have Variable it is always a constant Type");
					}
				}
				else
				if(OPEN.equalsIgnoreCase(command.getCommand())) {
					if(CONSTANT_VALUE.equalsIgnoreCase(command.getType())) {
					commandHelper.open(command.getValue());
					}
					else {
						throw new HybridException(OPEN+"command can not have Variable it is always a constant Type");
					}
				}
				else
					if(TYPE.equalsIgnoreCase(command.getCommand())) {
						if(CONSTANT_VALUE.equalsIgnoreCase(command.getType())) {
						commandHelper.type(command.getTarget(), command.getValue());
						}
						else {
							String key= command.getValue();
							if(map.get(key)==null) {
								throw new HybridException("Header Name of Data XLS is MisMatch "+command.getTarget()+" "+command.getCommand());
							}
							Object value = map.get(key);
							commandHelper.type(command.getTarget(), value.toString());
						}
					}
					else
						if(CLICK.equalsIgnoreCase(command.getCommand())) {
							commandHelper.click(command.getTarget(), command.getValue());
							
						}
						else
							if(ASSERT_TRUE.equalsIgnoreCase(command.getCommand())) {
								boolean result = false;
								if(CONSTANT_VALUE.equalsIgnoreCase(command.getType())) {
									 result = commandHelper.assertTrue(command.getTarget(),command.getValue());
									}
									else {
										String key= command.getValue();
										if(map.get(key)==null) {
											throw new HybridException("Header Name of Data XLS is MisMatch "+command.getTarget()+" "+command.getCommand());
										}
										Object value = map.get(key);
										 result = commandHelper.assertTrue(command.getTarget(),value.toString());
										
									}
								softAssert.assertTrue(result);
								//assertTrue(result);
							}
			} // Command Loop Ends
			commandHelper.close();
		} // Data Loop Ends
		softAssert.assertAll();
	}

	
	/*@Test
	public void execute() {
		logger.debug("Inside Execute Function");
		List<CommandDO> commands = ExcelReader.readCommandsXLS();
//		
//		
		int executionCount = 1;
//		
		for(CommandDO command : commands) {
			if(Validation.isEmpty(command.getCommand())) {
				throw new HybridException(commandMap.get(executionCount)+" Command is Missing");
			}
			if(BROWSER.equalsIgnoreCase(command.getCommand())) {
				commandHelper.browser(command.getValue());
			}
			else
			if(OPEN.equalsIgnoreCase(command.getCommand())) {
				commandHelper.open(command.getValue());
			}
			else
				if(TYPE.equalsIgnoreCase(command.getCommand())) {
					commandHelper.type(command.getTarget(), command.getValue());
				}
				else
					if(CLICK.equalsIgnoreCase(command.getCommand())) {
						commandHelper.click(command.getTarget(), command.getValue());
					}
					else
						if(ASSERT_TRUE.equalsIgnoreCase(command.getCommand())) {
							boolean result = commandHelper.assertTrue(command.getTarget(),command.getValue());
							assertTrue(result);
						}
			executionCount++;
		} // commands end
		
		
	}
	*/

}
