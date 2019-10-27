package kr.lul.pages.how.to.use.orm.om;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/27
 */
@SpringBootApplication
public class OmRunner {
  private static final Logger log = getLogger(OmRunner.class);

  public static void main(String... args) {
    SpringApplication application = new SpringApplication(OmRunner.class);
    application.addListeners(new ApplicationPidFileWriter());
    ApplicationContext context = application.run(args);

    if (log.isTraceEnabled()) {
      for (String name : context.getBeanDefinitionNames()) {
        log.trace("{}={}", name, context.getBean(name));
      }
    }
  }
}
