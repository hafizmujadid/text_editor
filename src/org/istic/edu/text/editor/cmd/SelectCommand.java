package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.EditorEngine;
import org.istic.edu.text.editor.receiver.Selection;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectCommand.
 */
public class SelectCommand implements Command {

	/** The engine. */
	private EditorEngine engine;
	
	/** The selection. */
	private Selection selection;

	/**
	 * Instantiates a new select command.
	 *
	 * @param engine the engine
	 * @param selection the selection
	 */
	public SelectCommand(EditorEngine engine, Selection selection) {
		this.engine = engine;
		this.selection = selection;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.cmd.Command#execute()
	 */
	@Override
	public void execute() throws IllegalArgumentException {
		try {
			engine.editorSelect(selection.getStart(), selection.getStop());
		} catch (IllegalArgumentException ex) {
			throw ex;
		}
	}
}
