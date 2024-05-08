package org.example.presentation;

import org.example.dto.AsciiImageCollection;

import java.util.concurrent.TimeUnit;

public interface Presentation {
	void present(AsciiImageCollection collection, long animationTimeout, TimeUnit timeUnit);

	default void present(AsciiImageCollection collection) {
		present(collection, 1000L, TimeUnit.MILLISECONDS);
	}
}
