package org.istic.edu.text.editor.memento;

import org.istic.edu.text.editor.receiver.ClipBoard;
import org.istic.edu.text.editor.receiver.EditorBuffer;
import org.istic.edu.text.editor.receiver.Selection;


public class EditorMemento implements Memento {

	private EditorBuffer buffer;
	private ClipBoard clipboard;
	private Selection selection;
	private int cursor;
	
	@Override
	public EditorBuffer getBuffer() {
		return buffer;
	}

	@Override
	public void setBuffer(EditorBuffer buffer) {
		this.buffer=buffer;
		
	}

	@Override
	public ClipBoard getClipboard() {
		return clipboard;
	}

	@Override
	public void setClipboard(ClipBoard clipboard) {
		this.clipboard= clipboard;
		
	}

	@Override
	public Selection getSelection() {
		return selection;
	}

	@Override
	public void setSelection(Selection selection) {
		this.selection=selection;
		
	}

	@Override
	public int getCursor() {
		return cursor;
	}

	@Override
	public void setCursor(int cursor) {
		this.cursor=cursor;
		
	}
	

}
