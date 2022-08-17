package com.tinqin.project.heroClient.service;

import com.tinqin.project.heroClient.exception.HeroClientException;
import com.tinqin.project.heroClient.model.Hero;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HeroClientService {
    private final RestTemplate restTemplate;

    public HeroClientService() {
        this.restTemplate = new RestTemplate();
    }

    public Hero getHeroById(Long id) {
        final String uri = "https://akabab.github.io/superhero-api/api/id/" + id + ".json";
        try{
            return restTemplate.getForObject(uri,Hero.class);
        }catch (Exception e){
            throw new HeroClientException();
        }
    }
    }
