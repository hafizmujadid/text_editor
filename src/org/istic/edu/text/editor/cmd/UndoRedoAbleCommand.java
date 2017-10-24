package org.istic.edu.text.editor.cmd;

public interface UndoRedoAbleCommand extends Command{
	public abstract void undo();
    public abstract void redo();
}
