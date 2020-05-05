package kr.lul.blog.street.cat.study.api;

import kr.lul.blog.street.cat.study.api.configuration.ApiConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@SpringBootApplication(scanBasePackageClasses = ApiConfiguration.class)
@EnableWebMvc
public class ApiTestConfiguration {
}
