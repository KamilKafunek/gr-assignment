import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class EmiCalculatorTests : AppiumSetup() {
    private val calculatorScreen = CalculatorScreen(driver)
    private val detailsScreen = DetailsScreen(driver)

    @Test
    @Order(1)
    fun `Check buttons and labels are visible`() {
        calculatorScreen.clickEmiCalculationButton()
        assertAll("Check visibility of all elements",
            { assertTrue(calculatorScreen.isResetButtonVisible(), "Reset button should be visible.") },
            { assertTrue(calculatorScreen.isCalculateButtonVisible(), "Calculate button should be visible.") },
            { assertTrue(calculatorScreen.isLoanAmountLabelVisible(), "Loan amount label should be visible.") },
            { assertTrue(calculatorScreen.isInterestLabelVisible(), "Interest label should be visible.") },
            { assertTrue(calculatorScreen.isPeriodLabelVisible(), "Period label should be visible.") },
            { assertTrue(calculatorScreen.isEmiLabelVisible(), "EMI label should be visible.") },
            { assertTrue(calculatorScreen.isProcessingFeeLabelVisible(), "Processing Fee label should be visible.") }
        )
    }

    @Test
    @Order(2)
    fun `Check of values calculation when EMI is selected `() {
        if (calculatorScreen.isEmiSelected()) {
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
        assertTrue(calculatorScreen.checkMonthlyEmiResult("34.2"), "The monthly EMI amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalInterestResult("26.04"), "The total interest amount does not match the expected result.")
        assertTrue(calculatorScreen.checkProcessingFeeResult("100"), "The processing fee amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalPaymentResult("1,026.04"), "The total payment amount does not match the expected result.")

        calculatorScreen.clickResetButton()
    }

    @Test
    @Order(3)
    fun `Check of values calculation when period is selected `() {
        calculatorScreen.selectPeriod()

        if (calculatorScreen.isPeriodSelected()) {
            println("The period radio button is selected.")
            calculatorScreen.enterLoanAmount("1000")
            calculatorScreen.enterInterestAmount("2")
            calculatorScreen.enterEmiAmount("34.2")
            calculatorScreen.enterProcessingFeeAmount("10")
        } else {
            fail("The period radio button is not selected. Test failed.")
        }

        calculatorScreen.clickCalculateButton()
        assertTrue(calculatorScreen.checkMonthlyEmiResult("34.2"), "The monthly EMI amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalInterestResult("26.54"), "The total interest amount does not match the expected result.")
        assertTrue(calculatorScreen.checkProcessingFeeResult("100"), "The processing fee amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalPaymentResult("1,026.54"), "The total payment amount does not match the expected result.")

        calculatorScreen.clickResetButton()
    }

    @Test
    @Order(4)
    fun `Check of values calculation when interest is selected `() {
        calculatorScreen.selectInterest()

        if (calculatorScreen.isInterestSelected()) {
            println("The interest radio button is selected.")
            calculatorScreen.enterLoanAmount("1000")
            calculatorScreen.enterPeriodYearsAmount("2")
            calculatorScreen.enterPeriodMonthsAmount("6")
            calculatorScreen.enterEmiAmount("34.2")
            calculatorScreen.enterProcessingFeeAmount("10")
        } else {
            fail("The interest radio button is not selected. Test failed.")
        }

        calculatorScreen.clickCalculateButton()
        assertTrue(calculatorScreen.checkMonthlyEmiResult("34.2"), "The monthly EMI amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalInterestResult("26"), "The total interest amount does not match the expected result.")
        assertTrue(calculatorScreen.checkProcessingFeeResult("100"), "The processing fee amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalPaymentResult("1,026"), "The total payment amount does not match the expected result.")

        calculatorScreen.clickResetButton()
    }

    @Test
    @Order(5)
    fun `Check of values calculation when amount is selected `() {
        calculatorScreen.selectAmount()

        if (calculatorScreen.isAmountSelected()) {
            println("The amount radio button is selected.")
            calculatorScreen.enterInterestAmount("2")
            calculatorScreen.enterPeriodYearsAmount("2")
            calculatorScreen.enterPeriodMonthsAmount("6")
            calculatorScreen.enterEmiAmount("34.2")
            calculatorScreen.enterProcessingFeeAmount("10")
        } else {
            fail("The amount radio button is not selected. Test failed.")
        }

        calculatorScreen.clickCalculateButton()
        assertTrue(calculatorScreen.checkMonthlyEmiResult("34.2"), "The monthly EMI amount does not match the expected result.")
        assertTrue(calculatorScreen.checkProcessingFeeResult("100"), "The processing fee amount does not match the expected result.")
        assertTrue(calculatorScreen.checkTotalPaymentResult("1,026"), "The total payment amount does not match the expected result.")

        calculatorScreen.clickResetButton()
    }

    @Test
    @Order(6)
    fun `Verifying the EMI payment calculation according to the months in the calculation history`() {
        calculatorScreen.clickNavigationDrawerButton()
        calculatorScreen.clickHistoryTabButton()
        detailsScreen.clickFirstHistoryCalculation()
        detailsScreen.isEmiDetailsLabelVisible()
        detailsScreen.verifyEmiHistory()
    }
}