package com.bloomberg.fxdealanalyzer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloomberg.fxdealanalyzer.exception.DealAlreadyProcessedException;
import com.bloomberg.fxdealanalyzer.model.FXDealEntity;
import com.bloomberg.fxdealanalyzer.model.FXDealRequest;
import com.bloomberg.fxdealanalyzer.repository.FXDealRepository;

@Service
@AllArgsConstructor
public class FXDealService {
	

    private FXDealRepository fxDealRepository;
    
    public FXDealEntity processFXDeal(FXDealEntity fxDeal) {
        if (fxDealRepository.existsByDealUniqueId(fxDeal.getDealUniqueId())) {
            throw new DealAlreadyProcessedException("Deal with ID " + fxDeal.getDealUniqueId() + " is already processed.");
        }


        return fxDealRepository.save(fxDeal);
    }

    public FXDealEntity processFXDeal(FXDealRequest fxDealRequest) {
        if (fxDealRepository.existsByDealUniqueId(fxDealRequest.getDealUniqueId())) {
            throw new DealAlreadyProcessedException("Deal with ID " + fxDealRequest.getDealUniqueId() + " is already processed.");
        }

        FXDealEntity fxDeal = convertToEntity(fxDealRequest);
        return fxDealRepository.save(fxDeal);
    }

    private FXDealEntity convertToEntity(FXDealRequest fxDealRequest) {
    	FXDealEntity fxDeal = new FXDealEntity();
        
        fxDeal.setDealUniqueId(fxDealRequest.getDealUniqueId());
        fxDeal.setFromCurrencyIsoCode(fxDealRequest.getFromCurrencyIsoCode());
        fxDeal.setToCurrencyIsoCode(fxDealRequest.getToCurrencyIsoCode());
        fxDeal.setDealTimestamp(fxDealRequest.getDealTimestamp());
        fxDeal.setDealAmount(fxDealRequest.getDealAmount());

        return fxDeal;
    }
}

