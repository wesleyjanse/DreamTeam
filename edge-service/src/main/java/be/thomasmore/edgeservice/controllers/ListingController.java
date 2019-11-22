package be.thomasmore.edgeservice.controllers;

import be.thomasmore.edgeservice.security.JwtConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.thomasmore.edgeservice.models.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private final JwtConfig jwtConfig;

    public ListingController(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @GetMapping("/allDreamTeams")
    public List<DreamTeam> getAllDreamTeams() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://dream-teams-service/dreamTeams", GenericResponseWrapper.class);

        List<DreamTeam> dreamTeams = objectMapper.convertValue(wrapper.get_embedded().get("dreamTeams"), new TypeReference<List<DreamTeam>>() { });

        return dreamTeams;
    }

       /*
    Dreamteam opvragen via userId
     */

    @GetMapping("/dreamteams/{id}")
    public DreamTeam getDreamteamByUserId(@PathVariable Integer id) {
        return restTemplate.getForObject("http://dream-teams-service/dreamTeams/search/findDreamTeamByUserId?userid=" + id, DreamTeam.class);
    }


     /*
    Dreamteam toevoegen
     */

    @PostMapping("/dreamteams")
    public ResponseEntity<String> postDreamteam(@RequestBody DreamTeam dreamTeam){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        ResponseEntity<DreamTeam> result = restTemplate.postForEntity(
                "http://dream-teams-service/dreamTeams/", dreamTeam, DreamTeam.class
        );

        return ResponseEntity.ok().build();
    }

    /*
    Lijst opvragen met alle favoriete spelers
     */

    @GetMapping("/allFavorieteSpelers")
    public List<FavorieteSpeler> getAllFavorieteSpelers() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://favoriete-speler-service/favorieteSpelers", GenericResponseWrapper.class);

        List<FavorieteSpeler> favorieteSpelers = objectMapper.convertValue(wrapper.get_embedded().get("favorieteSpelers"), new TypeReference<List<FavorieteSpeler>>() { });

        return favorieteSpelers;
    }

    /*
    Favoriete speler opvragen via id
     */

    @GetMapping("/favorieteSpeler/{id}")
    public FavorieteSpeler getFavorieteSpelerById(@PathVariable String id) {
        FavorieteSpeler favorieteSpeler = restTemplate.getForObject("http://favoriete-speler-service/favorieteSpelers/search/findFavorieteSpelerById?id=" + id, FavorieteSpeler.class);

        return favorieteSpeler;
    }

    /*
    Favoriete speler toevoegen
     */

    @PostMapping("/favorieteSpelers")
    public ResponseEntity<String> postFavorieteSpelerById(@RequestBody FavorieteSpeler favorieteSpeler){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        ResponseEntity<FavorieteSpeler> result = restTemplate.postForEntity(
                "http://favoriete-speler-service/favorieteSpelers/", favorieteSpeler, FavorieteSpeler.class
        );

        return ResponseEntity.ok().build();
    }

    /*
    Favoriete speler wijzigen
     */

    @PutMapping("/favorieteSpeler/{id}")
    public ResponseEntity<String> putFavorieteSpeler(@PathVariable("id") String id, @RequestBody FavorieteSpeler favorieteSpeler){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        restTemplate.put("http://favoriete-speler-service/favorieteSpelers/" + id, favorieteSpeler, FavorieteSpeler.class);

        return ResponseEntity.ok().build();
    }

    /*
    Favoriete speler verwijderen
     */

    @DeleteMapping("/favorieteSpeler/{id}")
    public ResponseEntity deleteFavorieteSpeler(@PathVariable("id") String id){

        restTemplate.delete("http://favoriete-speler-service/favorieteSpelers/" + id);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUsername(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        Claims claims = Jwts.parser()
                .setSigningKey(jwtConfig.getSecret().getBytes())
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();

        return new ResponseEntity<String>("Hello " + username, HttpStatus.OK);
    }

    @GetMapping(value = "/admin")
    @ResponseBody
    public ResponseEntity<String> getAdminUsername(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        Claims claims = Jwts.parser()
                .setSigningKey(jwtConfig.getSecret().getBytes())
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();
        String id = claims.getId();

        return new ResponseEntity<String>("Hello administrator with name" + username + "  " + id, HttpStatus.OK);
    }
}
