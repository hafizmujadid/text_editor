package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;

public class InsertCommand implements UndoRedoAbleCommand {
	private EditorEngine engine;
	private String substring;

	public InsertCommand(EditorEngine engine, String substring) {
		this.engine = engine;
		this.substring=substring;
	}
	@Override
	public void execute() {
		System.out.println("inserting "+substring);
		engine.editorInsert(substring);
	}
}
