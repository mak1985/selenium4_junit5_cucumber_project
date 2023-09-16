package com.domain.core;

import com.domain.pages.LoginPage;

public class PageInitializer extends BaseClass {
    public static LoginPage loginPage;
    public static void initialize() {
        // initialize pages
        loginPage = new LoginPage();

    }
}
