package org.istic.edu.text.editor.invoker;

import org.istic.edu.text.editor.cmd.Command;

public class CommandInvoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}
}
