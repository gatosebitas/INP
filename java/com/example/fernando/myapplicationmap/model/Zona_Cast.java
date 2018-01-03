package com.example.fernando.myapplicationmap.model;


public class Zona_Cast {
    private String id;
    private Double lat;
    private Double longitud;
    private  int primaryColor;
    private Double radius;
    private int secondColor;;
    private String subtitle;
    private String title;





public Zona_Cast(){

}

    public Zona_Cast(String id, Double lat, Double longitud, int primaryColor, Double radius, int secondColor, String subtitle, String title) {
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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(int primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public int getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(int secondColor) {
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
