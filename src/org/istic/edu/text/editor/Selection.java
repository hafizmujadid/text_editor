package org.istic.edu.text.editor;

public class Selection {
	private int start;
	private int stop;
	
	public Selection() {
		super();
		this.start=0;
		this.stop=0;
	}
	public Selection(int start, int end) {
		super();
		this.start = start;
		this.stop = end;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getStop() {
		return stop;
	}
	public void setStop(int end) {
		this.stop = end;
	}
	@Override
	public String toString() {
		return String.format("(%d,%d)", start, stop);
	}
	
	
}
