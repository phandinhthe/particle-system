package org.example.dto;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class AsciiImageCollection {
	private final int MAX_SIZE = 1000;
	private List<AsciiImage> images;

	public List<AsciiImage> getImages() {
		return images;
	}

	public AsciiImageCollection() {
		images = new ArrayList<>(MAX_SIZE);
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
		images.add(image.index, image);
		return this;
	}

	public AsciiImage get(int index) {
		return images.get(index);
	}

	public int size() {
		return images.size();
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
