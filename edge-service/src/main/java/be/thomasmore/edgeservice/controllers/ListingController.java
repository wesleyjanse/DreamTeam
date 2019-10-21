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

    @GetMapping("user/{userId}")
    public List<ListingItem> getListingItemsByUserId(@PathVariable("userId") Integer userId) {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://rating-service/ratings/search/findRatingsByUserId?userid=" + userId, GenericResponseWrapper.class);

        List<Rating> ratings = objectMapper.convertValue(wrapper.get_embedded().get("ratings"), new TypeReference<List<Rating>>() { });

        List<ListingItem> returnList = new ArrayList<>();
        for (Rating rating: ratings) {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            returnList.add(new ListingItem(movie.getTitle(), rating.getScoreNumber()));
        }
        return returnList;
    }

    @GetMapping("movie/{title}")
    public List<ListingItem> getListingItemsByMovieTitle(@PathVariable("title") String title){

        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/search/findMovieByTitle?title=" + title, Movie.class);

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://rating-service/ratings/search/findRatingsByMovieId?movieid=" + movie.getId(), GenericResponseWrapper.class);

        List<Rating> ratings = objectMapper.convertValue(wrapper.get_embedded().get("ratings"), new TypeReference<List<Rating>>() { });

        List<ListingItem> returnList = new ArrayList<>();
        for (Rating rating: ratings) {
            returnList.add(new ListingItem(movie.getTitle(), rating.getScoreNumber(), rating.getUserId()));
        }
        return returnList;
    }

    @GetMapping("user/{userId}/movie/{title}")
    public ListingItem getListingItemsByUserIdAndMovieTitle(@PathVariable("userId") Integer userId, @PathVariable("title") String title){

        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/search/findMovieByTitle?title=" + title, Movie.class);

        Rating rating = restTemplate.getForObject("http://rating-service/ratings/search/findRatingByUserIdAndMovieId?userid=" + userId + "&movieid=" + movie.getId(), Rating.class);

        ListingItem listingItem = new ListingItem(movie.getTitle(), rating.getScoreNumber());
        return listingItem;

    }

    @PostMapping("user/{userId}")
    public ResponseEntity<String> postListingItemsByUserId(@PathVariable("userId") Integer userId, @RequestBody ListingItem listingItem){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/search/findMovieByTitle?title=" + listingItem.getTitle(), Movie.class);

        Rating rating = new Rating(userId, movie.getId() , listingItem.getScore());

        ResponseEntity<String> result = restTemplate.postForEntity("http://rating-service/ratings/", rating, String.class);
        return ResponseEntity.ok().build();
    }

    @PutMapping("user/{userId}")
    public ResponseEntity<String> putListingItemsByUserId(@PathVariable("userId") Integer userId, @RequestBody ListingItem listingItem){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/search/findMovieByTitle?title=" + listingItem.getTitle(), Movie.class);

        Rating rating = restTemplate.getForObject("http://rating-service/ratings/search/findRatingByUserIdAndMovieId?userid=" + userId + "&movieid=" + movie.getId(), Rating.class);
        rating.setScoreNumber(listingItem.getScore());

        restTemplate.put("http://rating-service/ratings/" + rating.getId(), rating, String.class);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("user/{userId}/movie/{title}")
    public ResponseEntity deleteListingItemsByUserIdAndMovieTitle(@PathVariable("userId") Integer userId, @PathVariable("title") String title){

        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/search/findMovieByTitle?title=" + title, Movie.class);

        Rating rating = restTemplate.getForObject("http://rating-service/ratings/search/findRatingByUserIdAndMovieId?userid=" + userId + "&movieid=" + movie.getId(), Rating.class);

        restTemplate.delete("http://rating-service/ratings/" + rating.getId());

        return ResponseEntity.ok().build();
    }

}
