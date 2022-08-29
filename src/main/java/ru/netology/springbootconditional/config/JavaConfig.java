package ru.netology.springbootconditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootconditional.profile.DevProfile;
import ru.netology.springbootconditional.profile.ProductionProfile;
import ru.netology.springbootconditional.profile.SystemProfile;

@Configuration
public class JavaConfig {


    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", matchIfMissing = true,
            havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", matchIfMissing = false, havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
