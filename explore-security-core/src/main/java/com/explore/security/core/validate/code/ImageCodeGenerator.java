package com.explore.security.core.validate.code;

import com.explore.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

/**
 * Created by xiaohb on 2018/1/11.
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(HttpServletRequest request) {
        int length = ServletRequestUtils.getIntParameter(request,
                "length",securityProperties.getCode().getImage().getLength());
        int width = ServletRequestUtils.getIntParameter(request,
                "width",securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request,
                "height",securityProperties.getCode().getImage().getHeight());
        int expireIn = ServletRequestUtils.getIntParameter(request,
                "expireIn",securityProperties.getCode().getImage().getExpireIn());

        String verifyCode = VerifyCodeUtil.generateTextCode(length);
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(width,height,verifyCode);

        return new ImageCode(bufferedImage,verifyCode,expireIn);
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
