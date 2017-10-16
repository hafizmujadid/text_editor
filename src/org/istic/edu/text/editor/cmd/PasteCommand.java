package org.istic.edu.text.editor.cmd;

import org.istic.edu.text.editor.receiver.*;


/**
 * PasteCommand a concrete Command to copy text
 *
 * @author Hafiz Mujadid Khalid
 * @version 1.0
 */
public class PasteCommand implements Command {

	private EditorEngine engine;
	public PasteCommand(EditorEngine engine) {
		this.engine = engine;
	}
	@Override
	public void execute() {
		engine.editorPaste();

	}

}
