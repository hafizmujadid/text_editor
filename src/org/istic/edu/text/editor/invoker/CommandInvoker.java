package org.istic.edu.text.editor.invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.istic.edu.text.editor.cmd.Command;
import org.istic.edu.text.editor.cmd.UndoRedoAbleCommand;
import org.istic.edu.text.editor.memento.EditorMemento;
import org.istic.edu.text.editor.receiver.EditorEngine;

public class CommandInvoker {

	// list of commands that can be undone
	private Stack<EditorMemento> undoables;

	// list of commands that can be redone
	private Stack<EditorMemento> redoables;

	// current memento
	private EditorMemento currentMemento;

	// editor engine
	private EditorEngine engine;

	// list to keep recording of commands
	private List<Command> commandsList;

	// current command to be executed
	private Command command;

	// check if recording is turned on.
	private boolean recording;

	public CommandInvoker(EditorEngine engine) {
		this.engine = engine;
		this.undoables = new Stack<EditorMemento>();
		this.redoables = new Stack<EditorMemento>();
		commandsList = new ArrayList<Command>();
		this.currentMemento = this.engine.getState();
		this.recording = false;
	}

	public void setCommand(Command command) {
		this.command = command;
		redoables.clear();
	}

	public void storeAndExecute() {
		redoables.clear(); // clear it because we need not to undo anything now

		// save engine
		saveEngine();
		// execute command
		command.execute();
		if (recording) {
			System.out.println("recorded");
			commandsList.add(command);
		}
	}

	public void undo() {
		// do we have something to undo?
		if (!this.undoables.isEmpty()) {
			System.out.println("undoing ");
			if (this.redoables.isEmpty()) {
				this.redoables.push(this.engine.getState());
			}
			this.engine.setState(this.currentMemento);
			this.redoables.push(this.currentMemento);
			this.currentMemento = this.undoables.pop();
		}
	}

	public void redo() {
		if (this.redoables.size() > 1) {
			this.undoables.push(this.currentMemento);
			this.currentMemento = this.redoables.pop();
			this.engine.setState(this.redoables.peek());
		}
	}

	public void saveEngine() {
		//save state only if it is undoable command
		if (command instanceof UndoRedoAbleCommand) {
			this.undoables.push(this.currentMemento);
			this.currentMemento = this.engine.getState();
		}
		this.redoables.clear();
	}

	public void playRecording() {
		System.out.println("replaying " + commandsList.size() + " commands");
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
