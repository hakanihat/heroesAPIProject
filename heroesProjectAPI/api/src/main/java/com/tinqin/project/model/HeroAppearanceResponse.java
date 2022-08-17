package com.tinqin.project.model;

import com.tinqin.project.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class HeroAppearanceResponse implements OperationResult {
    private String race;
    private String eyeColor;
    private String hairColor;
    private String heightInCm;
    private String WeightInKg;


}
