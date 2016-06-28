import org.openqa.selenium.firefox.FirefoxDriver

driver = {
    def driverInstance = new FirefoxDriver()
    driverInstance.manage().window().maximize()
    driverInstance
}
reportsDir = "build/reports/geb"
reportOnTestFailureOnly = true
autoClearCookies = true
baseUrl = "https://thomascook-uat.onmats.com"

waiting {
    timeout = 10
    retryInterval = 0.5
}