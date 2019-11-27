package be.thomasmore.edgeservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Alle details over de speler")
public class Speler {
    @ApiModelProperty(notes="Het id van de speler")
    int id;
    @ApiModelProperty(notes="De naam van de speler")
    String naam;


}
