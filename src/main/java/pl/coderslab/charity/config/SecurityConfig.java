package pl.coderslab.charity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/resources/**").permitAll()
                        .antMatchers("/img/**").permitAll()
                        .antMatchers("/logoutSuccess").permitAll()
                        .antMatchers("/login").permitAll()
                        .antMatchers("/registration/**").permitAll()
                        .antMatchers("/form/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
//                        .authenticated()
                        .and()
                        .formLogin()
                        .loginPage("/login").failureUrl("/login?error=true")
                        .defaultSuccessUrl("/")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .and().logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/logoutSuccess").
                        and().exceptionHandling()
                        .accessDeniedPage("/access-denied");
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
