package com.brainmentors.frameworks.hybrid.test;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	
	@Test
	public void execute() {
		logger.debug("Inside Execute Function");
		List<CommandDO> commands = ExcelReader.readCommandsXLS();
		
		
		int executionCount = 1;
		
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
	

}
