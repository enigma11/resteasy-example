package com.gdiama.infrastructure.rest.resources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pool")
@XmlAccessorType(value = XmlAccessType.PROPERTY)
public class PoolResource {

    public String description;
    public double seeds;

    public PoolResource() {
    }

    public PoolResource(String description, double seeds) {
        this.description = description;
        this.seeds = seeds;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "seeds")
    public double getSeeds() {
        return seeds;
    }

    public void setSeeds(double seeds) {
        this.seeds = seeds;
    }
}
