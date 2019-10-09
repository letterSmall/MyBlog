package com.enlie.blog.config;

import com.enlie.blog.component.MyPasswordEncoder;
import com.enlie.blog.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailService")
    private UserDetailService userDetailService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable(); // 关闭跨站检测
        http.authorizeRequests().antMatchers("/back","/back/login","/login/back","/back/test","/**/")
                .permitAll().anyRequest().fullyAuthenticated(); // 所有的请求全验证
        http.formLogin().loginPage("/back/login").loginProcessingUrl("/login_check").failureUrl("/back/login").defaultSuccessUrl("/back/index").permitAll();
        http.logout().permitAll();//退出登录
        http.sessionManagement().invalidSessionUrl("/back/login");//设置session失效后跳转
        http.rememberMe().rememberMeParameter("remember-me");//实现记住我功能
//        http.logout().logoutUrl("/back/login").logoutSuccessUrl("/back/login").invalidateHttpSession(true);
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication().withUser("qushen").password("123456").roles("")
//                .and().passwordEncoder(new MyPasswordEncoder());
        auth.userDetailsService(userDetailService).passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        解决静态资源拦截问题
        web.ignoring().antMatchers("/backstage/**");
        web.ignoring().antMatchers("/reception/**");

    }
}
