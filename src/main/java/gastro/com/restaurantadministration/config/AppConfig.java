package gastro.com.restaurantadministration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("api/v1/").setViewName("index");
        registry.addViewController("api/v1/index").setViewName("index");
        registry.addViewController("api/v1/home").setViewName("index");
    }
}
