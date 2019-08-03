package org.istic.edu.text.editor.receiver;

/**
 * The Class EditorBuffer.
 * @author Mujadid Khalid
 * @version 3
 */
public class EditorBuffer {
	
	/** The buffer to store contents */
	private StringBuffer buffer;
	
	/** The cursor to mark the current caret position */
	private int cursor;

	/**
	 * Instantiates a new editor buffer, default constructor
	 */
	public EditorBuffer() {
		this.buffer = new StringBuffer();
		this.cursor = 0;
	}

	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	public StringBuffer getBuffer() {
		return buffer;
	}

	/**
	 * Sets the buffer.
	 *
	 * @param buffer the new buffer
	 */
	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	/**
	 * Gets the cursor.
	 *
	 * @return the cursor
	 */
	public int getCursor() {
		return cursor;
	}

	/**
	 * Sets the cursor.
	 *
	 * @param cursor the new cursor
	 * @throws IllegalArgumentException if the cursor is invalid
	 */
	public void setCursor(int cursor) {
		if (cursor < 0 || cursor > buffer.length())
			throw new IllegalArgumentException("Invalid value for cursor");
		this.cursor = cursor;
	}

	/**
	 * Cut.
	 *
	 * @param selection the selection
	 * @throws IllegalArgumentException if the cursor is invalid
	 * @return the string
	 */
	public String cut(Selection selection) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		String text = "";
		if (buffer.length() > 0) {
			text = buffer.substring(selection.getStart(), selection.getStop());
			buffer = buffer.delete(selection.getStart(), selection.getStop());
			cursor = selection.getStart();
		}
		return text;
	}

	/**
	 * Replace.
	 *
	 * @param selection the selection
	 * @param board the board
	 * @throws IllegalArgumentException if the selection is invalid
	 */
	public void replace(Selection selection, ClipBoard board) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		buffer = buffer.replace(selection.getStart(), selection.getStop(), board.getClipboard());
		cursor = selection.getStart() + board.getClipboard().length();
		selection.setStart(cursor);
		selection.setStop(cursor);
	}

	/**
	 * Insert.
	 *
	 * @param data the data
	 * @throws IllegalArgumentException if the cursor is invalid
	 */
	public void insert(String data) {
		if (cursor < 0 || cursor > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		buffer.insert(cursor, data);
		cursor = cursor + data.length();
	}

	/**
	 * Delete.
	 *
	 * @param selection the selection
	 * @throws IllegalArgumentException if the selection is invalid
	 */
	public void delete(Selection selection) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		if (selection.getStop() - selection.getStart() > 0) {
			buffer = buffer.replace(selection.getStart(), selection.getStop(), "");
			cursor = selection.getStart();
			selection.setStart(cursor);
			selection.setStop(cursor);
		}
	}

	/**
	 * Paste.
	 *
	 * @param selection the selection
	 * @param board the clip board
	 * @throws IllegalArgumentException if the selection is invalid
	 */
	public void paste(Selection selection, ClipBoard board) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		if (selection.getStop() - selection.getStart() > 0) {
			replace(selection, board);
		} else {
			buffer.insert(selection.getStart(), board.getClipboard());
			cursor = selection.getStart() + board.getClipboard().length();
			selection.setStart(cursor);
			selection.setStop(cursor);
		}
	}

	/**
	 * Gets the selected data.
	 *
	 * @param selection the selection
	 * @throws IllegalArgumentException if the selection is invalid
	 * @return the selected data
	 */
	public String getSelectedData(Selection selection) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		return buffer.substring(selection.getStart(), selection.getStop());
	}
}
