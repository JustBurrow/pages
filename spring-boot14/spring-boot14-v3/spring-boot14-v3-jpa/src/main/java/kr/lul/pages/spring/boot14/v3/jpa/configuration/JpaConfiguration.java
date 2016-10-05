package kr.lul.pages.spring.boot14.v3.jpa.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "kr.lul.pages.spring.boot14.v3.jpa.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "kr.lul.pages.spring.boot14.v3.jpa.entity")
public class JpaConfiguration {
}
