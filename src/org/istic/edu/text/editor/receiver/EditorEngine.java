package org.istic.edu.text.editor.receiver;

import org.istic.edu.text.editor.memento.EditorMemento;


// TODO: Auto-generated Javadoc
/**
 * The Interface EditorEngine.
 */
public interface EditorEngine
{
	
	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	public String getBuffer();
	
	/**
	 * Gets the selection.
	 *
	 * @return the selection
	 */
	public String getSelection();
	
	/**
	 * Gets the clipboard.
	 *
	 * @return the clipboard
	 */
	public String getClipboard();
	
	/**
	 * Editor insert.
	 *
	 * @param substring the substring
	 */
	public void editorInsert(String substring);
	
	/**
	 * Editor select.
	 *
	 * @param start the start
	 * @param stop the stop
	 */
	public void editorSelect(int start, int stop);
	
	/**
	 * Editor copy.
	 */
	public void editorCopy();
	
	/**
	 * Editor cut.
	 */
	public void editorCut();
	
	/**
	 * Editor delete.
	 */
	public void editorDelete();
	
	/**
	 * Editor paste.
	 */
	public void editorPaste();
	
	/**
	 * Gets the caret.
	 *
	 * @return the caret
	 */
	public int getCaret();
	
	/**
	 * Sets the caret.
	 *
	 * @param caret the new caret
	 */
	public void setCaret(int caret);
	
	/**
	 * Sets the buffer.
	 *
	 * @param text the new buffer
	 */
	public void setBuffer(String text);
	
	/**
	 * Gets the selection indices.
	 *
	 * @return the selection indices
	 */
	public Selection getSelectionIndices();
	
	/**
	 * Sets the state.
	 *
	 * @param memento the new state
	 */
	public void setState(EditorMemento memento);
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public EditorMemento getState();
}
