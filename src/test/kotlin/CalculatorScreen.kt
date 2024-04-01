import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class CalculatorScreen(private val driver: WebDriver) {
    private val locators = Locators()
    private val wait = WebDriverWait(driver, 30)

    fun clickEmiCalculationButton() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.startButton))
        button.click()
    }

    fun clickResetButton() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.resetButton))
        button.click()
    }

    fun selectPeriod() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.periodLabel))
        button.click()
    }

    fun selectInterest() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.interestLabel))
        button.click()
    }
    fun selectAmount() {
        val button = wait.until(ExpectedConditions.elementToBeClickable(locators.loanAmountLabel))
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

    fun isEmiLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.emiLabel)).isDisplayed
    }

    fun isProcessingFeeLabelVisible(): Boolean {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.processingFeeLabel)).isDisplayed
    }

    fun isEmiSelected(): Boolean {
        val emiRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.emiLabel))
        val isChecked = emiRadioButton.getAttribute("checked")
        return "true" == isChecked
    }

    fun isPeriodSelected(): Boolean {
        val periodRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.periodLabel))
        val isChecked = periodRadioButton.getAttribute("checked")
        return "true" == isChecked
    }

    fun isInterestSelected(): Boolean {
        val interestRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.interestLabel))
        val isChecked = interestRadioButton.getAttribute("checked")
        return "true" == isChecked
    }

    fun isAmountSelected(): Boolean {
        val amountRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.loanAmountLabel))
        val isChecked = amountRadioButton.getAttribute("checked")
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

    fun enterEmiAmount(amount: String) {
        val emiFieldById = wait.until(ExpectedConditions.elementToBeClickable(locators.emiField))
        emiFieldById.clear()
        emiFieldById.sendKeys(amount)
        println("Entered EMI amount: $amount")
    }

    fun clickCalculateButton() {
        val calculateButton = wait.until(ExpectedConditions.elementToBeClickable(locators.calculateButton))
        calculateButton.click()
    }

    fun checkMonthlyEmiResult(expectedEmiAmount: String): Boolean {
        val monthlyEmiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.monthlyEmiAmount))
        val correctAmount = monthlyEmiAmount.text
        return expectedEmiAmount == correctAmount
    }

    fun checkTotalInterestResult(expectedTotalInterest: String): Boolean {
        val totalInterestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.totalInterestAmount))
        val correctAmount = totalInterestAmount.text
        return expectedTotalInterest == correctAmount
    }

    fun checkProcessingFeeResult(expectedProcessingFee: String): Boolean {
        val processingFeeAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.processingFeeAmount))
        val correctAmount = processingFeeAmount.text
        return expectedProcessingFee == correctAmount
    }

    fun checkTotalPaymentResult(expectedTotalPayment: String): Boolean {
        val totalPaymentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.totalPaymentAmount))
        val correctAmount = totalPaymentAmount.text
        return expectedTotalPayment == correctAmount
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
