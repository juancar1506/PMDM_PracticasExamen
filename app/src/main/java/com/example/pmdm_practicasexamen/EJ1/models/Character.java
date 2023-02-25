package com.example.pmdm_practicasexamen.EJ1.models;

import com.google.gson.annotations.SerializedName;

import java.time.OffsetDateTime;

public class Character {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private Status status;

    @SerializedName("species")
    private String species;

    @SerializedName("type")
    private String type;

    @SerializedName("gender")
    private Gender gender;

    @SerializedName("origin")
    private Location origin;

    @SerializedName("location")
    private Location location;

    @SerializedName("image")
    private String image;

    @SerializedName("episode")
    private String[] episode;

    @SerializedName("url")
    private String url;

    @SerializedName("created")
    private OffsetDateTime created;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Status getStatus() { return status; }
    public void setStatus(Status value) { this.status = value; }

    public String getSpecies() { return species; }
    public void setSpecies(String value) { this.species = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public Gender getGender() { return gender; }
    public void setGender(Gender value) { this.gender = value; }

    public Location getOrigin() { return origin; }
    public void setOrigin(Location value) { this.origin = value; }

    public Location getLocation() { return location; }
    public void setLocation(Location value) { this.location = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public String[] getEpisode() { return episode; }
    public void setEpisode(String[] value) { this.episode = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public OffsetDateTime getCreated() { return created; }
    public void setCreated(OffsetDateTime value) { this.created = value; }
}
