package com.example.socialmediaexambackend.repositories;

import com.example.socialmediaexambackend.models.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    Hashtag getHashtagByHashWordAndPostId(String hashWord, Long id);

    List<Hashtag> getHashtagsByHashWord(String hashWord);

    List<Hashtag> getHashtagsByHashWordContains(String hashWord);
}
