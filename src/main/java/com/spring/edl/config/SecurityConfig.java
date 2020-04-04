package com.spring.edl.config;

import com.spring.edl.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    UserDetailsServiceImpl userDetailsService;
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
        http.authorizeRequests().antMatchers("/index").authenticated();
 
        		http.authorizeRequests().antMatchers("/usuarios/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_CONFIG')");//Consultar Usuarios</a></li>
                        http.authorizeRequests().antMatchers("/usuarios/new/usuario")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_CONFIG')");//Crear Usuario</a></li>
                        http.authorizeRequests().antMatchers("/roles/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_CONFIG')");//Consultar Roles</a></li>
                        http.authorizeRequests().antMatchers("/roles/new/rol")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_CONFIG')");//Crear Rol</a></li>
                        http.authorizeRequests().antMatchers("/usuariosroles/")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_CONFIG')");//Consultar roles asignados</a></li>
                        http.authorizeRequests().antMatchers("/usuariosroles/new/usuariorol")
                            .access("hasAnyRole('ROLE_ADMIN','ROLE_CONFIG')");//Asignar Roles</a></li>
                                
        

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/index")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
 
    }
}
