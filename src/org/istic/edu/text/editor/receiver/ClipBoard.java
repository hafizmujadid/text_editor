package org.istic.edu.text.editor.receiver;

public class ClipBoard {
	private String clipboard;

	public ClipBoard() {
		this.clipboard = "";
	}
	
	public ClipBoard(String clipboard) {
		this.clipboard = clipboard;
	}

	public String getClipboard() {
		return clipboard;
	}

	public void setClipboard(String clipboard) {
		this.clipboard = clipboard;
	}
	
}
