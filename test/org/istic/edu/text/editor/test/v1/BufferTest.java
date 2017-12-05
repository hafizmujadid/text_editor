/**
 * 
 */
package org.istic.edu.text.editor.test.v1;

import static org.junit.Assert.*;

import org.istic.edu.text.editor.v1.ClipBoard;
import org.istic.edu.text.editor.v1.EditorBuffer;
import org.istic.edu.text.editor.v1.Selection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author mujadid
 *
 */
public class BufferTest{

	EditorBuffer buffer;
	Selection selection;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		buffer=new EditorBuffer();
		selection= new Selection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		buffer=null;
	}

	@Test
	public void empty() {
		assertEquals(0,buffer.getBuffer().length());
	}
	@Test(expected = IllegalArgumentException.class)
	public void cursorTest() {
		buffer.insert("hello");
		assertEquals(5,buffer.getCursor());
		buffer.setCursor(3);
		assertEquals(3,buffer.getCursor());
		buffer.setCursor(10);
	}
	@Test
	public void insert() {
		buffer.insert("hello");
		assertEquals("hello",buffer.getBuffer().toString());
	}
	@Test
	public void cursorAfterInsertTest() {
		buffer.insert("hello");
		assertEquals(5,buffer.getCursor());
	}
	@Test
	public void selectDataTest() {
		buffer.insert("hello");
		selection.setStart(1);
		selection.setStop(4);
		assertEquals("ell",buffer.getSelectedData(selection));
	}

	@Test
	public void setBufferTest() {
		StringBuffer bf= new StringBuffer();
		bf.append("abcd");
		buffer.setBuffer(bf);
		assertEquals("abcd",buffer.getBuffer().toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cutInvalidSelectTest() {
		Selection select= new Selection(1,11);
		buffer.cut(select);
	}
	@Test(expected = IllegalArgumentException.class)
	public void deleteInvalidSelectTest() {
		Selection select= new Selection(1,11);
		buffer.delete(select);
	}
	@Test(expected = IllegalArgumentException.class)
	public void pasteInvalidSelectTest() {
		ClipBoard board= new ClipBoard();
		Selection select= new Selection(-1,11);
		buffer.paste(select, board);
	}
	@Test
	public void pasteAsInsertTest() {
		ClipBoard board= new ClipBoard();
		board.setClipboard("abcd");
		Selection select= new Selection(5,5);
		buffer.insert("hello");
		buffer.paste(select, board);
		assertEquals("helloabcd",buffer.getBuffer().toString());
	}
}
