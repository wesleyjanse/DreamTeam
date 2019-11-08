package be.thomasmore.edgeservice.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.thomasmore.edgeservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/allDreamTeams")
    public List<DreamTeam> getAllDreamTeams() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://dream-teams-service/dreamTeams", GenericResponseWrapper.class);

        List<DreamTeam> dreamTeams = objectMapper.convertValue(wrapper.get_embedded().get("dreamTeams"), new TypeReference<List<DreamTeam>>() { });

        return dreamTeams;
    }

    @GetMapping("/allFavorieteSpelers")
    public List<FavorieteSpeler> getAllFavorieteSpelers() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://favoriete-speler-service/favorieteSpelers", GenericResponseWrapper.class);

        List<FavorieteSpeler> favorieteSpelers = objectMapper.convertValue(wrapper.get_embedded().get("favorieteSpelers"), new TypeReference<List<FavorieteSpeler>>() { });

        return favorieteSpelers;
    }




}
