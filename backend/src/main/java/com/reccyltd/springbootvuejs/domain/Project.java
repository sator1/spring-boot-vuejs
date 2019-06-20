package com.reccyltd.springbootvuejs.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String owner;
    private Date dateModified;

    @OneToMany(targetEntity = Workspace.class)
    private List<Workspace> workspaces;

    public Project() {
    }

    public Project(String name, String owner, Date dateModified, List<Workspace> workspaces) {
        this.name = name;
        this.owner = owner;
        this.dateModified = dateModified;
        this.workspaces = workspaces;
    }


    @Override
    public String toString() {
        return String.format(
                "Project[id=%d, name='%s', owner='%s', dateModified='%s']",
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

    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }
}
