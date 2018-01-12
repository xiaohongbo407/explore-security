package com.explore.security.core.validate.code.sms;

import com.explore.security.core.properties.SecurityProperties;
import com.explore.security.core.validate.code.VaildateCode;
import com.explore.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaohb on 2018/1/11.
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public VaildateCode generate(HttpServletRequest request) {
        int expireIn = ServletRequestUtils.getIntParameter(request,
                "expireIn",securityProperties.getCode().getSms().getExpireIn());
        int length = ServletRequestUtils.getIntParameter(request,
                "length",securityProperties.getCode().getImage().getLength());
        String code = RandomStringUtils.randomNumeric(length);
        return new VaildateCode(code,expireIn);
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
