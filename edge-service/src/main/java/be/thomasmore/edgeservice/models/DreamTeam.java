package be.thomasmore.edgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DreamTeam {
    private String id;
    private Integer userId;
    private List<Integer> spelersId;

    public DreamTeam(String id, Integer userId, List<Integer> spelersId) {
        this.id = id;
        this.userId = userId;
        this.spelersId = spelersId;
    }

    public DreamTeam() {
    }

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

    public List<Integer> getSpelersId() {
        return spelersId;
    }

    public void setSpelersId(List<Integer> spelersId) {
        this.spelersId = spelersId;
    }
}
