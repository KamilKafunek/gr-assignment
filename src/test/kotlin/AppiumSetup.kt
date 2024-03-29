import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import java.net.URL



open class AppiumSetup {
    companion object {

        private const val activityName = "com.finance.emicalci.activity.Splash_screnn"
        private const val appPackage = "com.continuum.emi.calculator"
        private const val automationName = "UiAutomator2"
        private const val platformName = "Android"
        private const val serverUrl = "http://localhost:4723"

        lateinit var driver: AppiumDriver<MobileElement>
        private val caps = DesiredCapabilities()
        @JvmStatic
        @BeforeAll
        fun setUp() {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName)
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName)
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage)
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityName)
            caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
            caps.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000)
//            caps.setCapability("appium:ignoreHiddenApiPolicyError", true)
            driver = AndroidDriver(URL(serverUrl), caps)
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            driver.quit()
        }
    }
}