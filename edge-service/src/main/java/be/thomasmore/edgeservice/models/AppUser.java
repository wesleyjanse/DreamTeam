package be.thomasmore.edgeservice.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Alle details over de user.")
public class AppUser {
    @ApiModelProperty(notes="Het id van de user, niet gegenereerd door de DB")
    private Integer id;
    @ApiModelProperty(notes="De naam van de user")
    private String username;
    @ApiModelProperty(notes="Het wachtwoord van de user")
    private String password;
    @ApiModelProperty(notes="De rol van de user")
    private String  role;

    public AppUser() {
    }

    public AppUser(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // getters and setters ....

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}