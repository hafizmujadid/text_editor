package org.istic.edu.text.editor.memento;

import org.istic.edu.text.editor.receiver.ClipBoard;
import org.istic.edu.text.editor.receiver.EditorBuffer;
import org.istic.edu.text.editor.receiver.Selection;

// TODO: Auto-generated Javadoc
/**
 * The Interface Memento.
 */
public interface Memento {
	
	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	public EditorBuffer getBuffer();
	
	/**
	 * Sets the buffer.
	 *
	 * @param buffer the new buffer
	 */
	public void setBuffer(EditorBuffer buffer);
	
	/**
	 * Gets the clipboard.
	 *
	 * @return the clipboard
	 */
	public ClipBoard getClipboard();
	
	/**
	 * Sets the clipboard.
	 *
	 * @param clipboard the new clipboard
	 */
	public void setClipboard(ClipBoard clipboard);
	
	/**
	 * Gets the selection.
	 *
	 * @return the selection
	 */
	public Selection getSelection();
	
	/**
	 * Sets the selection.
	 *
	 * @param selection the new selection
	 */
	public void setSelection(Selection selection);
	
	/**
	 * Gets the cursor.
	 *
	 * @return the cursor
	 */
	public int getCursor();
	
	/**
	 * Sets the cursor.
	 *
	 * @param cursor the new cursor
	 */
	public void setCursor(int cursor);
}
