package kr.lul.blog.street.cat.study.common.configuration;

import kr.lul.blog.street.cat.study.common.CommonAnchor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = CommonAnchor.class)
@EntityScan(basePackageClasses = {CommonAnchor.class})
@EnableTransactionManagement
public class JpaConfiguration {
}
