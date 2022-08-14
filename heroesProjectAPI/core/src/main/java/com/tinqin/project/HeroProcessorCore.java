package com.tinqin.project;

import com.tinqin.project.error.GeneralServerError;
import com.tinqin.project.error.HeroServiceUnavailableError;
import com.tinqin.project.generics.Error;
import com.tinqin.project.generics.OperationInput;
import com.tinqin.project.heroClient.exception.HeroClientException;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.HeroRequest;
import com.tinqin.project.model.HeroResponse;
import com.tinqin.project.operation.HeroProcess;
import io.vavr.control.Either;
import io.vavr.control.Try;

public class HeroProcessorCore implements HeroProcess {
    private final HeroClientService heroClientService;

    public HeroProcessorCore(HeroClientService heroClientService) {
        this.heroClientService = heroClientService;
    }


    @Override
    public Either<Error, HeroResponse> process(final HeroRequest input) {
        return Try.of(()->{
            final Hero hero = heroClientService.getHeroById(input.getHeroId());
            return HeroResponse.builder() //TODO add more response strings
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
