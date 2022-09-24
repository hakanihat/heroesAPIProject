package com.tinqin.project.model.appearance;

import com.tinqin.project.generics.OperationResult;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class HeroAppearanceResponse implements OperationResult {
    private String race;
    private String eyeColor;
    private String hairColor;
    private String heightInCm;
    private String WeightInKg;


}
