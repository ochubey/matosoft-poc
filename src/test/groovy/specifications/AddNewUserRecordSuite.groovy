package specifications

import geb.spock.GebReportingSpec
import pages.LoginPage
import pages.LogoutPage

/**
 * Created by Oleksiy on 27.06.2016.
 */
class AddNewUserRecordSuite extends GebReportingSpec {

    def loginName = System.getProperty("loginName")
    def password = System.getProperty("password")

    def "Login with empty credentials"() {
        given:
        go()
        at LoginPage

        when:
        doLogin("", "")

        then:
        assert errorMsg.text().contains("Failed to login using credentials supplied")
    }

    def "Login with incorrect login name"() {
        given:
        at LoginPage

        when:
        doLogin("incorrectLogin", password)

        then:
        assert errorMsg.text().contains("Failed to login using credentials supplied")
    }

    def "Login with incorrect password"() {
        given:
        go()
        at LoginPage

        when:
        doLogin(loginName, "incorrectPassword")

        then:
        assert errorMsg.text().contains("Failed to login using credentials supplied")
    }

    def "Login/Logout with correct credentials"() {
        given:
        go()
        at LoginPage

        when:
        doLogin(loginName, password)
        waitFor { at LogoutPage }
        doLogout()

        then:
        at LoginPage
        assert successMsg.text().contains("You have been logged out of the system")
    }
}
