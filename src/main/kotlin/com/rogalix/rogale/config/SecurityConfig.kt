package com.rogalix.rogale.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService)
        provider.setPasswordEncoder(bCryptPasswordEncoder())
        return provider
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
            .cors().disable()
            .authorizeHttpRequests { requests ->
            requests
                .requestMatchers("/", "/home", "/login", "/register", "/stats").permitAll()
                .anyRequest().authenticated()
        }
            .formLogin { form ->
                form
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/login?error=true")
                    .permitAll()
            }
            .logout { logout ->
                logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            }

        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User.builder()
            .username("user")
            .password(bCryptPasswordEncoder()!!.encode("password"))
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user)
    }
}

@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(0)
    }
}
