package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;


// TODO: Auto-generated Javadoc
/**
 * CutCommand a concrete Command to copy text.
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class CutCommand implements UndoRedoAbleCommand {

	/** The engine. */
	private EditorEngine engine;
	
	/**
	 * Instantiates a new cut command.
	 *
	 * @param engine the engine
	 */
	public CutCommand(EditorEngine engine) {
		this.engine = engine;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.cmd.Command#execute()
	 */
	@Override
	public void execute() {
		engine.editorCut();

	}
}
