package org.istic.edu.text.editor.memento;

import org.istic.edu.text.editor.receiver.ClipBoard;
import org.istic.edu.text.editor.receiver.EditorBuffer;
import org.istic.edu.text.editor.receiver.Selection;


// TODO: Auto-generated Javadoc
/**
 * The Class EditorMemento.
 */
public class EditorMemento implements Memento {

	/** The buffer. */
	private EditorBuffer buffer;
	
	/** The clipboard. */
	private ClipBoard clipboard;
	
	/** The selection. */
	private Selection selection;
	
	/** The cursor. */
	private int cursor;
	
	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#getBuffer()
	 */
	@Override
	public EditorBuffer getBuffer() {
		return buffer;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#setBuffer(org.istic.edu.text.editor.receiver.EditorBuffer)
	 */
	@Override
	public void setBuffer(EditorBuffer buffer) {
		this.buffer=buffer;
		
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#getClipboard()
	 */
	@Override
	public ClipBoard getClipboard() {
		return clipboard;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#setClipboard(org.istic.edu.text.editor.receiver.ClipBoard)
	 */
	@Override
	public void setClipboard(ClipBoard clipboard) {
		this.clipboard= clipboard;
		
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#getSelection()
	 */
	@Override
	public Selection getSelection() {
		return selection;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#setSelection(org.istic.edu.text.editor.receiver.Selection)
	 */
	@Override
	public void setSelection(Selection selection) {
		this.selection=selection;
		
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#getCursor()
	 */
	@Override
	public int getCursor() {
		return cursor;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.memento.Memento#setCursor(int)
	 */
	@Override
	public void setCursor(int cursor) {
		this.cursor=cursor;
		
	}
	

}
