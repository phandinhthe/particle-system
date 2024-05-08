package org.example.presentation;

import org.example.dto.AsciiImageCollection;

import java.util.concurrent.TimeUnit;

public class DefaultPresentation extends ForeverPresentation {
	public DefaultPresentation(AsciiImageCollection images) {
		super(images, 800L, TimeUnit.MILLISECONDS);
	}
}
