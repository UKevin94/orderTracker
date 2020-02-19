package autom.order.tracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.sql.DataSource;

@Configuration
@Order(1)
public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {

/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("SELECT login, admin FROM users WHERE login=?")
                .usersByUsernameQuery("SELECT login, password FROM users WHERE login=?");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();*/
        http.antMatcher("/api/**")
                .authorizeRequests().anyRequest().hasRole("ADMIN")
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("admin realm");
        return entryPoint;
    }
}
