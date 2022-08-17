package com.tinqin.project.heroClient.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Powerstats {
    public int intelligence;
    public int strength;
    public int speed;
    public int durability;
    public int power;
    public int combat;
}
