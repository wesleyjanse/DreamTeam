package be.thomasmore.edgeservice.controllers;

import be.thomasmore.edgeservice.security.JwtConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.thomasmore.edgeservice.models.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/allFavorieteSpelers")
    public List<FavorieteSpeler> getAllFavorieteSpelers() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://favoriete-speler-service/favorieteSpelers", GenericResponseWrapper.class);

        List<FavorieteSpeler> favorieteSpelers = objectMapper.convertValue(wrapper.get_embedded().get("favorieteSpelers"), new TypeReference<List<FavorieteSpeler>>() { });

        return favorieteSpelers;
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

        return new ResponseEntity<String>("Hello administrator with name" + username, HttpStatus.OK);
    }
}
