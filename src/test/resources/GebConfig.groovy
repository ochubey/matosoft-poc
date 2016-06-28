import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

environments {

    // run via “./gradlew chromeTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { new ChromeDriver() }
    }

    // run via “./gradlew firefoxTest”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }
}
reportsDir = "build/reports/geb"
reportOnTestFailureOnly = true
autoClearCookies = true
baseUrl = "https://thomascook-uat.onmats.com"

waiting {
    timeout = 10
    retryInterval = 0.5
}