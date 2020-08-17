package com.brainmentors.keyworddriven.keyworddriven.test;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.brainmentors.keyworddriven.keyworddriven.exceptions.KeywordDrivenException;
import com.brainmentors.keyworddriven.keyworddriven.helper.Command;
import com.brainmentors.keyworddriven.keyworddriven.models.CommandDO;
import com.brainmentors.keyworddriven.keyworddriven.utils.CommandConstants;
import com.brainmentors.keyworddriven.keyworddriven.utils.ExcelReader;
import com.brainmentors.keyworddriven.keyworddriven.utils.Validation;

public class CommandExecutor implements CommandConstants{
	private Command commandHelper = new Command();
	private HashMap<Integer, String> commandMap = new HashMap<>();
	
	@BeforeClass
	public void init() {
		commandMap.put(1, BROWSER);
		commandMap.put(2, OPEN);
		
		
	}
	
	@Test
	public void execute() {
		List<CommandDO> commands = ExcelReader.readCommandsXLS();
		if(!(commands!=null && commands.size()>0)) {
			throw new KeywordDrivenException("No Data in XLS TO READ");
		}
		int executionCount = 1;
		for(CommandDO command : commands) {
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
		}
	}
	

}
