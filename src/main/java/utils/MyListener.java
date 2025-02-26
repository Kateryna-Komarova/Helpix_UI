package utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class MyListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("The test have a problem");
        logger.info("***********************************************************************");

        logger.info("Method --> " + method.getName());
        logger.info("***********************************************************************");

        logger.info("Target exception --> " + e.getTargetException());
        logger.info("***********************************************************************");

        logger.info("Object target --> " + target.toString());
        logger.info("***********************************************************************");

        int i = new Random().nextInt(1000) + 1000;
        String link = "screenshots/screen-" + i + ".png";

        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}