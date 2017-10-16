package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;


/**
 * CutCommand a concrete Command to copy text
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class CutCommand extends Command {

	private EditorEngine engine;

	public CutCommand(EditorEngine engine) {
		this.engine = engine;
	}

	@Override
	public void execute() {
		engine.editorCut();

	}

}
