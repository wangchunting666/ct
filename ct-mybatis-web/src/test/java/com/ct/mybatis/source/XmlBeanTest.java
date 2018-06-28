package com.ct.mybatis.source;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

/**
 * Created by Herdsric-M-003 on 2018/6/19.
 */
public class XmlBeanTest {
    public static void main(String[] args) {
        DefaultListableBeanFactory dlbf= new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(dlbf);
        reader.loadBeanDefinitions(new ClassPathResource("/spring/applicationContext-dao.xml"));
        MybatisSqlSessionFactoryBean sqlSessionFactory = (MybatisSqlSessionFactoryBean)dlbf.getBean("sqlSessionFactory");
    }
}
