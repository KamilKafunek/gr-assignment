import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.math.BigDecimal
import java.math.RoundingMode

class DetailsScreen(private val driver: WebDriver) {
    private val locators = Locators()
    private val wait = WebDriverWait(driver, 30)

    fun clickFirstHistoryCalculation() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.firstCalculation))
        button.click()
    }

    fun isEmiDetailsLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.emiDetailsLabel)).isDisplayed
    }

    fun scrollToElement(month: Int) {
        (driver as AppiumDriver<*>).findElement(
            MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                        "new UiSelector().text(\"$month\"))"))
    }

    fun verifyEmiHistory() {
        val totalMonths = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.periodAmount)).text.toInt()
        val monthlyEmiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.monthlyEmiAmount)).text

        for (month in 1..totalMonths) {
            scrollToElement(month)

            val currentPrincipalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.currentPrincipal(month))).text.toDouble()
            val currentInterestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.currentInterest(month))).text.toDouble()

            val correctAmount = currentPrincipalAmount + currentInterestAmount
            val formattedCorrectAmount = BigDecimal(correctAmount).setScale(1, RoundingMode.HALF_DOWN).toString()

            assertEquals(monthlyEmiAmount, formattedCorrectAmount, "Month: $month -> EMI mismatch: Expected $monthlyEmiAmount, Found $formattedCorrectAmount")
            println("Month: $month -> EMI is correct: $formattedCorrectAmount")
        }
    }
}

