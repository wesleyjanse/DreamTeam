package be.thomasmore.edgeservice.models;

import lombok.Data;

@Data
public class ListingItem {
    private String title;
    private Integer userId;
    private Integer score;

    public ListingItem() {
    }

    public ListingItem(String title, Integer score) {
        this.title = title;
        this.score = score;
    }

    public ListingItem(String title, Integer score, Integer userId) {
        this.title = title;
        this.score = score;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
