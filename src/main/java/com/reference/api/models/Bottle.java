package com.reference.api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private Long date = null;

    @Column(nullable = false)
    @JsonProperty("region")
    private String region = null;

    @Column(nullable = true)
    @JsonProperty("colour")
    private String colour = null;

    @Column(nullable = true)
    @ElementCollection(targetClass=String.class)
    @JsonProperty("photoUrls")
    @Valid
    private List<String> photoUrls = null;

    @OneToOne(targetEntity=User.class, fetch=FetchType.EAGER)
    @Type(type="user")
    @JsonProperty("owner")
    private User owner = null;

    @OneToOne(targetEntity=BottleType.class, fetch=FetchType.EAGER)
    @Type(type="bottletype")
    @JsonProperty("type")
    private BottleType type = null;

    @OneToOne(targetEntity=Compartment.class, fetch=FetchType.EAGER)
    @Type(type="compartment")
    @JsonProperty("compartment")
    private Compartment compartment = null;

    public Bottle id(Long id) {
        this.id = id;
        return this;
    }

    public Bottle(Long date, String region, User owner, BottleType type, Compartment compartment) {
        this.date = date;
        this.setOwner(owner);
        this.region = region;
        this.setCompartment(compartment);
        this.setType(type);
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

    public Bottle date(Long date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     * @return date
     **/
    @ApiModelProperty(value = "")


    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
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

    public Bottle photoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public Bottle addPhotoUrlsItem(String photoUrlsItem) {
        if (this.photoUrls == null) {
            this.photoUrls = new ArrayList<String>();
        }
        this.photoUrls.add(photoUrlsItem);
        return this;
    }

    /**
     * Get photoUrls
     * @return photoUrls
     **/
    @ApiModelProperty(value = "")


    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
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
                Objects.equals(this.photoUrls, bottle.photoUrls) &&
                Objects.equals(this.owner, bottle.owner) &&
                Objects.equals(this.type, bottle.type) &&
                Objects.equals(this.compartment, bottle.compartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, region, colour, photoUrls, owner, type, compartment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bottle {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    colour: ").append(toIndentedString(colour)).append("\n");
        sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
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
