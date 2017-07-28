package com.lenovo.ad.config.reposity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by chenlm3 on 2017/7/21.
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactoryLuckydraw",
//        transactionManagerRef="transactionManagerLuckydraw",
//        basePackages= { "com.lenovo.ad.repository.luckdraw" }) //设置Repository所在位置
public class LuckdrawConfig {
    @Autowired
    @Qualifier("luckydraw")
    private DataSource LuckydrawDataSource;

    @Primary
    @Bean(name = "entityManagerLuckydraw")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryLuckydraw(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryLuckydraw")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryLuckydraw (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(LuckydrawDataSource)
                .properties(getVendorProperties(LuckydrawDataSource))
                .packages("com.lenovo.ad.bean.luckydraw") //设置实体类所在位置
                .persistenceUnit("LuckydrawPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerLuckydraw")
    public PlatformTransactionManager transactionManagerLuckydraw(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryLuckydraw(builder).getObject());
    }
}
