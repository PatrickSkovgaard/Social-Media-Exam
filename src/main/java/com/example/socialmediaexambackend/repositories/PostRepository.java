package com.example.socialmediaexambackend.repositories;

import com.example.socialmediaexambackend.models.Hashtag;
import com.example.socialmediaexambackend.models.Post;
import com.example.socialmediaexambackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
