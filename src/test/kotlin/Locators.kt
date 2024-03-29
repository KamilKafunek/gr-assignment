import org.openqa.selenium.By

class Locators {

    /**
     * EMI Calculator button
     */
    val startButton: By = By.id("com.continuum.emi.calculator:id/btnStart")

    val loanAmountLabel: By = By.id("com.continuum.emi.calculator:id/rbLoanAmount")
    val interestLabel: By = By.id("com.continuum.emi.calculator:id/rbInterest")
    val periodLabel: By = By.id("com.continuum.emi.calculator:id/rbPeriod")
    val emiLabel: By = By.id("com.continuum.emi.calculator:id/rbEMI")
    val processingFeeLabel: By = By.xpath("//android.widget.TextView[@text=\"Processing Fee %\"]")
    val resetButton: By = By.id("com.continuum.emi.calculator:id/btnReset")



}