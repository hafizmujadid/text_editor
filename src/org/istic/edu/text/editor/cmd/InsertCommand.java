package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;

public class InsertCommand implements UndoRedoAbleCommand {
	private EditorEngine engine;
	private String substring;
	private String previous;
	private int caret;
	private int start;
	private int stop;
	public InsertCommand(EditorEngine engine, String substring) {
		this.engine = engine;
		this.substring=substring;
		Selection selection= engine.getSelectionIndices();
		this.start=selection.getStart();
		this.stop=selection.getStop();
		previous=engine.getBuffer();
		caret=engine.getCaret();
	}
	@Override
	public void execute() {
		engine.editorInsert(substring);
	}
	@Override
	public void undo() {
		engine.setBuffer(previous);
		engine.setCaret(caret);
		engine.editorSelect(start, stop);
		
	}
	@Override
	public void redo() {
		engine.editorInsert(substring);
	}
}
