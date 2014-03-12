package com.truste.app.config;

import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    //{!begin addToRootContext}
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[]{ApplicationConfig.class,
                PersistenceConfig.class, SecurityConfig.class};
    }
    //{!end addToRootContext}

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters()
    {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");


        OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
        openEntityManagerInViewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");

        return new Filter[]{characterEncodingFilter, openEntityManagerInViewFilter};
    }

}