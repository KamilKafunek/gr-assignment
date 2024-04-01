import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class Locators {

    /**
     * EMI Calculator button
     */
    val startButton: By = By.id("com.continuum.emi.calculator:id/btnStart")

    /**
     * Loan amount label
     */
    val loanAmountLabel: By = By.id("com.continuum.emi.calculator:id/rbLoanAmount")

    /**
     * Loan amount field
     */
    val loanAmountField: By = By.id("com.continuum.emi.calculator:id/etLoanAmount")

    /**
     * Interest label
     */
    val interestLabel: By = By.id("com.continuum.emi.calculator:id/rbInterest")

    /**
     * Interest field
     */
    val interestField: By = By.id("com.continuum.emi.calculator:id/etInterest")

    /**
     * Period label
     */
    val periodLabel: By = By.id("com.continuum.emi.calculator:id/rbPeriod")

    /**
     * Period years field
     */
    val periodYearsField: By = By.id("com.continuum.emi.calculator:id/etYears")

    /**
     * Period months field
     */
    val periodMonthsField: By = By.id("com.continuum.emi.calculator:id/etMonths")

    /**
     * EMI label
     */
    val emiLabel: By = By.id("com.continuum.emi.calculator:id/rbEMI")

    /**
     * EMI field
     */
    val emiField: By = By.id("com.continuum.emi.calculator:id/etEMI")

    /**
     * Processing Fee label
     */
    val processingFeeLabel: By = By.xpath("//android.widget.TextView[@text=\"Processing Fee %\"]")

    /**
     * Processing Fee field
     */
    val processingFeeField: By = By.id("com.continuum.emi.calculator:id/etFee")

    /**
     * Reset button
     */
    val resetButton: By = By.id("com.continuum.emi.calculator:id/btnReset")

    /**
     * Calculate button
     */
    val calculateButton: By = By.id("com.continuum.emi.calculator:id/btnCalculate")

    /**
     * Monthly EMI result
     */
    val monthlyEmiAmount: By = By.id("com.continuum.emi.calculator:id/monthly_emi_result")

    /**
     * Total interest result
     */
    val totalInterestAmount: By = By.id("com.continuum.emi.calculator:id/total_interest_result")

    /**
     * Processing fee result
     */
    val processingFeeAmount: By = By.id("com.continuum.emi.calculator:id/processing_fee_result")

    /**
     * Total payment result
     */
    val totalPaymentAmount: By = By.id("com.continuum.emi.calculator:id/total_payment_result")

    /**
     * Navigation drawer
     */
    val navigationDrawer: By = MobileBy.AccessibilityId("Open navigation drawer")

    /**
     * History tab
     */
    val historyTab: By = By.xpath("//android.widget.CheckedTextView[@resource-id=\"com.continuum.emi.calculator:id/design_menu_item_text\" and @text=\"History\"]")

    /**
     * First history calculation
     */
    val firstCalculation: By = By.id("com.continuum.emi.calculator:id/layoutFirst")

    /**
     * Period result
     */
    val periodAmount: By = By.id("com.continuum.emi.calculator:id/period_result")

    /**
     * EMI Details label
     */
    val emiDetailsLabel: By = By.xpath("//android.widget.TextView[@text=\"EMI Details\"]")

    /**
     * Principal amount by month
     */
    fun currentPrincipal(month: Int): By {
        return By.xpath("//android.widget.TextView[@resource-id=\"com.continuum.emi.calculator:id/tvMonths_lv\" and @text=\"$month\"]/following-sibling::android.widget.TextView[1]")
    }

    /**
     * Interest amount by month
     */
    fun currentInterest(month: Int): By {
        return By.xpath("//android.widget.TextView[@resource-id=\"com.continuum.emi.calculator:id/tvMonths_lv\" and @text=\"$month\"]/following-sibling::android.widget.TextView[2]")
    }
}