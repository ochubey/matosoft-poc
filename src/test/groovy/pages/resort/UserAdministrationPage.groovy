package pages.resort

import geb.Page

/**
 * Created by Oleksiy on 28.06.2016.
 */
class UserAdministrationPage extends Page {
    static url = "/i/uk/p/111/121/789/2049"
    static at = {
        $("#page_form > table > tbody > tr:nth-child(2) > td.layout_cell.size4.first > div > div > h3").text().contains("Search existing users")
    }
    static content = {
        pageInternalTitle {
            $("#page_form > table > tbody > tr:nth-child(2) > td.layout_cell.size4.first > div > div > h3")
        }
        addRepBtn { $(href: "/i/uk/p/111/121/789/2079?") }
        successAlert { $("div", class: "alert").find("strong") }
        searhByEmailFld { $("input", name: "fragment[324464]") }
        searchSubmitBtn { $("input.btn.btn-success") }
    }

    def clickNewRepBtn() {
        waitFor { addRepBtn }
        addRepBtn.click()
    }

    def searchByEmail(String email) {
        searhByEmailFld.value(email)
        searchSubmitBtn.click()
        sleep(5000)
        $("a.record_link:nth-child(2)").click()
    }
}
