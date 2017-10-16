package org.istic.edu.text.editor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.istic.edu.text.editor.v1.EditorEngine;
import org.istic.edu.text.editor.v1.EditorEngineStub;
import org.junit.Before;
import org.junit.Test;

public class EditorEngineTest {
	private EditorEngine edit;

	@Before
	public void setUp() throws Exception {
		edit = new EditorEngineStub();
	}

	@Test
	public void testEditorInsert() {
		invariant(edit);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEditorSelectNegative() {
		edit.editorSelect(-1, 0);
	}

	public void testEditorSelectPositive() {
		assertTrue("Buffer should be empty", edit.getBuffer().isEmpty());
		String myString = "Hello everybody123456";
		edit.editorInsert(myString);
		assertEquals("Buffer should be equal to inserted text", myString, edit.getBuffer());
		edit.editorSelect(15, 21);
		assertEquals("Selection should be 123456", "123456", edit.getSelection());
	}

	@Test
	public void testEditorCopy() {
		assertTrue("Buffer should be empty", edit.getBuffer().isEmpty());
		String myString = "Hello everybody123456";
		edit.editorInsert(myString);
		assertEquals("Buffer should be equal to inserted text", myString, edit.getBuffer());
		edit.editorSelect(15, 21);
		edit.editorCopy();
		assertEquals("Clipboard should have 6 characters", 6, edit.getClipboard().length());
		edit.editorSelect(1, 5);
		edit.editorPaste();
		assertEquals("Buffer should be equal to H123456 everybody123456", "H123456 everybody123456",
				edit.getBuffer().toString());
	}

	@Test
	public void testEditorCut() {
		assertTrue("Buffer should be empty", edit.getBuffer().isEmpty());
		String myString = "Hello everybody123456";
		edit.editorInsert(myString);
		assertEquals("Buffer should be equal to inserted text", myString, edit.getBuffer());
		edit.editorSelect(15, 21);
		edit.editorCut();
		assertEquals("Clipboard should have 6 characters", 6, edit.getClipboard().length());
		edit.editorSelect(1, 5);
		edit.editorPaste();
		assertEquals("Buffer should be equal to H123456 everybody", "H123456 everybody", edit.getBuffer().toString());
	}

	@Test
	public void testEditorPaste() {
		assertTrue("Buffer should be empty", edit.getBuffer().isEmpty());
		String myString = "Hello everybody123456";
		int mySize = myString.length();
		edit.editorInsert(myString);
		assertEquals("Buffer should be equal to inserted text", myString, edit.getBuffer());
		edit.editorSelect(15, 21);
		edit.editorCut();
		mySize = mySize - 6;
		assertEquals("Buffer should lose 6 characters", mySize, edit.getBuffer().length());
		edit.editorSelect(1, 5);
		edit.editorPaste();
		mySize = mySize - 4 + 6;
		assertEquals("Buffer size should increase", mySize, edit.getBuffer().length());
	}

	private void invariant(EditorEngine edit) {
		assertTrue("Selection not bigger than buffer", edit.getSelection().length() <= edit.getBuffer().length());
	}

}
