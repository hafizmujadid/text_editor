package org.istic.edu.text.editor.receiver;

import org.istic.edu.text.editor.memento.EditorMemento;


public interface EditorEngine
{
	public String getBuffer();
	public String getSelection();
	public String getClipboard();
	public void editorInsert(String substring);
	public void editorSelect(int start, int stop);
	public void editorCopy();
	public void editorCut();
	public void editorDelete();
	public void editorPaste();
	public int getCaret();
	public void setCaret(int caret);
	public void setBuffer(String text);
	public Selection getSelectionIndices();
	public void setState(EditorMemento memento);
	public EditorMemento getState();
}
