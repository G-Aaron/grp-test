package com.grp.test;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 *
 * @version 1.0
 * @author: gaorenpeng
 * @date: 2019-01-22 08:59
 **/
public class ExTest {
    public static void main(String[] args) throws CompileException, InvocationTargetException {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        eval.cook("1/1");
        System.out.println(eval.evaluate(null));
    }
}
