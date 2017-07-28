package com.lenovo.ad.config;

/**
 * Created by chenlm3 on 2017/7/21.
 */
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    @Bean(name = "luckydraw")
    @Qualifier("luckydraw")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.luckdraw")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "game")
    @Qualifier("game")
    @ConfigurationProperties(prefix="spring.datasource.game")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

}