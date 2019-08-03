package org.istic.edu.text.editor.v1;

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
}
