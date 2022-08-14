package com.tinqin.project.heroClient.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    public String occupation;
    public String base;
}
