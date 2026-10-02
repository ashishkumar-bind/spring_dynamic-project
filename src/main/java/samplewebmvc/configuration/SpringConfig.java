package samplewebmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "samplewebmvc")
@Configuration
public class SpringConfig implements WebMvcConfigurer {


    // ==============================
    // DataSource
    // ==============================

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "com.mysql.cj.jdbc.Driver"
        );

        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/pancham_db"
        );

        dataSource.setUsername("root");

        dataSource.setPassword("Ashish@1234");

        return dataSource;
    }


    // ==============================
    // Hibernate SessionFactory
    // ==============================

    @Bean
    public LocalSessionFactoryBean sessionFactory(
            DataSource dataSource) {

        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);

        sessionFactory.setPackagesToScan(
                "sample.webmvc.entity"
        );

        Properties properties = new Properties();

        properties.put(
                "hibernate.show_sql",
                "true"
        );

        properties.put(
                "hibernate.format_sql",
                "true"
        );

        properties.put(
                "hibernate.hbm2ddl.auto",
                "update"
        );

        sessionFactory.setHibernateProperties(properties);

        return sessionFactory;
    }


    // ==============================
    // Transaction Manager
    // ==============================

    @Bean
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {

        return new HibernateTransactionManager(
                sessionFactory
        );
    }


    // ==============================
    // JSP View Resolver
    // ==============================

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);

        viewResolver.setPrefix(
                "/WEB-INF/JSP/"
        );

        viewResolver.setSuffix(
                ".jsp"
        );

        return viewResolver;
    }
}