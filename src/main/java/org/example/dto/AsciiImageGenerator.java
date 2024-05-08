package org.example.dto;

public class AsciiImageGenerator {
	private int index;
	private String content;

	private AsciiImageGenerator() {
	}

	public static AsciiImageGenerator builder() {
		return new AsciiImageGenerator();
	}

	public AsciiImageGenerator index(int index) {
		this.index = index;
		return this;
	}

	public AsciiImageGenerator content(String content) {
		this.content = content;
		return this;
	}

	public AsciiImage build() {
		return new AsciiImage(index, content);
	}
}
