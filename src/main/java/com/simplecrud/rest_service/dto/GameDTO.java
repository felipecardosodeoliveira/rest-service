package com.simplecrud.rest_service.dto;

import com.simplecrud.rest_service.entities.Game;
import org.springframework.beans.BeanUtils;

public class GameDTO {
    private Long id;
    private String title;
    private int year;
    private String score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {}

    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getScore() {
        return score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
