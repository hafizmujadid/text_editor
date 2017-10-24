package org.istic.edu.text.editor.invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.istic.edu.text.editor.cmd.Command;
import org.istic.edu.text.editor.cmd.UndoRedoAbleCommand;

public class CommandInvoker {
	private Stack<UndoRedoAbleCommand> undoCommands;
	private Stack<UndoRedoAbleCommand> redoCommands;
	private List<Command> commandsList;
	private Command command;
	private boolean recording;

	public void setCommand(Command command) {
		this.command = command;
		undoCommands = new Stack<UndoRedoAbleCommand>();
		redoCommands = new Stack<UndoRedoAbleCommand>();
		commandsList = new ArrayList<Command>();
		this.recording = false;
		redoCommands.clear();
	}

	public void storeAndExecute() {
		redoCommands.clear(); //clear the redo because new command is issued
		command.execute();

		if (command instanceof UndoRedoAbleCommand) {
			UndoRedoAbleCommand undoredoCommand = (UndoRedoAbleCommand) command;
			undoCommands.push(undoredoCommand);
		}

		if (recording)
			commandsList.add(command);
	}

	public void undo() {
		if (undoCommands.size() <= 0) {
			return;
		}
		undoCommands.peek().undo(); // undo most recently executed command
		redoCommands.push(undoCommands.peek()); // add undone command to undo
												// stack
		undoCommands.pop();
	}

	public void redo() {
		if (redoCommands.size() <= 0) {
			return;
		}

		redoCommands.peek().redo(); // redo most recently executed command
		undoCommands.push(redoCommands.peek()); // add undone command to redo
												// stack
		redoCommands.pop();
	}

	public void playRecording() {
		recording = false;
		for (int i = 0; i < commandsList.size(); i++) {
			this.command = commandsList.get(i);
			storeAndExecute();
		}
	}

	public void startRecording() {
		commandsList.clear();
		recording = true;
	}

	public void stopRecording() {
		recording = false;
	}

}
