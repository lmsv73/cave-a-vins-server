package com.reference.api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Compartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id = null;

    @Column(nullable = false)
    @JsonProperty("name")
    private String name = null;

    @Column(nullable = true)
    @JsonProperty("photoUrls")
    @Valid
    private String photoUrl = null;

    @ManyToOne(targetEntity = User.class)
    private User owner;



    protected Compartment () {

    }
    public Compartment (String name, User user) {
        this.name = name;
        this.owner = user;

    }

    public Compartment id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @ApiModelProperty(value = "")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compartment name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @ApiModelProperty(value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Compartment photoUrl( String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    /**
     * Get photoUrls
     * @return photoUrls
     **/
    @ApiModelProperty(value = "")


    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public Compartment setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Compartment compartment = (Compartment) o;
        return Objects.equals(this.id, compartment.id) &&
                Objects.equals(this.name, compartment.name) &&
                Objects.equals(this.photoUrl, compartment.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photoUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Compartment {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    photoUrls: ").append(toIndentedString(photoUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
