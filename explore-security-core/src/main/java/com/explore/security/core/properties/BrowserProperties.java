package com.explore.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xiaohb on 2018/1/9.
 */
public class BrowserProperties {

    private String loginPage = "/explore-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
