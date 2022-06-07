package com.wayz.dataTools.postgreHandle.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.wayz.dataTools.postgreHandle.repository",sqlSessionFactoryRef = "pgSqlSessionFactory")
public class PgsqlDataSourceConfig {

    @Value("${pgsql.mapper.location}")
    private String MAPPER_LOCATION;

    @Bean(name = "pgDataSource")
    @ConfigurationProperties(prefix = "spring.pgsql.datasource")
    public DataSource pgDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean(name = "pgTransactionManager")
    public DataSourceTransactionManager pgTransactionManager() {
        return new DataSourceTransactionManager(pgDataSource());
    }

    @Bean(name = "pgSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("pgDataSource") DataSource pgDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(pgDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
