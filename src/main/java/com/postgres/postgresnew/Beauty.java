package com.postgres.postgresnew;

import jakarta.persistence.*;

@Entity
@Table(name = "beauty")
public class Beauty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "uses")
    private String uses;

    public Beauty() {

    }

    public Beauty(String name, String description, String uses) {
        super();
        this.name = name;
        this.description = description;
        this.uses = uses;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUses() {
        return uses;
    }
    public void setUses(String uses) {
        this.uses = uses;
    }
}