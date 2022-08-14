package com.tinqin.project.heroClient.model;

import lombok.*;

import java.util.ArrayList;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Biography {
    public String fullName;
    public String alterEgos;
    public ArrayList<String> aliases;
    public String placeOfBirth;
    public String firstAppearance;
    public String publisher;
    public String alignment;
}
