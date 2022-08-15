package com.tinqin.project.rest.controller;

import com.tinqin.project.generics.Error;
import com.tinqin.project.model.HeroAppearanceRequest;
import com.tinqin.project.model.HeroAppearanceResponse;
import com.tinqin.project.operation.HeroProcess;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HeroController {
    private final HeroProcess heroProcess;

    public HeroController(HeroProcess heroProcess) {
        this.heroProcess = heroProcess;
    }

    @PostMapping("/getHeroById")
    public ResponseEntity<?> getHeroAppearance(@RequestBody HeroAppearanceRequest heroAppearanceRequest){
        Either<Error, HeroAppearanceResponse> response = heroProcess.process(heroAppearanceRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());//TODO moje da ima oshte endpointove
    }
}
