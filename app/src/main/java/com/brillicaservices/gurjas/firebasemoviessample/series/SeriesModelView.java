package com.brillicaservices.gurjas.firebasemoviessample.series;

import java.util.Collection;

public class SeriesModelView  {
    String title;
    Integer[] releaseYear;
    String description;
    Integer[] rating;
    int image;

    public SeriesModelView(String title, String description, Integer[] releaseYear, Integer[] rating, int image) {

        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rating  = rating;
        this.image = image;
    }

    public SeriesModelView(String[] title1, Integer[] rat, String[] de, Integer[] rel) {
        this.title = String.valueOf(title1);
        this.description = String.valueOf(de);
        this.releaseYear = rel;
        this.rating = rat;

    }

    public int getImage() {
        return image;
    }

    public Integer[] getRating() {
        return rating;
    }

    public Integer[] getReleaseYear() {
        return releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setRating(Integer[] rating) {
        this.rating = rating;
    }

    public void setReleaseYear(Integer[] releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


