import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class CMICalculatorTests : AppiumSetup() {
    private val calculatorScreen = CalculatorScreen(driver)

    @Test
    fun `Check buttons and labels are visible`() {
        calculatorScreen.clickCMICalculationButton()
        assertAll("Check visibility of all elements",
            { assertTrue(calculatorScreen.isResetButtonVisible(), "Reset button should be visible.") },
            { assertTrue(calculatorScreen.isCalculateButtonVisible(), "Calculate button should be visible.") },
            { assertTrue(calculatorScreen.isLoanAmountLabelVisible(), "Loan amount label should be visible.") },
            { assertTrue(calculatorScreen.isInterestLabelVisible(), "Interest label should be visible.") },
            { assertTrue(calculatorScreen.isPeriodLabelVisible(), "Period label should be visible.") },
            { assertTrue(calculatorScreen.isEMILabelVisible(), "EMI label should be visible.") },
            { assertTrue(calculatorScreen.isProcessingFeeLabelVisible(), "Processing Fee label should be visible.") }
        )
    }

    @Test
    fun `Check of values calculation when EMI selected `() {
//        calculatorScreen.clickCMICalculationButton()

        if (calculatorScreen.isEMISelected()) {
            println("The EMI radio button is selected.")
            calculatorScreen.enterLoanAmount("1000")
            calculatorScreen.enterInterestAmount("2")
            calculatorScreen.enterPeriodYearsAmount("2")
            calculatorScreen.enterPeriodMonthsAmount("6")
            calculatorScreen.enterProcessingFeeAmount("10")
        } else {
            fail("The EMI radio button is not selected. Test failed.")
        }

        calculatorScreen.clickCalculateButton()
        assertTrue(calculatorScreen.checkMonthlyEmiResult(), "The monthly EMI amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalInterestResult(), "The total interest amount does not match the expected result.")
        assertTrue(calculatorScreen.checkProcessingFeeResult(), "The processing fee amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalPaymentResult(), "The total payment amount does not match the expected result.")
    }
}