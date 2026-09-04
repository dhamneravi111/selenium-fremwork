package base;
import org.openqa.selenium.WebDriver;
/** Holds one WebDriver per TestNG thread to enable safe parallel execution. */
public final class DriverManager { private static final ThreadLocal<WebDriver> DRIVER=new ThreadLocal<>(); private DriverManager(){} public static WebDriver getDriver(){ return DRIVER.get(); } public static void setDriver(WebDriver d){ DRIVER.set(d);} public static void quitDriver(){ WebDriver d=DRIVER.get(); if(d!=null){ d.quit(); DRIVER.remove(); }} }
