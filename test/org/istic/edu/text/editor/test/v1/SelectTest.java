package org.istic.edu.text.editor.test.v1;

import static org.junit.Assert.*;

import org.istic.edu.text.editor.v1.Selection;
import org.junit.Test;

public class SelectTest {

	Selection selection;

	@Test
	public void selectionWithParameterizedConstructorTest() {
		selection= new Selection(1,4);
		assertEquals("start is 1", 1,selection.getStart());
		assertEquals("stop is 4", 4,selection.getStop());
		assertEquals("start is 1", 1,selection.getStart());
	}
	@Test
	public void selectionWithDefaultConstructorTest() {
		selection= new Selection();
		selection.setStart(1);
		selection.setStop(4);
		assertEquals("start is 1", 1,selection.getStart());
		assertEquals("stop is 4", 4,selection.getStop());
		assertEquals("start is 1", 1,selection.getStart());
	}

}
