package org.istic.edu.text.editor.receiver;

// TODO: Auto-generated Javadoc
/**
 * The Class ClipBoard.
 */
public class ClipBoard {
	
	/** The clipboard. */
	private String clipboard;

	/**
	 * Instantiates a new clip board.
	 */
	public ClipBoard() {
		this.clipboard = "";
	}
	
	/**
	 * Instantiates a new clip board.
	 *
	 * @param clipboard the clipboard
	 */
	public ClipBoard(String clipboard) {
		this.clipboard = clipboard;
	}

	/**
	 * Gets the clipboard.
	 *
	 * @return the clipboard
	 */
	public String getClipboard() {
		return clipboard;
	}

	/**
	 * Sets the clipboard.
	 *
	 * @param clipboard the new clipboard
	 */
	public void setClipboard(String clipboard) {
		this.clipboard = clipboard;
	}
	
}
