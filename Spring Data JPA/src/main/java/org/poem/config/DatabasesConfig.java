package org.poem.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * data bases configure
 */
@Configuration
public class DatabasesConfig {

    @Bean(name = "datasource")
    public DataSource dataSource(Environment environment) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        try {
            hikariDataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
            hikariDataSource.setUsername(environment.getProperty("spring.datasource.username"));
            hikariDataSource.setPassword(environment.getProperty("spring.datasource.password"));
            hikariDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
            hikariDataSource.setLoginTimeout(60000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hikariDataSource;
    }
}
