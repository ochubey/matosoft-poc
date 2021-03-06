package specifications

import geb.spock.GebReportingSpec
import pages.authentication.LoginPage
import pages.authentication.LogoutPage

/**
 * Created by Oleksiy on 27.06.2016.
 */
class AuthenticationSuite extends GebReportingSpec {

    def loginName = System.getProperty("loginName")
    def password = System.getProperty("password")

    def setup() {
        go()
        at LoginPage
    }

    def "Login with empty credentials"() {
        when:
        doLogin("", "")

        then:
        assert errorMsg.text().contains("Failed to login using credentials supplied")
    }

    def "Login with incorrect login name"() {
        when:
        doLogin("incorrectLogin", password)

        then:
        assert errorMsg.text().contains("Failed to login using credentials supplied")
    }

    def "Login with incorrect password"() {
        when:
        doLogin(loginName, "incorrectPassword")

        then:
        assert errorMsg.text().contains("Failed to login using credentials supplied")
    }

    def "Login/Logout with correct credentials"() {
        when:
        doLogin(loginName, password)
        waitFor { at LogoutPage }
        doLogout()

        then:
        waitFor { at LoginPage }
    }
}
