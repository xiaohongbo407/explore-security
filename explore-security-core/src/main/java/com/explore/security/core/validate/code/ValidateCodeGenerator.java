package com.explore.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaohb on 2018/1/11.
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(HttpServletRequest request);
}
