package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;

// TODO: Auto-generated Javadoc
/**
 * CopyCommand a concrete Command to copy text.
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class CopyCommand implements Command {
	
	/** The engine. */
	private EditorEngine engine;

	/**
	 * Instantiates a new copy command.
	 *
	 * @param engine the engine
	 */
	public CopyCommand(EditorEngine engine) {
		this.engine = engine;

	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.cmd.Command#execute()
	 */
	@Override
	public void execute() {
		engine.editorCopy();

	}
}
