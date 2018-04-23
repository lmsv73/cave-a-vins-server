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

    public Bottle(User owner, BottleType type, Compartment compartment, int nbBottles, String photoUrl) {
        this.setOwner(owner);
        this.setCompartment(compartment);
        this.setType(type);
        this.nbBottles = nbBottles;
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
                Objects.equals(this.photoUrl, bottle.photoUrl) &&
                Objects.equals(this.owner, bottle.owner) &&
                Objects.equals(this.type, bottle.type) &&
                Objects.equals(this.compartment, bottle.compartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, photoUrl, owner, type, compartment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bottle {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
