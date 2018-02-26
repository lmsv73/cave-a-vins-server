package com.reference.api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BottleType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id = null;

    @Column(nullable = false)
    @JsonProperty("name")
    private String name = null;

    @Column(nullable = false)
    @JsonProperty("valide")
    private Boolean valide = null;

    public BottleType id(Long id) {
        this.id = id;
        return this;
    }

    public BottleType(String name,Boolean valide) {
        this.name = name;
        this.valide = valide;
    }

    protected BottleType() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
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

    public BottleType name(String name) {
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

    public BottleType valide(Boolean valide) {
        this.valide = valide;
        return this;
    }

    /**
     * Get valide
     * @return valide
     **/
    @ApiModelProperty(value = "")


    public Boolean isValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BottleType bottleType = (BottleType) o;
        return Objects.equals(this.id, bottleType.id) &&
                Objects.equals(this.name, bottleType.name) &&
                Objects.equals(this.valide, bottleType.valide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, valide);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BottleType {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    valide: ").append(toIndentedString(valide)).append("\n");
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
