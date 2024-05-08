package org.example.presentation;

import org.example.dto.AsciiImageCollection;

import java.util.concurrent.TimeUnit;

public class ForeverPresentation implements Presentation {
	private void clearConsole(long animationTimeout, TimeUnit timeUnit) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("clear").inheritIO().start().waitFor(animationTimeout, timeUnit);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	public void present(AsciiImageCollection images, long timeoutAnimation, TimeUnit timeUnit) {
		try {
			int index = 0;
			int size = images.size();
			while (true) {
				System.out.println(images.get(index).getContent());
				timeUnit.sleep(timeoutAnimation);
				clearConsole(timeoutAnimation, timeUnit);
				index = (index + 1) % size;
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

	}
}
