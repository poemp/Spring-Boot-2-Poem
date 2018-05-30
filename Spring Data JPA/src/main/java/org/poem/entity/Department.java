package org.poem.entity;

import org.poem.collection.Sets;

import javax.persistence.*;
import java.util.Set;

@Table(name = "department")
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<User> users = Sets.empty();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
