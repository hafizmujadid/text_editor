package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;


// TODO: Auto-generated Javadoc
/**
 * PasteCommand a concrete Command to copy text.
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class PasteCommand implements UndoRedoAbleCommand {
	
	/** The engine. */
	private EditorEngine engine;
	
	/**
	 * Instantiates a new paste command.
	 *
	 * @param engine the engine
	 */
	public PasteCommand(EditorEngine engine) {
		this.engine = engine;
	}
	
	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.cmd.Command#execute()
	 */
	@Override
	public void execute() {
		engine.editorPaste();

	}
}
