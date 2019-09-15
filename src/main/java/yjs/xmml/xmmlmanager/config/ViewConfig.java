package yjs.xmml.xmmlmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("/index.html");
        registry.addViewController("page/main.html").setViewName("/page/main.html");
        registry.addViewController("/page/systemParameter/systemParameter.html").setViewName("/page/systemParameter/systemParameter.html");
        registry.addViewController("/page/systemParameter/upload.html").setViewName("/page/systemParameter/upload.html");
    }
}
