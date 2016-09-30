package kr.lul.pages.spring.boot14.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Just Burrow
 * @since 2016. 10. 1.
 */
@SpringBootApplication
@EnableWebMvc
public class Spring14Runner {
  /**
   * @param args
   * @throws Exception
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Spring14Runner.class, args);
  }
}
