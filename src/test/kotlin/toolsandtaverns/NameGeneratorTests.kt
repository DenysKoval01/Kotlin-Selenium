package toolsandtaverns

import org.example.pages.NameGeneratorPage
import org.openqa.selenium.ElementNotInteractableException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds


class NameGeneratorTests {

    private var nameGeneratorPage: NameGeneratorPage? = null
    private var driver: WebDriver? = null

    @BeforeTest
    fun setUpDriverAndPages() {
        System.getProperty("webdriver.chrome.driver", "src/main/kotlin/org/example/drivers/chromedriver.exe")

        // : type of obj
        driver = ChromeDriver()
        nameGeneratorPage = NameGeneratorPage(driver!!)
    }

    @Test
    fun generateNameDisplaysText() {
        val expectedCountOfList = 10
        driver!!.get("https://toolsandtaverns.com/nameGenerator")
        val titleText = driver!!.findElement(nameGeneratorPage!!.title).text
        Assert.assertEquals(titleText, "Name Generator", "Title text did not match")

        nameGeneratorPage!!.selectGender("Female")
        nameGeneratorPage!!.selectRace("Elf")
        nameGeneratorPage!!.clickGenerateButton()
        Thread.sleep(4000L)

        val firstListOfNames: List<String> = nameGeneratorPage!!.getGeneratedName()
        Assert.assertEquals(firstListOfNames.size, expectedCountOfList, "Incorrect Number of names generated!")

        nameGeneratorPage!!.clickGenerateButton()
        val secondListOfNames: List<String> = nameGeneratorPage!!.getGeneratedName()
        Assert.assertTrue(secondListOfNames.any { name -> firstListOfNames.contains(name) })

        secondListOfNames.forEach { each -> println(each) }
        secondListOfNames.filter { each -> each.contains("u") }.forEach { find -> println("\n$find") }


    }

    @AfterTest
    fun tearDownDriver() {
        driver!!.quit()
    }
}