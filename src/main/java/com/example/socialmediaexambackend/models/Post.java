package com.example.socialmediaexambackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String postTitle;

    @Column
    private String postContent;


    @Column
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties
    private List<Hashtag> hashtags;

    @ManyToOne
    @JsonIgnoreProperties
    @JsonBackReference //author i stedet for user_id?
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Post(String postTitle, String postContent, LocalDate dateCreated){
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.dateCreated = dateCreated;
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

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String description) {
        this.postContent = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
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
                ", content='" + postContent + '\'' +
                ", date created='" + dateCreated + '\'' +
                ", hashtags=" + hashtags +
                ", user=" + user +
                '}';
    }
}
