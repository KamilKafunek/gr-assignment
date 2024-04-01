import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
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

    fun isCalculateButtonVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.calculateButton)).isDisplayed
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

    fun isEMISelected(): Boolean {
        val emiRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.emiLabel))
        val isChecked = emiRadioButton.getAttribute("checked")
        return "true" == isChecked
    }

    fun enterLoanAmount(amount: String) {
        val loanAmountFieldById = wait.until(ExpectedConditions.elementToBeClickable(locators.loanAmountField))
        loanAmountFieldById.clear()
        loanAmountFieldById.sendKeys(amount)
        println("Entered loan amount: $amount")
    }

    fun enterInterestAmount(amount: String) {
        val interestFieldById = wait.until(ExpectedConditions.elementToBeClickable(locators.interestField))
        interestFieldById.clear()
        interestFieldById.sendKeys(amount)
        println("Entered interest amount: $amount")
    }

    fun enterPeriodYearsAmount(amount: String) {
        val periodYearsFieldById = wait.until(ExpectedConditions.elementToBeClickable(locators.periodYearsField))
        periodYearsFieldById.clear()
        periodYearsFieldById.sendKeys(amount)
        println("Entered years amount: $amount")
    }

    fun enterPeriodMonthsAmount(amount: String) {
        val periodMonthsFieldById = wait.until(ExpectedConditions.elementToBeClickable(locators.periodMonthsField))
        periodMonthsFieldById.clear()
        periodMonthsFieldById.sendKeys(amount)
        println("Entered months amount: $amount")
    }

    fun enterProcessingFeeAmount(amount: String) {
        val processingFeeFieldById = wait.until(ExpectedConditions.elementToBeClickable(locators.processingFeeField))
        processingFeeFieldById.clear()
        processingFeeFieldById.sendKeys(amount)
        println("Entered processing fee amount: $amount")
    }

    fun clickCalculateButton() {
        val calculateButton = wait.until(ExpectedConditions.elementToBeClickable(locators.calculateButton))
        calculateButton.click()
    }

    fun checkMonthlyEmiResult(): Boolean {
        val monthlyEmiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.monthlyEmiAmount))
        val correctAmount = monthlyEmiAmount.text
        return "34.2" == correctAmount
    }

    fun checkTotalInterestResult(): Boolean {
        val monthlyEmiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.totalInterestAmount))
        val correctAmount = monthlyEmiAmount.text
        return "26.04" == correctAmount
    }

    fun checkProcessingFeeResult(): Boolean {
        val monthlyEmiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.processingFeeAmount))
        val correctAmount = monthlyEmiAmount.text
        return "100" == correctAmount
    }

    fun checkTotalPaymentResult(): Boolean {
        val monthlyEmiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.totalPaymentAmount))
        val correctAmount = monthlyEmiAmount.text
        return "1,026.04" == correctAmount
    }

    fun clickNavigationDrawerButton() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.navigationDrawer))
        button.click()
    }

    fun clickHistoryTabButton() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.historyTab))
        button.click()
    }
}
