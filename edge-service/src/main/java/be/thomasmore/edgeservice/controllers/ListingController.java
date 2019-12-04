package be.thomasmore.edgeservice.controllers;

import be.thomasmore.edgeservice.security.JwtConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.thomasmore.edgeservice.models.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
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
@Api(value="Dreamteam CRUD systeem", description="Alle operaties die te maken hebben met het maken van een dreamteam.")
public class ListingController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private final JwtConfig jwtConfig;

    public ListingController(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @GetMapping("/appUsers/{id}")
    @ApiOperation(value="Haal de user op waar het id=UserId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "De user werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    public AppUser getAppUserById(@ApiParam(value = "Het id van de op te halen user", required = true)@PathVariable Integer id) {
        return restTemplate.getForObject("http://user-service/appUsers/search/findAppUserById?id=" + id, AppUser.class);
    }

    /*
     * Get all dreamteams
     * */
    @ApiOperation(value="Haal alle dreamteams op van de users met spelers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "De dreamteams werden succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @GetMapping("/allDreamTeamsWithUsers")
    public List<DreamteamsMetSpelersMetUsers> getAllDreamTeamsWithPlayersWithUsers() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://dream-teams-service/dreamTeams", GenericResponseWrapper.class);

        List<DreamTeam> dreamTeams = objectMapper.convertValue(wrapper.get_embedded().get("dreamTeams"), new TypeReference<List<DreamTeam>>() { });
        List<DreamteamsMetSpelersMetUsers> returnList = new ArrayList<>();

        for (DreamTeam team: dreamTeams)
        {
            List<FavorieteSpeler> spelers = new ArrayList<>();
            for (String spelerId: team.getSpelersId()){
                if (spelerId != ""){
                    FavorieteSpeler speler = this.getFavorieteSpelerById(spelerId);
                    spelers.add(speler);
                }else{
                    spelers.add(new FavorieteSpeler(null, "Niemand geselecteerd", team.getUserId(), "",  "../../../assets/defaultPlayer.png"));
                }
            }

            AppUser user = this.getAppUserById(team.getUserId());

            returnList.add(new DreamteamsMetSpelersMetUsers(team, spelers, user));
        }

        return returnList;
    }

     /*
        Delete dreamteam
     */
    @ApiOperation(value="Verwijder het dreamteam verbonden met het opgegeven Id")
    @DeleteMapping("/dreamTeam/{id}")
    public ResponseEntity deleteDreamTeam(@ApiParam(value = "Het id van het te verwijderen dreamteam", required = true)@PathVariable("id") String id){

        restTemplate.delete("http://dream-teams-service/dreamTeams/" + id);
        return ResponseEntity.ok().build();
    }


    /*
    * Get all dreamteams
    * */
    @ApiOperation(value="Haal alle dreamteams op uit de database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "De dreamteams werden succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @GetMapping("/allDreamTeams")
    public List<DreamTeam> getAllDreamTeams() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://dream-teams-service/dreamTeams", GenericResponseWrapper.class);

        List<DreamTeam> dreamTeams = objectMapper.convertValue(wrapper.get_embedded().get("dreamTeams"), new TypeReference<List<DreamTeam>>() { });

        return dreamTeams;
    }

       /*
    Dreamteam opvragen via userId
     */
       @ApiOperation(value="Haal het dreamteam op verbonden met het opgegeven Id", response = DreamTeam.class)
       @ApiResponses(value = {
               @ApiResponse(code = 200, message = "Het dreamteam werd succesvol opgehaald"),
               @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
               @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
               @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
       })
    @GetMapping("/dreamteams/{id}")
    public DreamTeam getDreamteamByUserId(@ApiParam(value = "Het id van het op te halen dreamteam", required = true)@PathVariable Integer id) {

        return restTemplate.getForObject("http://dream-teams-service/dreamTeams/search/findDreamTeamByUserId?userid=" + id, DreamTeam.class);
    }

        /*
    Dreamteam opvragen via userId met Spelers
     */
        @ApiOperation(value="Haal het dreamteam op verbonden met het opgegeven userId en voeg de spelers er aan toe", response = List.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Het dreamteam met spelers werd succesvol opgehaald"),
                @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
                @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
                @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
        })
    @GetMapping("/getDreamteamWithPlayers/{id}")
    public DreamteamMetSpelers getDreamteamWithPlayersByUserId(@ApiParam(value = "Het userId waaraan het dreamteam verbonden is", required = true)@PathVariable Integer id) {

        DreamTeam dreamTeam = restTemplate.getForObject("http://dream-teams-service/dreamTeams/search/findDreamTeamByUserId?userid=" + id, DreamTeam.class);
        List<FavorieteSpeler> spelers = new ArrayList<>();

        for (String spelerId: dreamTeam.getSpelersId()){
            if (spelerId != ""){
                FavorieteSpeler speler = this.getFavorieteSpelerById(spelerId);
                spelers.add(speler);
            }else{
                spelers.add(new FavorieteSpeler(null, "Niemand geselecteerd", dreamTeam.getUserId(), "",  "../../../assets/defaultPlayer.png"));
            }
        }
        return new DreamteamMetSpelers(dreamTeam, spelers);
    }

    /*
    Dreamteam wijzigen
     */
    @ApiOperation(value="Het dreamteam met id=id aanpassen met de aanpassingen in het meegegeven dreamteam object")
    @PutMapping("/updateDreamteam/{id}")
    public ResponseEntity<String> updateDreamteam(
            @ApiParam(value = "Het dreamteamId om het dreamteam te updaten", required = true)@PathVariable("id") String id,
            @ApiParam(value = "Het update dreamteam object", required = true) @RequestBody DreamTeam dreamTeam){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        restTemplate.put("http://dream-teams-service/dreamTeams/" + id, dreamTeam, DreamTeam.class);

        return ResponseEntity.ok().build();
    }

     /*
    Dreamteam toevoegen
     */
     @ApiOperation(value="Een dreamteam toevoegen")
    @PostMapping("/dreamteams")
    public ResponseEntity<String> postDreamteam(@ApiParam(value = "Het nieuwe dreamteam object om in de db op te slaan", required = true)@RequestBody DreamTeam dreamTeam){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        ResponseEntity<DreamTeam> result = restTemplate.postForEntity(
                "http://dream-teams-service/dreamTeams/", dreamTeam, DreamTeam.class
        );

        return ResponseEntity.ok().build();
    }


       /*
    favorietespelers opvragen via userId
     */
       @ApiOperation(value="Haal de favoriete spelers op verbonden met het opgegeven userId", response = List.class)
       @ApiResponses(value = {
               @ApiResponse(code = 200, message = "De favoriete spelers werden succesvol opgehaald"),
               @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
               @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
               @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
       })
    @GetMapping("/getAllFavorieteSpelersById/{userId}")
    public List<FavorieteSpeler> getAllFavorieteSpelersById(@ApiParam(value = "Het userId waaraan de favoriete spelers verbonden zijn", required = true)@PathVariable("userId") Integer userId) {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://favoriete-speler-service/favorieteSpelers/search/findFavorieteSpelersByUserId?userId=" + userId, GenericResponseWrapper.class);
        List<FavorieteSpeler> favorieteSpelers = objectMapper.convertValue(wrapper.get_embedded().get("favorieteSpelers"), new TypeReference<List<FavorieteSpeler>>() { });
        return favorieteSpelers;
    }

    /*
    Lijst opvragen met alle favoriete spelers
     */
    @ApiOperation(value="Haal alle favoriete spelers op uit de database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "De favoriete spelers werden succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @GetMapping("/allFavorieteSpelers")
    public List<FavorieteSpeler> getAllFavorieteSpelers() {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://favoriete-speler-service/favorieteSpelers", GenericResponseWrapper.class);

        List<FavorieteSpeler> favorieteSpelers = objectMapper.convertValue(wrapper.get_embedded().get("favorieteSpelers"), new TypeReference<List<FavorieteSpeler>>() { });

        return favorieteSpelers;
    }

    /*
    Favoriete speler opvragen via id
     */
    @ApiOperation(value="Haal de favoriete speler op met het opgegeven Id", response = FavorieteSpeler.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "De favoriete speler werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de bron die u probeerde te bereiken is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })

    @GetMapping("/favorieteSpeler/{id}")
    public FavorieteSpeler getFavorieteSpelerById(@ApiParam(value = "Het id van de op te vragen favoriete speler", required = true)@PathVariable String id) {
        FavorieteSpeler favorieteSpeler = restTemplate.getForObject
                ("http://favoriete-speler-service/favorieteSpelers/search/findFavorieteSpelerById?id=" + id, FavorieteSpeler.class);
        return favorieteSpeler;
    }

    /*
    Favoriete speler toevoegen
     */
    @ApiOperation(value="Een favoriete speler toevoegen")
    @PostMapping("/favorieteSpelers")
    public ResponseEntity<String> postFavorieteSpelerById(@ApiParam(value = "Het nieuwe favoriete speler object om in de db op te slaan", required = true)@RequestBody FavorieteSpeler favorieteSpeler){

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
    @ApiOperation(value="De favoriete speler met id=id, wijzigen met het aangepaste favorieteSpeler object")
    @PutMapping("/favorieteSpeler/{id}")
    public ResponseEntity<String> putFavorieteSpeler(
            @ApiParam(value = "Het favorieteSpelerId om de favoriete speler te updaten", required = true)@PathVariable("id") String id,
            @ApiParam(value = "Het update favorieteSpeler object", required = true)@RequestBody FavorieteSpeler favorieteSpeler){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        restTemplate.put("http://favoriete-speler-service/favorieteSpelers/" + id, favorieteSpeler, FavorieteSpeler.class);

        return ResponseEntity.ok().build();
    }

    /*
    Favoriete speler verwijderen
     */
    @ApiOperation(value="Verwijder de favorieteSpeler verbonden met het opgegeven Id")
    @DeleteMapping("/favorieteSpeler/{id}/{userId}")
    public ResponseEntity deleteFavorieteSpeler(@ApiParam(value = "Het id van de te verwijderen favorieteSpeler", required = true)@PathVariable("id") String id, @PathVariable("userId") Integer userId){

        DreamTeam team = this.getDreamteamByUserId(userId);

        List<String> spelers = team.getSpelersId();
        List<String> keepSpelers = new ArrayList<>();
        for (String spelerId: spelers) {
            if (spelerId.equals(id)){
                keepSpelers.add("");
            } else{
                keepSpelers.add(spelerId);
            }
        }


        this.updateDreamteam(team.getId(), new DreamTeam(team.getId(), team.getNaam(), team.getUserId(), keepSpelers));
        restTemplate.delete("http://favoriete-speler-service/favorieteSpelers/" + id);

        return ResponseEntity.ok().build();
    }


   /* Authenticatie probeer methodes, niet nuttig in de eindapplicatie */
//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<String> getUsername(@RequestHeader("Authorization") String token) {
//        token = token.substring(7);
//        Claims claims = Jwts.parser()
//                .setSigningKey(jwtConfig.getSecret().getBytes())
//                .parseClaimsJws(token)
//                .getBody();
//
//        String username = claims.getSubject();
//
//        return new ResponseEntity<String>("Hello " + username, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/admin")
//    @ResponseBody
//    public ResponseEntity<String> getAdminUsername(@RequestHeader("Authorization") String token) {
//        token = token.substring(7);
//        Claims claims = Jwts.parser()
//                .setSigningKey(jwtConfig.getSecret().getBytes())
//                .parseClaimsJws(token)
//                .getBody();
//
//        String username = claims.getSubject();
//        String id = claims.getId();
//
//        return new ResponseEntity<String>("Hello administrator with name" + username + "  " + id, HttpStatus.OK);
//    }
}
