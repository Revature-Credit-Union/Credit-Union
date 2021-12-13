//package com.revature.RCUbackend.security;
//
//import com.revature.RCUbackend.services.UserDetailsServiceImpl;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import static org.mockito.Mockito.when;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@RunWith(MockitoJUnitRunner.class)//attach a runner with the test class to initialize the test
//@SpringBootTest
//public class WebSecurityConfigTest {
//
//    @Mock
//    @InjectMocks//create and inject the mock object
//    WebSecurityConfig webSecurityConfig = new WebSecurityConfig();
//
//    //@Mock
//    //AuthTokenFilter authTokenFilter = new AuthTokenFilter();
//
//    @Mock//create the mock object to be injected
//    UserDetailsServiceImpl userDetailsService;
//
//    @Mock
//    AuthEntryPointJwt unauthorizedHandler;
//
//    @Test
//    public void authenticationJwtTokenFilterTest() {
//        //return new AuthTokenFilter();
//        when(webSecurityConfig.authenticationJwtTokenFilter()).thenReturn(new AuthTokenFilter());
//        Assert.assertEquals(webSecurityConfig.authenticationJwtTokenFilter(),new AuthTokenFilter());
//
//
//    }

//    /**
//     * Override method configure to configure the Authentication Manager Builder.
//     * @param authenticationMangerBuilder
//     * @throws Exception if authentication manager builder fails to configure.
//     */
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationMangerBuilder) throws Exception{
//        authenticationMangerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//
//    }
//
//    /**
//     * authenticationManagerBean bean method.
//     * @return An instantiation of a Authentication Manager.
//     * @throws Exception
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//
//    /**
//     * passwordEncoder bean method.
//     * @return An instantiation of a Password Encoder.
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/h2-console/**").permitAll();
//
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//
//
//        httpSecurity.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api/test/**").permitAll()
//                .anyRequest().authenticated();
//
//        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//}
