
package af.asr.kyc.infrastructure.core.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebFrontEndConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/apps/**").addResourceLocations("file:" +
                System.getProperty("user.dir") + System.getProperty("file.separator") +
                "apps" + System.getProperty("file.separator"));
    }

}
