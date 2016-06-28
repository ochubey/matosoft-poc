package pages.authentication

import geb.Page

/**
 * Created by Oleksiy on 28.06.2016.
 */
class LoginPage extends Page {
    static url = "/i/uk/login"
    static at = { $("form", class: 'loginform') }
    static content = {
        userName { $("input", name: 'login_code') }
        password { $("input", name: 'password') }
        loginBtn { $("button", class: 'btn btn-success') }
        errorMsg { $("div", class: 'alert alert-error') }
        successMsg { $("div", class: 'alert alert-success') }
    }

    def doLogin(String name, String pass) {
        waitFor { userName != null }
        userName.value(name)
        password.value(pass)
        loginBtn.click()
    }
}
