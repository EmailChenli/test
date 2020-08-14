package com.example.demo.BeanConfiguration;

/*public class FilterConfiguration implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        FilterRegistration registration = registry.(new UserFilter());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                "/login",            //登录
                "/layui/**",            //html静态资源
                "/css/**",              //js静态资源
                "/images/**",             //css静态资源
                "/imageCode"
        );
    }
}*/