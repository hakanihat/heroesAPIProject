package com.tinqin.project.model.biography;

import com.tinqin.project.generics.OperationResult;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class HeroBiographyResponse implements OperationResult {
    private String fullName;
    private String alterEgos;
    private String placeOfBirth;
    private String publisher;
    private String firstAppearance;

}
