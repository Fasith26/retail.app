package edu.RetailPosApplication.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/products/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/api/sales/**").hasAnyRole("CASHIER", "MANAGER")
                        .requestMatchers("/api/reservations/**").hasAnyRole("CASHIER", "MANAGER")
                        .anyRequest().authenticated()
                )
                .httpBasic(); // or .formLogin() for a login page
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminpass"))
                .roles("ADMIN")
                .build();

        UserDetails manager = User.withUsername("manager")
                .password(passwordEncoder().encode("managerpass"))
                .roles("MANAGER")
                .build();

        UserDetails cashier = User.withUsername("cashier")
                .password(passwordEncoder().encode("cashierpass"))
                .roles("CASHIER")
                .build();

        return new InMemoryUserDetailsManager(admin, manager, cashier);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
