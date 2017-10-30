package org.istic.edu.text.editor.receiver;

import org.istic.edu.text.editor.memento.EditorMemento;


public class EditorEngineImpl implements EditorEngine {

	private EditorBuffer buffer;
	private ClipBoard clipboard;
	private Selection selection;

	public EditorEngineImpl() {
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
	public void setCaret(int caret) {
		buffer.setCursor(caret);
	}

	@Override
	public void setBuffer(String text) {
		buffer.setBuffer(new StringBuffer(text));
	}

	@Override
	public int getCaret() {
		return buffer.getCursor();
	}

	@Override
	public Selection getSelectionIndices() {
		return selection;
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
		selection.setStart(buffer.getCursor());
		selection.setStop(buffer.getCursor());
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
	
	public void setState(EditorMemento memento) {
		this.buffer.setBuffer(memento.getBuffer().getBuffer());
		this.clipboard.setClipboard(memento.getClipboard().getClipboard());
		this.selection.setStart(memento.getSelection().getStart());
		this.selection.setStop(memento.getSelection().getStop());
	}


	public EditorMemento getState() {
		EditorMemento memento = new EditorMemento();
		EditorBuffer copyBuffer = new EditorBuffer();
		copyBuffer.setBuffer(new StringBuffer(this.buffer.getBuffer().toString()));
		ClipBoard copyClipboard = new ClipBoard(); 
		copyClipboard.setClipboard(this.clipboard.getClipboard());
		memento.setBuffer(copyBuffer);
		memento.setClipboard(copyClipboard);
		memento.setCursor(getCaret());
		Selection copySelection= new Selection();
		copySelection.setStart(this.selection.getStart());
		copySelection.setStop(this.selection.getStop());
		memento.setSelection(copySelection);
		return memento;
	}
}
