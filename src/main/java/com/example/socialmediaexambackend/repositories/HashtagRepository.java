package com.example.socialmediaexambackend.repositories;

import com.example.socialmediaexambackend.models.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
