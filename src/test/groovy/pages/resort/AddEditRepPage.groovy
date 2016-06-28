package pages.resort

import geb.Page

/**
 * Created by Oleksiy on 28.06.2016.
 */
class AddEditRepPage extends Page {
    static at = { $("#sub_page_title").text().contains("Add / Edit Rep") }
    static content = {
        userNameFld { $("input", name: "fragment[74674]", class: "valid_username") }
        userFirstName { $("input", name: "fragment[74689]", class: "valid_string") }
        userLastName { $("input", name: "fragment[74694]", class: "valid_string") }
        emailAddress { $("input", name: "fragment[74664]", class: "valid_email") }
        mobileNumber { $("input", name: "fragment[74679]", class: "valid_mobile") }
        passwordFld { $("input", name: "fragment[74684]", type: "password", class: "valid_password") }
        passwordValidationFld { $("input", type: "password", class: "password_validation") }
        timeZoneSelector { $("select", name: "fragment[74709]") }
        lockStatusSelector { $("select", name: "fragment[74704]") }
        submitBtn {
            lockStatusSelector.parent().parent().parent().parent().find(type: "submit", class: "btn-success", value: "Submit")
        }
    }

    def enterValidData(String userName, String firstName, String lastName, String email, String mobile, String password, String timeZone, String lockStatus) {
        userNameFld.value(userName)
        userFirstName.value(firstName)
        userLastName.value(lastName)
        emailAddress.value(email)
        mobileNumber.value(mobile)
        passwordFld.value(password)
        passwordValidationFld.value(password)
        timeZoneSelector = timeZone
        lockStatusSelector = lockStatus
        submitBtn.click()
    }

    def changeTimeZone(String email, String newTimeZone) {
        waitFor { emailAddress }
        assert emailAddress.getAttribute("value").equals(email)
        waitFor { timeZoneSelector }
        timeZoneSelector = newTimeZone
        submitBtn.click()
    }
}

