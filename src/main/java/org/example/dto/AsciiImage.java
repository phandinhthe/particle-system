package org.example.dto;

public class AsciiImage {
	int index;
	String content;

	public AsciiImage(int index, String content) {
		this.index = index;
		this.content = content;
	}

	public int index() {
		return index;
	}

	public String getContent() {
		return content;
	}

}
