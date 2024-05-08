package org.example.dto;

public class AsciiImageCollection {
	private AsciiImage[] images;

	public AsciiImage[] getImages() {
		return images;
	}

	public AsciiImageCollection(int size) {
		images = new AsciiImage[size];
	}

	public AsciiImageCollection add(int index, String content) {
		validate(index, content);
		return add(AsciiImageGenerator.builder().index(index).content(content).build());
	}

	private AsciiImageCollection add(AsciiImage image) {
		int index = image.index();
		images[index] = image;
		return this;
	}

	public AsciiImage get(int index) {
		return images[index];
	}

	public int size() {
		return images.length;
	}

	private void validate(int index, String content) {
		if (index < 0) {
			throw new RuntimeException("index must be positive number.");
		}

		if (null == content || content.trim().isEmpty()) {
			throw new RuntimeException("content must be not empty.");
		}
	}
}
