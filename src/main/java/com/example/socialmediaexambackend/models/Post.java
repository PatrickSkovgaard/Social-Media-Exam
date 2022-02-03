package com.example.socialmediaexambackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String postTitle;

    @Column
    private String postDescription;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Hashtag> hashtags;

    @ManyToOne
    @JsonIgnoreProperties
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Post(String postTitle, String postDescription, List<Hashtag> hashtags, User user){
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.hashtags = hashtags;
        this.user = user;
    }

    public Post(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long postId) {
        this.id = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String title) {
        this.postTitle = title;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String description) {
        this.postDescription = description;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + id +
                ", title='" + postTitle + '\'' +
                ", description='" + postDescription + '\'' +
                ", hashtags=" + hashtags +
                ", user=" + user +
                '}';
    }
}
