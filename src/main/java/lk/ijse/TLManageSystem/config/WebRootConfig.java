package lk.ijse.TLManageSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(JPAConfig.class)
public class WebRootConfig {
    public WebRootConfig(){
    }
}
