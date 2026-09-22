package com.saucedemo.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class ScreenshotUtil {
    private ScreenshotUtil() {}

    public static String captureScreenshot(String name) {
        try {
            File source = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(
                    "test-output/screenshots/" + name + ".png");
            destination.getParentFile().mkdirs();

            Files.copy(source.toPath(), destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            return destination.getAbsolutePath();
        } catch (Exception e) {
            return "";
        }
    }
}
