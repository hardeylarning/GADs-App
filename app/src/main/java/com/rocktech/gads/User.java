package com.rocktech.gads;

import com.google.gson.annotations.SerializedName;

public class User {
    private String name;
    private String country;

    @SerializedName("score")
    private int hours;

    @SerializedName("badgeUrl")
    private String url;

    public User(String name, int hours, String url, String country) {
        this.name = name;
        this.hours = hours;
        this.url = url;
        this.country = country;
    }

    public User(String name, int hours, String country) {
        this.name = name;
        this.hours = hours;
        this.country = country;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", url='" + url + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }


    public int getHours() {
        return hours;
    }

    public String getUrl() {
        return url;
    }
    public String getCountry() {
        return country;
    }
}
