package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertCommand.
 */
public class InsertCommand implements UndoRedoAbleCommand {
	
	/** The engine. */
	private EditorEngine engine;
	
	/** The substring. */
	private String substring;

	/**
	 * Instantiates a new insert command.
	 *
	 * @param engine the engine
	 * @param substring the substring
	 */
	public InsertCommand(EditorEngine engine, String substring) {
		this.engine = engine;
		this.substring=substring;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.cmd.Command#execute()
	 */
	@Override
	public void execute() {
		engine.editorInsert(substring);
	}
}
