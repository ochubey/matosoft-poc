package pages.authentication

import geb.Page

/**
 * Created by Oleksiy on 28.06.2016.
 */
class LogoutPage extends Page {
    static url = "i/uk/p/7/22/504/1129"
    static at = { $("div", class: 'matssoft-avatar pull-left dropdown noprint') }
    static content = {
        dropdownBtn { $("div", class: 'matssoft-avatar pull-left dropdown noprint') }
        adminMenuItem { $("a", href: '/i/admin/p/79/1/1/1') }
        logoutMenuItem { $("a", class: 'logout', href: '/i/uk/logout') }
    }

    def doLogout() {
        waitFor { dropdownBtn }
        dropdownBtn.click()
        waitFor { logoutMenuItem }
        logoutMenuItem.click()
    }
}
