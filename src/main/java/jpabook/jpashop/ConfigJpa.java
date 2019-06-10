package jpabook.jpashop;

import jpabook.jpashop.entity.auditor.LoggedInUsernameAuditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "loggedInUsernameAuditor")
public class ConfigJpa {

  @Bean
  LoggedInUsernameAuditor loggedInUsernameAuditor() {
    return new LoggedInUsernameAuditor();
  }

}
