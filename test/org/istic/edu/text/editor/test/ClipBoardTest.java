/**
 * 
 */
package org.istic.edu.text.editor.test;


import static org.junit.Assert.assertEquals;

import org.istic.edu.text.editor.v1.ClipBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mujadid
 *
 */
public class ClipBoardTest {
	ClipBoard board;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		board= new ClipBoard();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		board= null;
	}

	@Test
	public void setData() {
		board.setClipboard("hello");
		assertEquals("clipboard should contain (hello) after inserting hello","hello",board.getClipboard());
	}
	
	@Test
	public void replace() {
		board.setClipboard("hello");
		board.setClipboard("world");
		assertEquals("world",board.getClipboard());
	}
}
