package com.devsenior.sergio.service.Factory;

import org.springframework.stereotype.Component;

import com.devsenior.sergio.dto.TripRequest;
import com.devsenior.sergio.model.FareType;
import com.devsenior.sergio.service.impl.EconomyFareStrategy;
import com.devsenior.sergio.service.impl.PremiumFareStrategy;
import com.devsenior.sergio.service.impl.SurgeFareStrategy;

@Component 
public class TotalFactory {

    private final EconomyFareStrategy economyFareStrategy;
    private final PremiumFareStrategy premiumFareStrategy;
    private final SurgeFareStrategy surgeFareStrategy;

    public TotalFactory(EconomyFareStrategy economyFareStrategy, PremiumFareStrategy premiumFareStrategy,
            SurgeFareStrategy surgeFareStrategy) {
        this.economyFareStrategy = economyFareStrategy;
        this.premiumFareStrategy = premiumFareStrategy;
        this.surgeFareStrategy = surgeFareStrategy;
    }

    public double calculateTotal(TripRequest tripRequest){
        double distance = tripRequest.getDistance();
        double duration = tripRequest.getDuration();
        FareType fareType = FareType.valueOf(tripRequest.getFareType());

        switch (fareType) {
            case ECONOMY:
               return economyFareStrategy.calculateFare(distance, duration);

            case PREMIUM:
                return premiumFareStrategy.calculateFare(distance, duration);

            case SURGE:
                return surgeFareStrategy.calculateFare(distance, duration);

            default:
                throw new IllegalArgumentException("invalid fare typo: " + fareType);
        }
    }
}
