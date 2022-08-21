package com.tinqin.project.model.biography;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroBiographyRequest implements OperationInput {
    private Long heroId;
}
