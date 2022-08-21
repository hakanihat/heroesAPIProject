package com.tinqin.project;

import com.tinqin.project.error.GeneralServerError;
import com.tinqin.project.error.HeroServiceUnavailableError;
import com.tinqin.project.generics.Error;
import com.tinqin.project.heroClient.exception.HeroClientException;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.appearance.HeroAppearanceRequest;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import com.tinqin.project.operation.HeroAppearanceProcess;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class HeroAppearanceProcessorCore implements HeroAppearanceProcess {
    private final HeroClientService heroClientService;

    public HeroAppearanceProcessorCore(HeroClientService heroClientService) {
        this.heroClientService = heroClientService;
    }


    @Override
    public Either<Error, HeroAppearanceResponse> process(final HeroAppearanceRequest input) {
        return Try.of(()->{
            final Hero hero = heroClientService.getHeroById(input.getHeroId());
            return HeroAppearanceResponse.builder() //TODO add more response strings
                    .race(hero.appearance.getRace())
                    .heightInCm(hero.appearance.getHeight().get(1))
                    .WeightInKg(hero.appearance.getWeight().get(1))
                    .eyeColor(hero.appearance.getEyeColor())
                    .hairColor(hero.appearance.getHairColor())
                    .build();
        }).toEither()
                .mapLeft(throwable -> {
                    if(throwable instanceof HeroClientException){
                        return new HeroServiceUnavailableError();
                    }
                    return new GeneralServerError();
                });
    }
}
