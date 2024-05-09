package org.example;

import org.example.dto.AsciiImageCollection;
import org.example.presentation.ForeverCoffeePresentation;
import org.example.presentation.Presentation;

import java.io.IOException;
import java.net.URI;

/**
 * Particle system.
 */
public class App {
	public static void main(String[] args) {
		try {
			AsciiImageCollection collection = new AsciiImageCollection();
			collection.add(0, URI.create("/images/coffee/coffee0.txt"));
			Presentation presentation = new ForeverCoffeePresentation();
			presentation.present(collection);

		} catch (IOException | RuntimeException exception) {
			exception.printStackTrace();
		}
	}
}
