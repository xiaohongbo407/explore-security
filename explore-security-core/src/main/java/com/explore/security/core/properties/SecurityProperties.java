package com.explore.security.core.properties;

import com.explore.security.core.properties.BrowserProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xiaohb on 2018/1/9.
 */
@ConfigurationProperties(prefix = "explore.security")
public class SecurityProperties {

    BrowserProperties browser= new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
