package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;


/**
 * PasteCommand a concrete Command to copy text
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class PasteCommand implements UndoRedoAbleCommand {
	private EditorEngine engine;
	private String previous;
	private int caret;
	private int start;
	private int stop;
	
	public PasteCommand(EditorEngine engine) {
		previous=engine.getBuffer();
		caret=engine.getCaret();
		Selection selection= engine.getSelectionIndices();
		this.start=selection.getStart();
		this.stop=selection.getStop();
		this.engine = engine;
	}
	@Override
	public void execute() {
		engine.editorPaste();

	}
	@Override
	public void undo() {
		engine.setBuffer(previous);
		engine.setCaret(caret);
		engine.editorSelect(start, stop);
		
	}
	@Override
	public void redo() {
		engine.editorPaste();
	}
}
