package com.brainmentors.keyworddriven.keyworddriven.test;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.brainmentors.keyworddriven.keyworddriven.exceptions.KeywordDrivenException;
import com.brainmentors.keyworddriven.keyworddriven.helper.Command;
import com.brainmentors.keyworddriven.keyworddriven.models.CommandDO;
import com.brainmentors.keyworddriven.keyworddriven.utils.CommandConstants;
import com.brainmentors.keyworddriven.keyworddriven.utils.ExcelReader;
import com.brainmentors.keyworddriven.keyworddriven.utils.LogExceptionWriter;
import com.brainmentors.keyworddriven.keyworddriven.utils.Validation;

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
	
	@Test
	public void execute() {
		logger.debug("Inside Execute Function");
		//List<CommandDO> commands = ExcelReader.readCommandsXLS();
		LinkedHashMap<String, List<CommandDO>> map = ExcelReader.readCommandsMultiSheets();
		logger.debug("Fetch the Data from the XLS "+map);
		try {
		if(!(map!=null && map.size()>0)) {
			throw new KeywordDrivenException("No Data in XLS TO READ");
		}
		}
		catch(KeywordDrivenException e) {
			//logger.error(e.getMessage());
			//e.printStackTrace(); // console
			String exec = LogExceptionWriter.writeToLog(e);
			logger.error(exec);
			
		}
		int executionCount = 1;
		for(Map.Entry<String, List<CommandDO>> m : map.entrySet()) {
			System.out.println("Start Testing for "+m.getKey());
		for(CommandDO command : m.getValue()) {
			if(Validation.isEmpty(command.getCommand())) {
				throw new KeywordDrivenException(commandMap.get(executionCount)+" Command is Missing");
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
		System.out.println("End Testing for "+m.getKey());
		commandHelper.close();
		} // sheet end
		
		logger.debug("Execute Ends");
	}
	

}
