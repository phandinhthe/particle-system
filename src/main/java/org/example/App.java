package org.example;

import org.example.dto.AsciiImageCollection;
import org.example.presentation.ForeverPresentation;
import org.example.presentation.Presentation;

import java.io.IOException;
import java.net.URI;

/**
 * Particle system.
 */
public class App {
	public static void main(String[] args) {
		try {
			AsciiImageCollection collection = new AsciiImageCollection(2);
			collection.add(0, URI.create("/images/coffee/coffee0.txt"));
			collection.add(1, URI.create("/images/coffee/coffee1.txt"));

			Presentation presentation = new ForeverPresentation();
			presentation.present(collection);

		} catch (IOException | RuntimeException exception) {
			exception.printStackTrace();
		}
	}
}
