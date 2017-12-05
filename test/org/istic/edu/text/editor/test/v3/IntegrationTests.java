package org.istic.edu.text.editor.test.v3;

import static org.junit.Assert.*;

import org.istic.edu.text.editor.cmd.CopyCommand;
import org.istic.edu.text.editor.cmd.CutCommand;
import org.istic.edu.text.editor.cmd.DeleteCommand;
import org.istic.edu.text.editor.cmd.InsertCommand;
import org.istic.edu.text.editor.cmd.PasteCommand;
import org.istic.edu.text.editor.cmd.SelectCommand;
import org.istic.edu.text.editor.invoker.CommandInvoker;
import org.istic.edu.text.editor.receiver.EditorEngine;
import org.istic.edu.text.editor.receiver.EditorEngineImpl;
import org.istic.edu.text.editor.receiver.Selection;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTests {

	EditorEngine editorEngine;
	Selection selection;
	CopyCommand copy;
	CutCommand cut;
	PasteCommand paste;
	InsertCommand insert;
	DeleteCommand delete;
	CommandInvoker invoker;
	SelectCommand select;

	@Before
	public void setUp() throws Exception {
		editorEngine = new EditorEngineImpl();
		invoker = new CommandInvoker(editorEngine);
	}

	@Test
	public void insertTest() {
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());
		insertText("this is simple text");
		assertEquals("Buffer should be equal to 'this is simple text'", "this is simple text",
				editorEngine.getBuffer().toString());
		insertText(" few more words");
		assertEquals("Buffer should be equal to 'this is simple text few more words'",
				"this is simple text few more words", editorEngine.getBuffer().toString());
	}

	@Test
	public void selectTest() {
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());
		insertText("this is simple text");
		assertEquals("Buffer should be equal to 'this is simple text'", "this is simple text",
				editorEngine.getBuffer().toString());
		selectText(5, 7);
		assertEquals("Buffer should be equal to 'is'", "is", editorEngine.getSelection());
	}

	@Test(expected = IllegalArgumentException.class)
	public void SelectNegativeTest() {
		selectText(-1, 1);
	}

	@Test
	public void testEditorCopy() {
		// empty test
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());

		// insert
		String myString = "Hello everybody123456";
		insertText(myString);
		assertEquals("Buffer should be equal to inserted text", myString, editorEngine.getBuffer());

		// select
		selectText(15, 21);

		// copy
		copyText();
		assertEquals("Clipboard should have 6 characters", 6, editorEngine.getClipboard().length());

	}

	@Test
	public void testEditorPaste() {
		// empty test
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());

		// insert
		String myString = "Hello everybody123456";
		insertText(myString);
		assertEquals("Buffer should be equal to inserted text", myString, editorEngine.getBuffer());

		// select
		selectText(15, 21);

		// copy
		copyText();
		assertEquals("Clipboard should have 6 characters", 6, editorEngine.getClipboard().length());

		// selection
		selectText(1, 5);

		// paste
		pasteText();
		assertEquals("Buffer should be equal to H123456 everybody123456", "H123456 everybody123456",
				editorEngine.getBuffer().toString());
	}

	@Test
	public void testEditorCut() {
		// empty test
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());

		// insert
		String myString = "Hello everybody123456";
		insertText(myString);
		assertEquals("Buffer should be equal to inserted text", myString, editorEngine.getBuffer());

		// select
		selectText(15, 21);

		// cut
		cutText();
		assertEquals("Clipboard should have 6 characters", 6, editorEngine.getClipboard().length());
		assertEquals("Buffer should be equal to Hello everybody", "Hello everybody",
				editorEngine.getBuffer().toString());
	}

	@Test
	public void recordingTest() {
		// empty test
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());
		
		//turn on recording
		invoker.startRecording();
		insertText("1");
		insertText("2");
		insertText("3");
		insertText("4");
		insertText("5");
		insertText("6");
		selectText(2, 3);
		cutText();
		invoker.stopRecording();
		assertEquals("Buffer should be equal to 12456", "12456",
				editorEngine.getBuffer().toString());
		invoker.playRecording();
		assertEquals("Buffer should be equal to 1223456456", "1223456456",
				editorEngine.getBuffer().toString());
	}

	@Test
	public void testEditorDelete() {
		// empty test
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());

		// insert
		String myString = "Hello everybody123456";
		insertText(myString);
		assertEquals("Buffer should be equal to inserted text", myString, editorEngine.getBuffer());

		// select
		selectText(15, 21);

		// delete
		deleteText();
		assertEquals("Buffer should be equal to Hello everybody", "Hello everybody",
				editorEngine.getBuffer().toString());
	}

	@Test
	public void undoRedoTest() {
		// empty test
		assertTrue("Buffer should be empty", editorEngine.getBuffer().isEmpty());

		// insert
		String myString = "1234";
		insertText(myString);
		assertEquals("Buffer should be equal to 1234", myString, editorEngine.getBuffer());
		insertText("abcd");
		invoker.undo();
		assertEquals("Buffer should be equal to 1234", myString, editorEngine.getBuffer());
		invoker.redo();
		assertEquals("Buffer should be equal to 1234abcd", "1234abcd", editorEngine.getBuffer());
	}

	private void insertText(String text) {
		insert = new InsertCommand(editorEngine, text);
		invoker.setCommand(insert);
		invoker.storeAndExecute();
	}

	private void copyText() {
		copy = new CopyCommand(editorEngine);
		invoker.setCommand(copy);
		invoker.storeAndExecute();
	}

	private void cutText() {
		cut = new CutCommand(editorEngine);
		invoker.setCommand(cut);
		invoker.storeAndExecute();
	}

	private void pasteText() {
		paste = new PasteCommand(editorEngine);
		invoker.setCommand(paste);
		invoker.storeAndExecute();
	}

	private void deleteText() {
		delete = new DeleteCommand(editorEngine);
		invoker.setCommand(delete);
		invoker.storeAndExecute();
	}

	private void selectText(int start, int end) {
		selection = new Selection();
		selection.setStart(start);
		selection.setStop(end);
		select = new SelectCommand(editorEngine, selection);
		invoker.setCommand(select);
		invoker.storeAndExecute();
	}
}
