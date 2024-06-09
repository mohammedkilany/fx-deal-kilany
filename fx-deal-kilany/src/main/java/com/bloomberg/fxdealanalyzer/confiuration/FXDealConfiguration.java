package com.bloomberg.fxdealanalyzer.confiuration;

import com.bloomberg.fxdealanalyzer.repository.FXDealRepository;
import com.bloomberg.fxdealanalyzer.service.FXDealService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FXDealConfiguration {

    @Bean
    public FXDealService fxDealService(FXDealRepository fxDealRepository) {
        return new FXDealService(fxDealRepository);
    }

}
