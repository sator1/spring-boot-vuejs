package com.reccyltd.springbootvuejs.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "workspaces")
public class Workspace {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String owner;
    private Date dateModified;

    public Workspace() {
    }

    public Workspace(String name, String owner, Date dateModified) {
        this.name = name;
        this.owner = owner;
        this.dateModified = dateModified;
    }

    @Override
    public String toString() {
        return String.format(
                "Workspace[id=%d, name='%s', owner='%s', dateModified='%s']",
                id, name, owner, dateModified);
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
