package com.example.popularmovie;

public class Movie {
    private String title ;
    private String poster ;
    private Double rating ;
    private String overview ;

    public Movie(String title, String poster, Double rating, String overview){
        this.title = title ;
        this.poster = poster ;
        this.rating = rating ;
        this.overview = overview ;
    }

    public String getTitle() {
        return title ;
    }

    public String getPoster() {
        return  poster ;
    }

    public Double getRating() {
        return rating ;
    }

    public String getOverview() {
        return overview ;
    }
}
