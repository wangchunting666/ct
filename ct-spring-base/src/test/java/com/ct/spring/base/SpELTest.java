package com.ct.spring.base;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by dell on 2018/7/1.
 */
public class SpELTest {
    @Test
    public void elTest() throws Exception{
        //解析器对象
        ExpressionParser parser = new SpelExpressionParser();
        //表达式对象
        Expression expression = null;
        //字符串解析:字符串单引号,报错IllegalStateException: Cannot handle (23383) '字'
        expression = parser.parseExpression("'字符串解析：Test'");
        System.out.println(expression.getValue());
        //对象方法
        expression = parser.parseExpression("'对象方法：'+java.lang.Math.random()");
        System.out.println(expression.getValue());
    }
}
