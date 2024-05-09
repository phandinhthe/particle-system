package org.example.presentation;

import org.example.dto.AsciiImageCollection;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ForeverCoffeePresentation implements Presentation {
	private static final String WHITE = "\033[107m \033[0m";
	private static final String DARK_WHITE = "\033[47m \033[0m";
	private static final String BRIGHT_BLACK = "\033[100m \033[0m";

	private ProcessBuilder processClearConsole() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		try {
			processBuilder = processBuilder.command("clear").inheritIO();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		} finally {
			return processBuilder;
		}
	}

	public void present(AsciiImageCollection images, long animationTimeout, TimeUnit timeUnit) {
		try {
			String content = images.get(0).content();
			ProcessBuilder clearConsoleProcess = processClearConsole();
			while (true) {
				System.out.println(smoke().concat(content));
				timeUnit.sleep(animationTimeout);
				clearConsoleProcess.start().waitFor(animationTimeout, timeUnit);
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	public String smoke() {
		final String INDENT = " ".repeat(78);
		int row = 5;
		int col = 40;
		int spaceCol = 4;

		int boldRow = row - 1;
		int boldColMin = 10;
		int boldColMax = col - boldColMin;
		StringBuilder smoke = new StringBuilder();
		Random random = new Random();
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
