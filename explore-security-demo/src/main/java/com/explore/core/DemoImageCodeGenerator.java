package com.explore.core;

import com.explore.security.core.validate.code.image.ImageCode;
import com.explore.security.core.validate.code.ValidateCodeGenerator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaohb on 2018/1/11.
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator{

    @Override
    public ImageCode generate(HttpServletRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
