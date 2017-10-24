package org.istic.edu.text.editor.receiver;

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
}
