package com.example.socialmediaexambackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column(length = 3)
    private byte age;

    @Column
    private String shortDescription;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties
    private List<Post> posts;


    public User(String userName, byte age, String shortDescription, List<Post> posts){
        this.userName = userName;
        this.age = age;
        this.shortDescription = shortDescription;
        this.posts = posts;
    }

    public User(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long userId) {
        this.id = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = firstName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", firstName='" + userName + '\'' +
                ", age=" + age +
                ", shortDescription='" + shortDescription + '\'' +
                ", posts=" + posts +
                '}';
    }
}
