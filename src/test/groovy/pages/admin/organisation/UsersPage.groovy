package pages.admin.organisation

import geb.Page

/**
 * Created by Oleksiy on 28.06.2016.
 */
class UsersPage extends Page {
    static url = "/i/admin/p/79/1/1/1"
    static at = { $("input", name: "fragment[9882]") }
    static content = {
        emailSearchFld { $("input", name: "fragment[9882]") }
        searchBtn {
            $("input", name: "fragment[9882]").parent().parent().parent().parent().find("input.btn.btn-success", type: "submit", value: "Submit")
        }
        deleteBtn { $(".matssoft-icon-remove").parent("div").find("a") }
        confirmDeleteBtn { $("a.confirm-button") }
        successAlert { $("div.alert.alert-success") }
    }

    def searchByEmail(String email) {
        waitFor { $("input", name: "fragment[9882]").value(email) }
        waitFor {
            $("input", name: "fragment[9882]").parent().parent().parent().parent().find("input.btn.btn-success", type: "submit", value: "Submit").click()
        }
        sleep(1000)
    }

    def deleteEntry() {
        waitFor { $(".matssoft-icon-remove").parent("div").find("a").click() }
        waitFor { $("a.confirm-button").click() }
    }
}
