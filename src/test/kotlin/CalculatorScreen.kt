import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class CalculatorScreen(private val driver: WebDriver) {
    private val locators = Locators()
    private val wait = WebDriverWait(driver, 30)

    fun isCMICalculatorButtonVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.startButton)).isDisplayed
    }

    fun clickCMICalculationButton() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.startButton))
        button.click()
    }

    fun isResetButtonVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.resetButton)).isDisplayed
    }

    fun isLoanAmountLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.loanAmountLabel)).isDisplayed
    }

    fun isInterestLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.interestLabel)).isDisplayed
    }

    fun isPeriodLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.periodLabel)).isDisplayed
    }

    fun isEMILabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.emiLabel)).isDisplayed
    }

    fun isProcessingFeeLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.processingFeeLabel)).isDisplayed
    }
}
