package org.istic.edu.text.editor.v1;

public class EditorEngineStub implements EditorEngine {

	private EditorBuffer buffer;
	private ClipBoard clipboard;
	private Selection selection;

	public EditorEngineStub() {
		super();
		buffer = new EditorBuffer();
		selection = new Selection();
		clipboard = new ClipBoard();
	}

	public void setClipboard(ClipBoard clipboard) {
		this.clipboard = clipboard;
	}

	@Override
	public String getBuffer() {
		return buffer.getBuffer().toString();
	}

	@Override
	public String getSelection() {
		return buffer.getSelectedData(selection);
	}

	@Override
	public String getClipboard() {
		return clipboard.getClipboard().toString();
	}

	@Override
	public void editorInsert(String substring) {
		buffer.insert(substring);
	}

	@Override
	public void editorSelect(int start, int stop) {
		if (start < 0 || stop < 0 || start > buffer.getBuffer().length() || stop > buffer.getBuffer().length())
			throw new IllegalArgumentException("Invalid start or stop value");

		selection.setStart(start);
		selection.setStop(stop);
		buffer.setCursor(start);
	}

	@Override
	public void editorCopy() {
		String text = buffer.getSelectedData(selection);
		clipboard.setClipboard(text);
	}

	@Override
	public void editorCut() {
		String text = buffer.cut(selection);
		if (selection.getStart() != selection.getStop())
			clipboard.setClipboard(text);
	}

	@Override
	public void editorPaste() {
		buffer.paste(selection, clipboard);
	}

	@Override
	public void editorDelete() {
		buffer.delete(selection);
	}
}
