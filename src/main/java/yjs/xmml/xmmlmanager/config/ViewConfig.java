package yjs.xmml.xmmlmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
        registry.addViewController("page/news/newsList.html").setViewName("page/news/newsList.html");
        registry.addViewController("page/news/newsList.js").setViewName("page/news/newsList.js");
        registry.addViewController("page/news/newsAdd.html").setViewName("page/news/newsAdd.html");
        registry.addViewController("page/news/authentication.html").setViewName("page/news/authentication.html");
        registry.addViewController("page/news/authentication.js").setViewName("page/news/authentication.js");
        registry.addViewController("page/news/authdetail.html").setViewName("page/news/authdetail.html");
        registry.addViewController("page/news/authdetail.js").setViewName("page/news/authdetail.js");
        registry.addViewController("page/systemParameter/filmList.html").setViewName("page/systemParameter/filmList.html");
        registry.addViewController("page/systemParameter/filmList.js").setViewName("page/systemParameter/filmList.js");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Content.handlerUrl).addResourceLocations("file:"+Content.studentCard);
    }
}
