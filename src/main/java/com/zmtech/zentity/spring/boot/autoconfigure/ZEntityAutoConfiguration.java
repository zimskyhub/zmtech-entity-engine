package com.zmtech.zentity.spring.boot.autoconfigure;

import com.zmtech.zentity.ZEntityFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * spring boot configuration
 * set properties zentity needs and start zentityfacade
 */
@Configuration
@ConditionalOnClass(ZEntityFacade.class)
@ConditionalOnSingleCandidate(DataSource.class)
@EnableConfigurationProperties(ZEntityProperties.class)
@AutoConfigureAfter({ DataSourceAutoConfiguration.class})
public class ZEntityAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ZEntityAutoConfiguration.class);

    private final ZEntityProperties properties;

    public ZEntityAutoConfiguration(ZEntityProperties properties){
        this.properties = properties;

    }

}
