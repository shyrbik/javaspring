package com.alexspring.salesforce_integration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
//wfjwifiwefjiwefijweifj jfweijfiwefijwe
//wkfeowefokweofkkowefokwefoweofkowefwofow
//wlfepewflpwepflwpeflwepwepflwefppp
@RestController
@RequestMapping("/api/salesforce")
public class SalesforceController {
    
    @PostMapping("/calculate-discount")
    public ResponseEntity<DiscountResponse> calculateDiscount(
            @RequestBody OpportunityRequest request) {
        
        // Простая бизнес-логика
        double discount = request.amount() * 0.1; // 10%
        DiscountResponse response = new DiscountResponse(
            request.opportunityId(), discount, request.amount() - discount);
        
        return ResponseEntity.ok(response);
    }
    @GetMapping("/ping")
    public String ping() {
            return "OK from Spring";
        }
}

// DTO классы
record OpportunityRequest(String opportunityId, double amount) {}
record DiscountResponse(String opportunityId, double discount, double finalAmount) {}
