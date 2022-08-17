package com.tinqin.project.heroClient.model;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    public int id;
    public String name;
    public String slug;
    public Powerstats powerstats;
    public Appearance appearance;
    public Biography biography;
    public Work work;
    public Connections connections;
    public Images images;
}
