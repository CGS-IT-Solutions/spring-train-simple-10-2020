package at.cgsit.training.firstexample.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LogManager.getLogger();

  public WebSecurityConfig() {
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
    // Note that the CSRf token is disabled for all requests
    log.info("Disabling CSRF, enabling basic authentication...");
    http
        .authorizeRequests()
        //.antMatchers("/login.html").permitAll()
        .antMatchers("/**").authenticated() // These urls are allowed by any authenticated user
        .and()
        .httpBasic();

    http.authorizeRequests()
        .antMatchers("/actuator/**").permitAll();
    http.csrf().disable();
  }

    public static final String ROLE_READ =  "READ";
    public static final String ROLE_USER =  "USER";
    public static final String ROLE_POWER_USER =  "POWER_USER";


    @Bean
    protected UserDetailsService userDetailsService() {
      // Get the user credentials from the console (or any other source):

      String username = "admin";
      String password = "admin";

      // Set the inMemoryAuthentication object with the given credentials:
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      String encodedPassword = passwordEncoder().encode(password);

      manager.createUser(User.withUsername(username).password(encodedPassword).roles(ROLE_POWER_USER, ROLE_READ).build());
      manager.createUser(User.withUsername("simple").password(passwordEncoder().encode("simple")).roles(ROLE_USER, ROLE_READ).build());

      return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
  }

