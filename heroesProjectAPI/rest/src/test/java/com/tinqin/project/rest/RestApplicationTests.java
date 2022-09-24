package com.tinqin.project.rest;

import com.tinqin.project.heroClient.model.Appearance;
import com.tinqin.project.heroClient.model.Biography;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.appearance.HeroAppearanceRequest;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import com.tinqin.project.model.biography.HeroBiographyRequest;
import com.tinqin.project.model.biography.HeroBiographyResponse;
import com.tinqin.project.rest.controller.HeroController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class RestApplicationTests {

    @Autowired
    private HeroController heroController;

    @MockBean
    private HeroClientService heroClientService;

    @Test
    public void testGetHeroAppearance() {
        ArrayList<String> hei = new ArrayList<>();
        ArrayList<String> wei = new ArrayList<>();
        hei.add("70.86");
        hei.add("180");
        wei.add("165.34");
        wei.add("75");
        HeroAppearanceRequest heroAppearanceRequest = new HeroAppearanceRequest(1L);

        when(heroClientService.getHeroById(1L))
                .thenReturn(Hero.builder().
                        appearance(Appearance.builder()
                                .race("Human")
                                .height(hei)
                                .weight(wei)
                                .eyeColor("Blue")
                                .hairColor("Blonde")
                                .build())
                        .build());

        HeroAppearanceResponse heroAppearanceResponse = HeroAppearanceResponse.builder()
                .race("Human")
                .heightInCm("180")
                .WeightInKg("75")
                .eyeColor("Blue")
                .hairColor("Blonde")
                .build();

        ResponseEntity<HeroAppearanceResponse> response = ResponseEntity.ok(heroAppearanceResponse);

        Assertions.assertEquals(response,heroController.getHeroAppearance(heroAppearanceRequest));
    }

    @Test
    public void testGetHeroBiography(){

        HeroBiographyRequest heroBiographyRequest = new HeroBiographyRequest(1L);

        when(heroClientService.getHeroById(1L))
                .thenReturn(Hero.builder()
                        .biography(Biography.builder()
                                .fullName("Richard Milhouse Jones")
                                .alterEgos("No")
                                .firstAppearance("Hulk vol 2")
                                .publisher("Marvel comics")
                                .placeOfBirth("Scarsdale, Arizona")
                                .build())
                        .build());

        HeroBiographyResponse heroBiographyResponse = HeroBiographyResponse.builder()
                .fullName("Richard Milhouse Jones")
                .alterEgos("No")
                .firstAppearance("Hulk vol 2")
                .publisher("Marvel comics")
                .placeOfBirth("Scarsdale, Arizona")
                .build();

        ResponseEntity<HeroBiographyResponse> response = ResponseEntity.ok(heroBiographyResponse);

        Assertions.assertEquals(response, heroController.getHeroBiography(heroBiographyRequest));
    }

}
