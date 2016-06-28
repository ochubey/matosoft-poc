package specifications

import geb.spock.GebReportingSpec
import pages.admin.organisation.UsersPage
import pages.authentication.LoginPage
import pages.authentication.LogoutPage
import pages.resort.AddEditRepPage
import pages.resort.UserAdministrationPage

/**
 * Created by Oleksiy on 28.06.2016.
 */
class AddNewUserSuite extends GebReportingSpec {

    def loginName = System.getProperty("loginName")
    def password = System.getProperty("password")

    def repUserName = "someUserNameForTest"
    def repName = "Automation"
    def repSurname = "surname"
    def repEmail = "automationOnly@com.ua"
    def repMobile = "09710258641"
    def repPassword = "newPassword!2"
    def repTimeZone = "Europe/Kiev"
    def repNewTimeZone = "Europe/Madrid"
    def repLockStatus = "Unlocked"

    def setup() {
        go()
        waitFor { at LoginPage }
        doLogin(loginName, password)
        waitFor { at LogoutPage }
    }

    def "Add new Rep"() {
        given:
        go UserAdministrationPage.url

        when:
        waitFor { at UserAdministrationPage }
        clickNewRepBtn()
        waitFor { at AddEditRepPage }
        enterValidData(repUserName, repName, repSurname, repEmail, repMobile, repPassword, repTimeZone, repLockStatus)
        waitFor { at UserAdministrationPage }

        then:
        waitFor { $("div.alert.alert-success") }
    }

    def "Edit existing Rep"() {
        given:
        go UserAdministrationPage.url

        when:
        waitFor { at UserAdministrationPage }
        searchByEmail(repEmail)
        waitFor { at AddEditRepPage }
        changeTimeZone(repEmail, repNewTimeZone)
        waitFor { at UserAdministrationPage }

        then:
        waitFor { $("div.alert.alert-success") }
    }

    def "Delete all Rep by email"() {
        given:
        go UsersPage.url

        when:
        waitFor { at UsersPage }
        searchByEmail(repEmail)
        deleteEntry()

        then:
        waitFor { $("div.alert.alert-success") }
    }
}