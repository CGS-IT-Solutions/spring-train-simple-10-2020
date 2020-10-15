package at.cgsit.training.firstexample.config;

import at.cgsit.training.firstexample.restsecurity.CustomBasicAuthenticationEntryPoint;
import at.cgsit.training.firstexample.security.MyLoginSuccessHandler;
import at.cgsit.training.firstexample.security.MyLogoutSuccessHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private static final Logger log = LogManager.getLogger();

  @Autowired
  private MyLogoutSuccessHandler myLogoutSuccessHandler;

  @Autowired
  private MyLoginSuccessHandler myLoginSuccessHandler;


  public WebSecurityConfig() {
  }

  public static String REST_REALM="MY_TEST_REALM";

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
    // Note that the CSRf token is disabled for all requests
    log.info("Disabling CSRF, enabling basic authentication...");

    // .httpBasic();
    /*
    http
        .authorizeRequests()
        .antMatchers("/index.html", "/error.html", "/login_error.html")
        .permitAll()
        .antMatchers("/**").authenticated() // These urls are allowed by any authenticated user
        .and()
        .formLogin()
        //.defaultSuccessUrl( "/chatmessage/list" )
        .loginPage("/login.html")
        // .successHandler(myLoginSuccessHandler)
        //.loginProcessingUrl("/chatmessage/list")
        .permitAll()
        .failureUrl("/login-error.html")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessHandler(myLogoutSuccessHandler)
        .logoutSuccessUrl("/index.html");


        http.authorizeRequests()
            .antMatchers("/actuator/**").permitAll();
        http.csrf().disable();
     */

    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/trainerrest/**")
        //.anonymous()
        .authenticated() // .hasRole(ROLE_USER)
        .and()
        .httpBasic()
        .realmName(REST_REALM)
        .authenticationEntryPoint(getBasicAuthEntryPoint())
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .logout()
        .logoutUrl("/logout")
        .invalidateHttpSession(true)
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSIONID")
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

  }

  @Bean
  public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
    return new CustomBasicAuthenticationEntryPoint();
  }

  /* To allow Pre-flight [OPTIONS] request from browser */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
  }


    public static final String ROLE_READ =  "READ";
    public static final String ROLE_USER =  "USER";
    public static final String ROLE_POWER_USER =  "POWER_USER";


    @Bean
    protected UserDetailsService userDetailsService() {
      // Get the user credentials from the console (or any other source):

      String username = "admin";
      String password = "12345";

      // Set the inMemoryAuthentication object with the given credentials:
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      String encodedPassword = passwordEncoder().encode(password);

      manager.createUser(User.withUsername(username).password(encodedPassword).roles(ROLE_POWER_USER, ROLE_READ, ROLE_USER).build());
      manager.createUser(User.withUsername("simple").password(passwordEncoder().encode("simple")).roles(ROLE_USER, ROLE_READ).build());

      return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
  }

