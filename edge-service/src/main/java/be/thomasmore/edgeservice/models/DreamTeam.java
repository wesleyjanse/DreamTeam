package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description="Alles details over het dreamteam.")
public class DreamTeam {
    @ApiModelProperty(notes="Het id van het dreamteam, gegenereerd door Mongo")
    private String id;
    @ApiModelProperty(notes="De naam van het dreamteam")
    private String naam;
    @ApiModelProperty(notes="Het userId waaraan het dreamteam verbonden is")
    private Integer userId;
    @ApiModelProperty(notes="De list van spelers in het dreamteam")
    private List<String> spelersId;

    public DreamTeam(String id, String naam, Integer userId, List<String> spelersId) {
        this.id = id;
        this.userId = userId;
        this.spelersId = spelersId;
        this.naam = naam;
    }

    public DreamTeam() {
    }

    public String getNaam() { return naam; }

    public void setNaam(String naam) { this.naam = naam; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<String> getSpelersId() {
        return spelersId;
    }

    public void setSpelersId(List<String> spelersId) {
        this.spelersId = spelersId;
    }
}
