package kr.lul.blog.street.cat.study.runner.api;

import kr.lul.blog.street.cat.study.api.configuration.ApiConfiguration;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@SpringBootApplication(scanBasePackageClasses = {ApiConfiguration.class})
public class ApiRunner {
  protected static final Logger log = getLogger(ApiRunner.class);

  public static void main(String[] args) {
    SpringApplication.run(ApiRunner.class, args);
  }
}
