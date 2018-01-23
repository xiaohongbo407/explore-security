package com.explore.security.core.validate.code.impl;

import com.explore.security.core.validate.code.ValidateCodeGenerator;
import com.explore.security.core.validate.code.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * Created by xiaohb on 2018/1/23.
 */
public class AbstractValidateCodeProcessor implements ValidateCodeProcessor {

    @Autowired
    private Map<String,ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
    }

    private C generate(ServletWebRequest request) {

    }

    /**
     * 保存验证码
     * @param request
     * @param validateCode
     * @throws Exception
     */
    public void save(ServletWebRequest request,C validateCode) throws Exception {

    }
    /**
     * 发送验证码，由子类实现
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request,C validateCode) throws Exception ;



}
