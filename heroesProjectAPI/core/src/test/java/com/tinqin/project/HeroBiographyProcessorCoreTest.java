package com.tinqin.project;

import com.tinqin.project.heroClient.model.Biography;
import com.tinqin.project.heroClient.model.Hero;
import com.tinqin.project.heroClient.service.HeroClientService;
import com.tinqin.project.model.biography.HeroBiographyRequest;
import com.tinqin.project.model.biography.HeroBiographyResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class HeroBiographyProcessorCoreTest {

    @Mock
    private HeroClientService heroClientService;
    private  AutoCloseable closeable;

    @InjectMocks
    private HeroBiographyProcessorCore heroBiographyProcessorCore;

    @BeforeEach
    void setUp(){closeable = MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testProcess() {
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


        assertNotNull(heroBiographyProcessorCore.process(heroBiographyRequest).get());
        assertEquals(heroBiographyResponse, heroBiographyProcessorCore.process(heroBiographyRequest).get());
    }

    @AfterEach
    void closeService() throws Exception{
        closeable.close();
    }
}
