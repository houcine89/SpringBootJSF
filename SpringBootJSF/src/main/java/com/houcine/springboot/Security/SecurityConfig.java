package com.houcine.springboot.Security;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Created by houcinegasmi on 13/01/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers("/index.jsf").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.jsf")
                .permitAll()
                .failureUrl("/login.jsf?error=true")
                .defaultSuccessUrl("/index.jsf")
                .and()
                .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout.jsf")
                .logoutSuccessUrl("/login.jsf");
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER");*/
        auth.jdbcAuthentication().dataSource(dataSource) .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }
}