package com.example.demojdbc.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-11-1
 * Time: 下午9:26
 * Describe: MybatisDb2 Config
 */
@Configuration
@MapperScan(basePackages = {"com.example.demojdbc.dao.db2"}, sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisDb2Config {

    @Qualifier("ds2")
    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
       // PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
       // factoryBean.setMapperLocations(resolver.getResources("classpath:mappers/db2/*.xml"));
       // factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/db2/*.xml"));
        factoryBean.setTypeAliasesPackage("com.example.demojdbc.po");
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2());
        return template;
    }
    @Bean(name = "jdbcTemplate2")
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }
}

