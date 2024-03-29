import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CMICalculatorTests : AppiumSetup() {
    private val calculatorScreen = CalculatorScreen(driver)

    @Test
    fun `Check buttons and labels are visible`() {

        calculatorScreen.clickCMICalculationButton()

        assertAll("Check visibility of all elements",
            { assertTrue(calculatorScreen.isResetButtonVisible(), "Reset button should be visible.") },
            { assertTrue(calculatorScreen.isLoanAmountLabelVisible(), "Loan amount label should be visible.") },
            { assertTrue(calculatorScreen.isInterestLabelVisible(), "Interest label should be visible.") },
            { assertTrue(calculatorScreen.isPeriodLabelVisible(), "Period label should be visible.") },
            { assertTrue(calculatorScreen.isEMILabelVisible(), "EMI label should be visible.") },
            { assertTrue(calculatorScreen.isProcessingFeeLabelVisible(), "Processing Fee label should be visible.") }
        )

    }
}