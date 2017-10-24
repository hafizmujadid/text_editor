package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;

/**
 * CopyCommand a concrete Command to copy text
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class CopyCommand implements Command {
	private EditorEngine engine;

	public CopyCommand(EditorEngine engine) {
		this.engine = engine;

	}

	@Override
	public void execute() {
		engine.editorCopy();

	}
}
