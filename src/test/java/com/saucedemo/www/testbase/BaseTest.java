package com.saucedemo.www.testbase;

import com.saucedemo.www.propertyreader.PropertyReader;
import com.saucedemo.www.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @Parameters("chrome")
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeBrowser();
    }
}
