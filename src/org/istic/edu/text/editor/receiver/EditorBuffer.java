package org.istic.edu.text.editor.receiver;

public class EditorBuffer {
	private StringBuffer buffer;
	private int cursor;

	public EditorBuffer() {
		this.buffer = new StringBuffer();
		this.cursor = 0;
	}

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		if (cursor < 0 || cursor > buffer.length())
			throw new IllegalArgumentException("Invalid value for cursor");
		this.cursor = cursor;
	}

	public String cut(Selection selection) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");
		
		String text="";
		if (buffer.length() > 0 ) {
			text=buffer.substring(selection.getStart(), selection.getStop());
			buffer=buffer.delete(selection.getStart(), selection.getStop());
			cursor = selection.getStart() + 1;
		}
		return text;
	}

	public void replace(Selection selection, ClipBoard board) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");
		
		buffer = buffer.replace(selection.getStart(), selection.getStop(), board.getClipboard());
		cursor = selection.getStart() + board.getClipboard().length();
	}

	public void insert(String data) {
		if (cursor< 0 || cursor > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");
		
		buffer.insert(cursor, data);
		cursor = cursor + data.length();
	}
	
	public void delete(Selection selection) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");
		
		if (selection.getStop() - selection.getStart() > 0 ) {
			buffer = buffer.replace(selection.getStart(), selection.getStop(),"");
			cursor = selection.getStart();
		}
	}

	public void paste(Selection selection, ClipBoard board) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");
		
		if (selection.getStop() - selection.getStart() > 0 ) {
			replace(selection, board);
		} else {
			buffer.insert(selection.getStart(), board.getClipboard());
			cursor = selection.getStart() + board.getClipboard().length();
		}
	}

	public String getSelectedData(Selection selection) {
		if (selection.getStart() < 0 || selection.getStop() < 0 || selection.getStart() > buffer.length()
				|| selection.getStop() > buffer.length())
			throw new IllegalArgumentException("Invalid start or stop value");

		return buffer.substring(selection.getStart(), selection.getStop());
	}
}
