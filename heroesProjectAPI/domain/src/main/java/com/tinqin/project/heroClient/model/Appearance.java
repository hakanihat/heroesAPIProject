package com.tinqin.project.heroClient.model;

import lombok.*;

import java.util.ArrayList;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Appearance {
    public String gender;
    public String race;
    public ArrayList<String> height;
    public ArrayList<String> weight;
    public String eyeColor;
    public String hairColor;
}
