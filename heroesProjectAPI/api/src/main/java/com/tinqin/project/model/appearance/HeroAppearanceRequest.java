package com.tinqin.project.model.appearance;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroAppearanceRequest implements OperationInput {
    private Long heroId;
}
