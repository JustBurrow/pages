package kr.lul.pages.spring.boot14.v3.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
@SpringBootApplication(scanBasePackages = { "kr.lul.pages.spring.boot14.v3" })
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "kr.lul.pages.spring.boot14.v3.jpa" })
@EntityScan(basePackages = "kr.lul.pages.spring.boot14.v3.jpa")
@EnableTransactionManagement
public class Spring14Runner {
  /**
   * @param args
   * @throws Exception
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Spring14Runner.class, args);
  }
}
