package pages

import geb.Page

/**
 * Created by Oleksiy on 28.06.2016.
 */
class LogoutPage extends Page {
    static url = ""
    static at = { $("div", class: 'matssoft-search pull-right no-search') }
    static content = {
        dropdownBtn { $("div", class: 'matssoft-avatar pull-left dropdown noprint') }
        logoutMenuItem { $("a", class: 'logout', href: '/i/uk/logout') }
    }

    def doLogout() {
        waitFor { dropdownBtn }
        dropdownBtn.click()
        waitFor { logoutMenuItem }
        logoutMenuItem.click()
    }
}
