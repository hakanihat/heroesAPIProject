package com.tinqin.project;

import com.tinqin.project.heroClient.model.Appearance;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.appearance.HeroAppearanceRequest;
import com.tinqin.project.model.appearance.HeroAppearanceResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class HeroAppearanceProcessorCoreTest {

    @Mock
    private HeroClientService heroClientService;
    private AutoCloseable closeable;

    @InjectMocks
    private HeroAppearanceProcessorCore heroAppearanceProcessorCore;

    @BeforeEach
    void setUp(){
       closeable = MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testProcess() {
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


        assertNotNull(heroAppearanceProcessorCore.process(heroAppearanceRequest).get());
        assertEquals(heroAppearanceResponse,heroAppearanceProcessorCore.process(heroAppearanceRequest).get());
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }
}
