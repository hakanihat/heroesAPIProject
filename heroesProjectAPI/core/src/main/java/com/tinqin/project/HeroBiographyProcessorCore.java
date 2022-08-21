package com.tinqin.project;

import com.tinqin.project.error.GeneralServerError;
import com.tinqin.project.error.HeroServiceUnavailableError;
import com.tinqin.project.generics.Error;
import com.tinqin.project.heroClient.exception.HeroClientException;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import com.tinqin.project.model.biography.HeroBiographyRequest;
import com.tinqin.project.model.biography.HeroBiographyResponse;
import com.tinqin.project.operation.HeroBiographyProcess;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class HeroBiographyProcessorCore implements HeroBiographyProcess {
    private final HeroClientService heroClientService;

    public HeroBiographyProcessorCore(HeroClientService heroClientService) {
        this.heroClientService = heroClientService;
    }

    @Override
    public Either<Error, HeroBiographyResponse> process(HeroBiographyRequest input) {
        return Try.of(()->{
                    final Hero hero = heroClientService.getHeroById(input.getHeroId());
                    return HeroBiographyResponse.builder()
                            .fullName(hero.getBiography().fullName)
                            .alterEgos(hero.getBiography().alterEgos)
                            .firstAppearance(hero.getBiography().firstAppearance)
                            .publisher(hero.getBiography().publisher)
                            .placeOfBirth(hero.getBiography().placeOfBirth)
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
