package org.example.dto;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

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

	public AsciiImageCollection add(int index, URI uri) throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(uri.getPath());
		String content = new String(inputStream.readAllBytes());
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
