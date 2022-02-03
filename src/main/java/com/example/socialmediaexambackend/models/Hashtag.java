package com.example.socialmediaexambackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String hashWord;

    @ManyToOne
    @JsonIgnoreProperties
    @JsonBackReference
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;


    public Hashtag(String hashWord, Post post){
        this.hashWord = hashWord;
        this.post = post;
    }

    public Hashtag(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long hashtagId) {
        this.id = hashtagId;
    }

    public String getHashWord() {
        return hashWord;
    }

    public void setHashWord(String hashWord) {
        this.hashWord = hashWord;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "hashtagId=" + id +
                ", hashWord='" + hashWord + '\'' +
                ", post=" + post +
                '}';
    }
}
