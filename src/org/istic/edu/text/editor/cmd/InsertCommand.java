package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;

public class InsertCommand implements UndoRedoAbleCommand {
	private EditorEngine engine;
	private String substring;
	private String previous;
	private int caret;
	public InsertCommand(EditorEngine engine, String substring) {
		this.engine = engine;
		this.substring=substring;
	}
	@Override
	public void execute() {
		previous=engine.getBuffer();
		caret=engine.getCaret();
		engine.editorInsert(substring);
	}
	@Override
	public void undo() {
		engine.setBuffer(previous);
		engine.setCaret(caret);
		
	}
	@Override
	public void redo() {
		engine.editorInsert(substring);
	}
}
