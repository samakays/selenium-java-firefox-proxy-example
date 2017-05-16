package com.samakays.examples;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Part of seleniumjavafirefoxproxyexample
 * Created by samakays on 16/05/2017.
 */
public class FirefoxProxyExample {
    public static void main(String[] args) {
        String PROXY = "localhost:3000";
        Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.MANUAL)
                .setHttpProxy(PROXY)
                .setSslProxy(PROXY);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
        desiredCapabilities.setCapability(FirefoxDriver.MARIONETTE, false);

        FirefoxDriverManager.getInstance().forceCache().setup();
        WebDriver driver = new FirefoxDriver(desiredCapabilities);
        driver.get("http://www.google.com");
        driver.quit();
    }
}
