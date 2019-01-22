package com.grp.test;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2018-12-29 13:37
 **/
@SpringBootApplication
public class SpringBootDemoApp {
    public static void main(String[] args) throws InvocationTargetException, CompileException {
        SpringApplication.run(SpringBootDemoApp.class, args);
    }
}
