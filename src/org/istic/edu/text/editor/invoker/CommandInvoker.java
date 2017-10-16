package org.istic.edu.text.editor.invoker;

import java.util.ArrayList;
import java.util.List;
import org.istic.edu.text.editor.cmd.Command;

public class CommandInvoker {
	
	private Command command;
	private List<Command> commands;

	public void setCommand(Command command) {
		this.command = command;
		commands= new ArrayList<Command>();
	}

	public void storeAndExecute() {
		commands.add(command);
		command.execute();
	}
}
