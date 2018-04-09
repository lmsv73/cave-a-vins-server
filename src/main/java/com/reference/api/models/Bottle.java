package com.reference.api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Objects;
@Proxy(lazy = false)
@Entity
@TypeDefs({
        @TypeDef(
                name = "user",
                defaultForType = User.class,
                typeClass = User.class
        ),
        @TypeDef(
                name = "compartment",
                defaultForType = Compartment.class,
                typeClass = Compartment.class
        ),
        @TypeDef(
                name="bottletype",
                defaultForType = BottleType.class,
                typeClass = BottleType.class
        )
}

)

public class Bottle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id = null;

    @Column(nullable = false)
    @JsonProperty("date")
    private int date = 0;

    @Column(nullable = false)
    @JsonProperty("region")
    private String region = null;

    @Column(nullable = true)
    @JsonProperty("colour")
    private String colour = null;

    @ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
    @Type(type="user")
    @JsonProperty("owner")
    private User owner = null;

    @ManyToOne(targetEntity=BottleType.class, fetch=FetchType.EAGER)
    @Type(type="bottletype")
    @JsonProperty("type")
    private BottleType type = null;

    @ManyToOne(targetEntity=Compartment.class, fetch=FetchType.EAGER)
    @Type(type="compartment")
    @JsonProperty("compartment")
    private Compartment compartment = null;

    @Column(nullable = true)
    @JsonProperty("nbBottles")
    private int nbBottles;

    @Column(nullable = true)
    @JsonProperty("photoUrl")
    @Valid
    private String photoUrl = null;

    public int getNbBottles() {
        return nbBottles;
    }

    public void setNbBottles(int nbBottles) {
        this.nbBottles = nbBottles;
    }

    public Bottle id(Long id) {
        this.id = id;
        return this;
    }

    public Bottle(int date, String region, User owner, BottleType type, Compartment compartment, int nbBottles,String colour, String photoUrl) {
        this.date = date;
        this.setOwner(owner);
        this.region = region;
        this.setCompartment(compartment);
        this.setType(type);
        this.nbBottles = nbBottles;
        this.colour = colour;
        this.photoUrl = photoUrl;

    }


    protected Bottle() {

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

    public Bottle date(int date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     * @return date
     **/
    @ApiModelProperty(value = "")


    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Bottle region(String region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     * @return region
     **/
    @ApiModelProperty(value = "")


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Bottle colour(String colour) {
        this.colour = colour;
        return this;
    }

    /**
     * Get colour
     * @return colour
     **/
    @ApiModelProperty(value = "")


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Get photoUrl
     * @return photoUrl
     **/
    @ApiModelProperty(value = "")


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Bottle owner(User owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Get owner
     * @return owner
     **/
    @ApiModelProperty(value = "")

    @Valid

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Bottle type(BottleType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @ApiModelProperty(value = "")

    @Valid

    public BottleType getType() {
        return type;
    }

    public void setType(BottleType type) {
        this.type = type;
    }

    public Bottle compartment(Compartment compartment) {
        this.compartment = compartment;
        return this;
    }

    /**
     * Get compartment
     * @return compartment
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Compartment getCompartment() {
        return compartment;
    }

    public void setCompartment(Compartment compartment) {
        this.compartment = compartment;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bottle bottle = (Bottle) o;
        return Objects.equals(this.id, bottle.id) &&
                Objects.equals(this.date, bottle.date) &&
                Objects.equals(this.region, bottle.region) &&
                Objects.equals(this.colour, bottle.colour) &&
                Objects.equals(this.photoUrl, bottle.photoUrl) &&
                Objects.equals(this.owner, bottle.owner) &&
                Objects.equals(this.type, bottle.type) &&
                Objects.equals(this.compartment, bottle.compartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, region, colour, photoUrl, owner, type, compartment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bottle {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    colour: ").append(toIndentedString(colour)).append("\n");
        sb.append("    photoUrl: ").append(toIndentedString(photoUrl)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    compartment: ").append(toIndentedString(compartment)).append("\n");
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
