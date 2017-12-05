package org.istic.edu.text.editor.invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.istic.edu.text.editor.cmd.Command;
import org.istic.edu.text.editor.cmd.UndoRedoAbleCommand;
import org.istic.edu.text.editor.memento.EditorMemento;
import org.istic.edu.text.editor.receiver.EditorEngine;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandInvoker.
 */
public class CommandInvoker {

	/** The undoables. */
	// list of commands that can be undone
	private Stack<EditorMemento> undoables;

	/** The redoables. */
	// list of commands that can be redone
	private Stack<EditorMemento> redoables;

	/** The current memento. */
	// current memento
	private EditorMemento currentMemento;

	/** The engine. */
	// editor engine
	private EditorEngine engine;

	/** The commands list. */
	// list to keep recording of commands
	private List<Command> commandsList;

	/** The command. */
	// current command to be executed
	private Command command;

	/** The recording. */
	// check if recording is turned on.
	private boolean recording;

	/**
	 * Instantiates a new command invoker.
	 *
	 * @param engine the engine
	 */
	public CommandInvoker(EditorEngine engine) {
		this.engine = engine;
		this.undoables = new Stack<EditorMemento>();
		this.redoables = new Stack<EditorMemento>();
		commandsList = new ArrayList<Command>();
		this.currentMemento = this.engine.getState();
		this.recording = false;
	}

	/**
	 * Sets the command.
	 *
	 * @param command the new command
	 */
	public void setCommand(Command command) {
		this.command = command;
		redoables.clear();
	}

	/**
	 * Store and execute.
	 */
	public void storeAndExecute() {
		redoables.clear(); // clear it because we need not to undo anything now

		// save engine
		saveEngine();
		// execute command
		command.execute();
		if (recording) {
			commandsList.add(command);
		}
	}

	/**
	 * Undo.
	 */
	public void undo() {
		// do we have something to undo?
		if (!this.undoables.isEmpty()) {
			if (this.redoables.isEmpty()) {
				this.redoables.push(this.engine.getState());
			}
			this.engine.setState(this.currentMemento);
			this.redoables.push(this.currentMemento);
			this.currentMemento = this.undoables.pop();
		}
	}

	/**
	 * Redo.
	 */
	public void redo() {
		if (this.redoables.size() > 1) {
			this.undoables.push(this.currentMemento);
			this.currentMemento = this.redoables.pop();
			this.engine.setState(this.redoables.peek());
		}
	}

	/**
	 * Save engine.
	 */
	public void saveEngine() {
		//save state only if it is undoable command
		if (command instanceof UndoRedoAbleCommand) {
			this.undoables.push(this.currentMemento);
			this.currentMemento = this.engine.getState();
		}
		this.redoables.clear();
	}

	/**
	 * Play recording.
	 */
	public void playRecording() {
		recording = false;
		for (int i = 0; i < commandsList.size(); i++) {
			this.command = commandsList.get(i);
			storeAndExecute();
		}
	}

	/**
	 * Start recording.
	 */
	public void startRecording() {
		commandsList.clear();
		recording = true;
	}

	/**
	 * Stop recording.
	 */
	public void stopRecording() {
		recording = false;
	}
}
