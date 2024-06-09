package com.bloomberg.fxdealanalyzer.controller;

import com.bloomberg.fxdealanalyzer.model.FXDealEntity;
import com.bloomberg.fxdealanalyzer.service.FXDealService;
import com.google.common.flogger.FluentLogger;
import lombok.AllArgsConstructor;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fxdeals")
@AllArgsConstructor
public class FXDealController {

    private static FluentLogger log = FluentLogger.forEnclosingClass();

    private final FXDealService fxDealService;

    @PostMapping
    public ResponseEntity<FXDealEntity> createFXDeal(@Valid @RequestBody FXDealEntity fxDeal) {
        log.atInfo().log("Received request to process FX deal with ID: %s", fxDeal.getDealUniqueId());

        FXDealEntity savedDeal = fxDealService.processFXDeal(fxDeal);
        log.atInfo().log("Successfully processed FX deal with ID: %s", fxDeal.getDealUniqueId());

        return ResponseEntity.ok(savedDeal);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<FXDealEntity>> createFXDeals(@Valid @RequestBody List<FXDealEntity> fxDeals) {
        log.atInfo().log("Received request to process a batch of FX deals");
        List<FXDealEntity> savedDeals = fxDeals.stream()
                .map(fxDealService::processFXDeal)
                .collect(Collectors.toList());
        log.atInfo().log("Successfully processed batch of FX deals");
        return ResponseEntity.ok(savedDeals);
    }
}
