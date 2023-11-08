package org.example

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class SecondTest {

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
    fun openFacebook() {
        val url = "https://www.facebook.com"
        driver!!.get(url)

        val emailInput = "#email"
        val emailBy = By.cssSelector(emailInput)
        val emailElement: WebElement = driver!!.findElement(emailBy)
        emailElement.sendKeys("Denys")
        Assert.assertTrue(emailElement.isDisplayed, "Element was not displayed")

        val mainText = "._8eso"
        val mainTextBy = By.cssSelector(mainText)
        println(driver!!.findElement(mainTextBy).text)
    }
}