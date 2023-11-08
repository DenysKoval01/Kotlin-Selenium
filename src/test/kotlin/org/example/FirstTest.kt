package org.example

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class FirstTest {
    private var driver: WebDriver? = null

    @BeforeTest
    fun createDriver() {
        System.getProperty("webdriver.chrome.driver", "src/main/kotlin/org/example/drivers/chromedriver.exe")

        // : type of obj
        driver = ChromeDriver()
    }

    @AfterTest
    fun tearDownDriver() {
        driver!!.quit()
    }

    @Test
    fun openWebPage() {
        val url = "https://www.google.com/"
        driver!!.get(url)
        Assert.assertEquals(driver!!.currentUrl, url, "WebPage url did not match expected value")
    }
}