package autom.order.tracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
public class GUISecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/web/**").permitAll()
                .anyRequest().authenticated()
            //.and()
            //.exceptionHandling()
            .and()
            .formLogin()
          //  .loginPage("/web/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();

    }

    @Bean
    public AuthenticationEntryPoint loginUrlAuthenticationEntryPoint(){
        return new LoginUrlAuthenticationEntryPoint("/login");
    }
}
