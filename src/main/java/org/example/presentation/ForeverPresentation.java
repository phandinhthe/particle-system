package org.example.presentation;

import org.example.dto.AsciiImageCollection;

import java.util.concurrent.TimeUnit;

public class ForeverPresentation implements Presentation {
	private final long timeoutAnimation;
	private final TimeUnit timeUnit;
	private final AsciiImageCollection images;

	public ForeverPresentation(AsciiImageCollection images, long timeoutAnimation, TimeUnit timeUnit) {
		this.images = images;
		this.timeoutAnimation = timeoutAnimation;
		this.timeUnit = timeUnit;
	}

	private void clearConsole() {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("clear").inheritIO().start().waitFor(timeoutAnimation, timeUnit);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void present() {
		try {
			int index = 0;
			int size = images.size();
			while (true) {
				System.out.println(images.get(index).getContent());
				timeUnit.sleep(timeoutAnimation);
				clearConsole();
				index = (index + 1) % size;
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

	}
}
