package com.brillicaservices.gurjas.firebasemoviessample.series;

public class SeriesModelView  {
    String name;
    Integer Release;
    String desc;
    Integer Rating;
   // int image;

    public SeriesModelView(String name, String desc, int Release, int Rating, int image) {

        this.name = name;
        this.desc = desc;
        this.Release = Release;
        this.Rating  = Rating;
       // this.image = image;
    }

    public SeriesModelView(String name1, int rat, String de, int rel) {
        this.name = name1;
        this.desc = String.valueOf(de);
        this.Release = rel;
        this.Rating = rat;

    }

    public SeriesModelView(){

    }

   // public int getImage() {
   //     return image;
    //}

    public int getRating() {
        return Rating;
    }

    public int getRelease() {
        return Release;
    }

    public String getdesc() {
        return desc;
    }

    public String getname() {
        return name;
    }

    public void setdesc(String desc) {
        this.desc = desc;
    }

   // public void setImage(int image) {
     //   this.image = image;
    //}

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public void setRelease(int Release) {
        this.Release = Release;
    }

    public void setname(String name) {
        this.name = name;
    }
}


