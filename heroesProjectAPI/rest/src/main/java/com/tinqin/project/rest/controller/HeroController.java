package com.tinqin.project.rest.controller;

import com.tinqin.project.generics.Error;
import com.tinqin.project.model.appearance.HeroAppearanceRequest;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import com.tinqin.project.model.biography.HeroBiographyRequest;
import com.tinqin.project.model.biography.HeroBiographyResponse;
import com.tinqin.project.operation.HeroAppearanceProcess;
import com.tinqin.project.operation.HeroBiographyProcess;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {
    private final HeroAppearanceProcess heroAppearanceProcess;
    private final HeroBiographyProcess heroBiographyProcess;

    public HeroController(HeroAppearanceProcess heroAppearanceProcess, HeroBiographyProcess heroBiographyProcess) {
        this.heroAppearanceProcess = heroAppearanceProcess;
        this.heroBiographyProcess = heroBiographyProcess;
    }

    @PostMapping("/getHeroAppearance")
    public ResponseEntity<?> getHeroAppearance(@RequestBody HeroAppearanceRequest heroAppearanceRequest){
        Either<Error, HeroAppearanceResponse> response = heroAppearanceProcess.process(heroAppearanceRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());//TODO moje da ima oshte endpointove
    }

    @PostMapping("/getHeroBiography")
    public ResponseEntity<?> getHeroBiography(@RequestBody HeroBiographyRequest heroBiographyRequest){
        Either<Error, HeroBiographyResponse> response = heroBiographyProcess.process(heroBiographyRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());//TODO moje da ima oshte endpointove
    }
}
