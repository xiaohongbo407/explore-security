package com.explore.security.core.validate.code;

import com.explore.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by xiaohb on 2018/1/10.
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY="SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = createImageCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }

    private ImageCode createImageCode(HttpServletRequest request) {
        int length = ServletRequestUtils.getIntParameter(request,"length",securityProperties.getCode().getImage().getLength());
        int width = ServletRequestUtils.getIntParameter(request,"width",securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request,"height",securityProperties.getCode().getImage().getHeight());
        int expireIn = ServletRequestUtils.getIntParameter(request,"expireIn",securityProperties.getCode().getImage().getExpireIn());


        String verifyCode = VerifyCodeUtil.generateTextCode(length);
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(width,height,verifyCode);

        return new ImageCode(bufferedImage,verifyCode,expireIn);
    }

}
