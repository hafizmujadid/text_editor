/**
 * 
 */
package org.istic.edu.text.editor.test;

import static org.junit.Assert.*;

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
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void selectDataNegativeTest() {
		buffer.insert("hello");
		selection.setStart(-1);
		selection.setStop(4);
		assertEquals("ell",buffer.getSelectedData(selection));
	}
}
