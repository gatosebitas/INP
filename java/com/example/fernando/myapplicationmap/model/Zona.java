package com.example.fernando.myapplicationmap.model;


public class Zona {
    private String id;
    private String lat;
    private String longitud;
    private String primaryColor;
    private String radius;
    private String secondColor;;
    private String subtitle;
    private String title;





public Zona(){

}

    public Zona(String id, String lat, String longitud, String primaryColor, String radius, String secondColor, String subtitle, String title) {
        this.id = id;
        this.lat = lat;
        this.longitud = longitud;
        this.primaryColor = primaryColor;
        this.radius = radius;
        this.secondColor = secondColor;
        this.subtitle = subtitle;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
