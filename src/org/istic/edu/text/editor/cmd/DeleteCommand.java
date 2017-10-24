package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;


/**
 * CopyCommand a concrete Command to copy text
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class DeleteCommand implements UndoRedoAbleCommand {
	private EditorEngine engine;
	private String previous;
	private int caret;
	public DeleteCommand(EditorEngine engine) {
		this.engine = engine;
	}
	@Override
	public void execute() {
		previous=engine.getBuffer();
		caret=engine.getCaret();
		engine.editorDelete();

	}
	@Override
	public void undo() {
		engine.setBuffer(previous);
		engine.setCaret(caret);
	}
	@Override
	public void redo() {
		engine.editorDelete();
		
	}
}
