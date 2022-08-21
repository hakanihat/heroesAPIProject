package com.tinqin.project.model.biography;

import com.tinqin.project.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
public class HeroBiographyResponse implements OperationResult {
    private String fullName;
    private String alterEgos;
    private String placeOfBirth;
    private String publisher;
    private String firstAppearance;

}
