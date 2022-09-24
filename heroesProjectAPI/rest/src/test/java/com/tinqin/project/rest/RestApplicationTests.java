package com.tinqin.project.rest;

import com.tinqin.project.heroClient.model.Appearance;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.appearance.HeroAppearanceRequest;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import com.tinqin.project.rest.controller.HeroController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
        HeroAppearanceRequest heroAppearanceRequest = new HeroAppearanceRequest(1L);
        when(heroClientService.getHeroById(1L))
                .thenReturn(Hero.builder().
                        appearance(Appearance.builder().
                        .build())
                        .)



    }
}
