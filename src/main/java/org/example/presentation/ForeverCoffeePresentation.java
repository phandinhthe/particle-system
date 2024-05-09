package org.example.presentation;

import org.example.dto.AsciiImageCollection;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ForeverCoffeePresentation implements Presentation {
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
				System.out.println(smoke().concat(images.get(index).content()));
				timeUnit.sleep(timeoutAnimation);
				clearConsole(timeoutAnimation, timeUnit);
				index = (index + 1) % size;
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	public String smoke() {
		final String INDENT = " ".repeat(78);
		int row = 5;
		int col = 40;
		int spaceCol = 5;

		int boldRow = row - 1;
		int boldColMin = 10;
		int boldColMax = col - boldColMin;
		StringBuilder smoke = new StringBuilder();
		Random random = new Random();
		String WHITE = "\033[107m \033[0m";
		String DARK_WHITE = "\033[47m \033[0m";
		String BRIGHT_BLACK = "\033[100m \033[0m";
		for (int i = 0; i < row; i++) {
				smoke.append(INDENT);
			for (int j = 0; j < col; j++) {
				if (j >= boldColMin && j <= boldColMax && i >= boldRow) {
					smoke.append(WHITE);
					continue;
				}
				int rnd = random.nextInt(col);
				if (j < spaceCol || j >= col - spaceCol)
					smoke.append(" ");
				else if (rnd >= boldColMin - 2 && rnd <= boldColMax - 2)
					smoke.append(BRIGHT_BLACK);
				else if (rnd >= boldColMin && rnd <= boldColMax) smoke.append(DARK_WHITE);
				else smoke.append(" ");
			}
			smoke.append("\n");
			spaceCol -= 1;
		}
		return smoke.toString();
	}
}
