package org.istic.edu.text.editor.receiver;

import org.istic.edu.text.editor.memento.EditorMemento;

/**
 * The Class EditorEngineImpl.
 * @author mujadid
 */
public class EditorEngineImpl implements EditorEngine {

	/**  The buffer, the instance of EditorBuffer class. */
	private EditorBuffer buffer;
	
	/**  The clipboard, the instance of clipboard class. */
	private ClipBoard clipboard;
	
	/** The selection. */
	private Selection selection;

	/**
	 * Instantiates a new editor engine impl.
	 */
	public EditorEngineImpl() {
		super();
		buffer = new EditorBuffer();
		selection = new Selection();
		clipboard = new ClipBoard();
	}

	/**
	 * Sets the clipboard.
	 *
	 * @param clipboard the new clipboard
	 */
	public void setClipboard(ClipBoard clipboard) {
		this.clipboard = clipboard;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#getBuffer()
	 */
	@Override
	public String getBuffer() {
		return buffer.getBuffer().toString();
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#setCaret(int)
	 */
	@Override
	public void setCaret(int caret) {
		buffer.setCursor(caret);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#setBuffer(java.lang.String)
	 */
	@Override
	public void setBuffer(String text) {
		buffer.setBuffer(new StringBuffer(text));
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#getCaret()
	 */
	@Override
	public int getCaret() {
		return buffer.getCursor();
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#getSelectionIndices()
	 */
	@Override
	public Selection getSelectionIndices() {
		return selection;
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#getSelection()
	 */
	@Override
	public String getSelection() {
		return buffer.getSelectedData(selection);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#getClipboard()
	 */
	@Override
	public String getClipboard() {
		return clipboard.getClipboard().toString();
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#editorInsert(java.lang.String)
	 */
	@Override
	public void editorInsert(String substring) {
		buffer.insert(substring);
		selection.setStart(buffer.getCursor());
		selection.setStop(buffer.getCursor());
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#editorSelect(int, int)
	 */
	@Override
	public void editorSelect(int start, int stop) {
		if (start < 0 || stop < 0 || start > buffer.getBuffer().length() || stop > buffer.getBuffer().length())
			throw new IllegalArgumentException("Invalid start or stop value");

		selection.setStart(start);
		selection.setStop(stop);
		buffer.setCursor(start);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#editorCopy()
	 */
	@Override
	public void editorCopy() {
		String text = buffer.getSelectedData(selection);
		clipboard.setClipboard(text);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#editorCut()
	 */
	@Override
	public void editorCut() {
		String text = buffer.cut(selection);
		clipboard.setClipboard(text);
		editorSelect(selection.getStart(),selection.getStart());
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#editorPaste()
	 */
	@Override
	public void editorPaste() {
		buffer.paste(selection, clipboard);
	}

	
	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#editorDelete()
	 */
	@Override
	public void editorDelete() {
		buffer.delete(selection);
	}
	
	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#setState(org.istic.edu.text.editor.memento.EditorMemento)
	 */
	public void setState(EditorMemento memento) {
		this.buffer.setBuffer(memento.getBuffer().getBuffer());
		this.clipboard.setClipboard(memento.getClipboard().getClipboard());
		this.selection.setStart(memento.getSelection().getStart());
		this.selection.setStop(memento.getSelection().getStop());
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.receiver.EditorEngine#getState()
	 */
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
