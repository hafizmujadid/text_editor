package org.istic.edu.text.editor.memento;

import org.istic.edu.text.editor.receiver.ClipBoard;
import org.istic.edu.text.editor.receiver.EditorBuffer;
import org.istic.edu.text.editor.receiver.Selection;

public interface Memento {
	
	public EditorBuffer getBuffer();
	public void setBuffer(EditorBuffer buffer);
	public ClipBoard getClipboard();
	public void setClipboard(ClipBoard clipboard);
	public Selection getSelection();
	public void setSelection(Selection selection);
	public int getCursor();
	public void setCursor(int cursor);
}
