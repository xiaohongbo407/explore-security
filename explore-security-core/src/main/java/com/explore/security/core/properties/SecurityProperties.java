package com.explore.security.core.properties;

import com.explore.security.core.properties.BrowserProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xiaohb on 2018/1/9.
 */
@ConfigurationProperties(prefix = "explore.security")
public class SecurityProperties {

    BrowserProperties browser= new BrowserProperties();

    private VaildateCodeProperties code = new VaildateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public VaildateCodeProperties getCode() {
        return code;
    }

    public void setCode(VaildateCodeProperties code) {
        this.code = code;
    }
}
