package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);

        return daoAuthenticationProvider;
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
    
    //El siguiente método funciona para hacer la autenticación del usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/personas")
                .hasRole("ADMIN")
                .antMatchers("/personasN", "/personas")
                .hasAnyRole("USER", "VENDEDOR")
                .antMatchers("/")
                .hasAnyRole("USER", "VENDEDOR", "ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/signin").permitAll();
    }
//El siguiente método funciona parsa realizar la autorización de accesos

}

//package com.tienda;
//
//import com.tienda.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userDetailsService;
//    
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    
//    //El siguiente metodo funciona para haceer la autenticcion del usuario
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        //}
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123")
//                .roles("ADMIN", "VENDOR", "USER")
//                .and()
//                .withUser("vendor")
//                .password("{noop}123")
//                .roles("VENDOR", "USER")
//                .and()
//                .withUser("user")
//                .password("{noop}123")
//                .roles("USER");
//    }
//    //El siguiente funciona para realizar autorizacion de accesos
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests()
//                .antMatchers("/crear")
//                .hasRole("ADMIN")
//                .antMatchers("/x")
//                .hasAnyRole("ADMIN", "VENDOR")
//                .and()
//                .formLogin();                
//    }
//    
//}
