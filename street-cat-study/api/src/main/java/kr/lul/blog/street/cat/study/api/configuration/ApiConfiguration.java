package kr.lul.blog.street.cat.study.api.configuration;

import kr.lul.blog.street.cat.study.api.ApiAnchor;
import kr.lul.blog.street.cat.study.common.CommonAnchor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {ApiAnchor.class, CommonAnchor.class})
public class ApiConfiguration {
}
