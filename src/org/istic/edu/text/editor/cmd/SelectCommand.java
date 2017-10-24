package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.EditorEngine;
import org.istic.edu.text.editor.receiver.Selection;

public class SelectCommand implements Command {

	private EditorEngine engine;
	private Selection selection;

	public SelectCommand(EditorEngine engine, Selection selection) {
		this.engine = engine;
		this.selection = selection;
	}

	@Override
	public void execute() {
		engine.editorSelect(selection.getStart(), selection.getStop());
	}
}
