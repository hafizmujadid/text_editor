package org.istic.edu.text.editor.v1;

// TODO: Auto-generated Javadoc
/**
 * The Class Selection.
 */
public class Selection {
	
	/** The start. */
	private int start;
	
	/** The stop. */
	private int stop;
	
	/**
	 * Instantiates a new selection.
	 */
	public Selection() {
		super();
		this.start=0;
		this.stop=0;
	}
	
	/**
	 * Instantiates a new selection.
	 *
	 * @param start the start
	 * @param end the end
	 */
	public Selection(int start, int end) {
		super();
		this.start = start;
		this.stop = end;
	}
	
	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	
	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	public void setStart(int start) {
		this.start = start;
	}
	
	/**
	 * Gets the stop.
	 *
	 * @return the stop
	 */
	public int getStop() {
		return stop;
	}
	
	/**
	 * Sets the stop.
	 *
	 * @param end the new stop
	 */
	public void setStop(int end) {
		this.stop = end;
	}
	
	
}
