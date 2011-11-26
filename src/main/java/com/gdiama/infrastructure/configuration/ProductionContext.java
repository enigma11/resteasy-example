package com.gdiama.infrastructure.configuration;

import com.gdiama.infrastructure.rest.LiquidityEndpoint;
import com.gdiama.infrastructure.rest.impl.LiquidityEndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ProductionContext {

    @Bean
    public LiquidityEndpoint liquidityEndpoint() {
        return new LiquidityEndpointImpl();
    }

}
