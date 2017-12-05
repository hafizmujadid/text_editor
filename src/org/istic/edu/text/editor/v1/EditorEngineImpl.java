package org.istic.edu.text.editor.v1;

/**
 * The Class EditorEngineStub.
 * @author mujadid
 */
public class EditorEngineImpl implements EditorEngine {

	/**  The buffer the instance of EditorBuffer class. */
	private EditorBuffer buffer;
	
	/**  The clipboard,The instance of ClipBoard class. */
	private ClipBoard clipboard;
	
	/** The selection. */
	private Selection selection;

	/**
	 * Instantiates a new editor engine stub.
	 */
	public EditorEngineImpl() {
		super();
		buffer = new EditorBuffer();
		selection = new Selection();
		clipboard = new ClipBoard();
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#getBuffer()
	 */
	@Override
	public String getBuffer() {
		return buffer.getBuffer().toString();
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#getSelection()
	 */
	@Override
	public String getSelection() {
		return buffer.getSelectedData(selection);
	}


	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#getClipboard()
	 */
	@Override
	public String getClipboard() {
		return clipboard.getClipboard().toString();
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#editorInsert(java.lang.String)
	 */
	@Override
	public void editorInsert(String substring) {
		buffer.insert(substring);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#editorSelect(int, int)
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
	 * @see org.istic.edu.text.editor.v1.EditorEngine#editorCopy()
	 */
	@Override
	public void editorCopy() {
		String text = buffer.getSelectedData(selection);
		clipboard.setClipboard(text);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#editorCut()
	 */
	@Override
	public void editorCut() {
		String text = buffer.cut(selection);
		if (selection.getStart() != selection.getStop())
			clipboard.setClipboard(text);
		editorSelect(selection.getStart(),selection.getStart());
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#editorPaste()
	 */
	@Override
	public void editorPaste() {
		buffer.paste(selection, clipboard);
	}

	/* (non-Javadoc)
	 * @see org.istic.edu.text.editor.v1.EditorEngine#editorDelete()
	 */
	@Override
	public void editorDelete() {
		buffer.delete(selection);
	}
}
