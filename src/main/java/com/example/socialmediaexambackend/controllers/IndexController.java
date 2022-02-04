package com.example.socialmediaexambackend.controllers;

import com.example.socialmediaexambackend.models.Hashtag;
import com.example.socialmediaexambackend.models.Post;
import com.example.socialmediaexambackend.models.User;
import com.example.socialmediaexambackend.repositories.HashtagRepository;
import com.example.socialmediaexambackend.repositories.PostRepository;
import com.example.socialmediaexambackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class IndexController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final HashtagRepository hashtagRepository;

    public IndexController(PostRepository postRepository, UserRepository userRepository,
                           HashtagRepository hashtagRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.hashtagRepository = hashtagRepository;
    }



    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){

        List<User> users = userRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findOneUser(@PathVariable (name = "id") Long id){

        if(userRepository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



    @PostMapping(value = "/create_user", consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user){

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update_user/{id}", consumes = "application/json")
    public ResponseEntity<User> updateUser(@PathVariable (name = "id") Long id,
                                           @RequestBody User user){

        if (userRepository.findById(id).isPresent()) {
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable (name = "id") Long id){

        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }




    @GetMapping("/posts")
    public ResponseEntity<List<Post>> posts(){

        List<Post> posts = postRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Optional<Post>> findOnePost(@PathVariable (name = "id") Long id){

        if(postRepository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(postRepository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/create_post", consumes = "application/json")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        System.out.println(post);
        postRepository.save(post);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update_post/{id}", consumes = "application/json")
    public ResponseEntity<Post> updatePost(@PathVariable (name = "id") Long id,
                                           @RequestBody Post post){

        if (postRepository.findById(id).isPresent()) {
            postRepository.save(post);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete_post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable (name = "id") Long id){

        if(postRepository.findById(id).isPresent()){
            postRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }





    @GetMapping("/hashtags")
    public ResponseEntity<List<Hashtag>> hashtags(){

        List<Hashtag> hashtags = hashtagRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(hashtags);
    }

    @GetMapping("/hashtag/{id}")
    public ResponseEntity<Optional<Hashtag>> findOneHashtag(@PathVariable (name = "id") Long id){

        if(hashtagRepository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(hashtagRepository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/create_hashtag", consumes = "application/json")
    public ResponseEntity<Hashtag> createHashtag(@RequestBody Hashtag hashtag){

        hashtagRepository.save(hashtag);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update_hashtag/{id}", consumes = "application/json")
    public ResponseEntity<Hashtag> updateHashtag(@PathVariable (name = "id") Long id,
                                                 @RequestBody Hashtag hashtag){

        if (hashtagRepository.findById(id).isPresent()) {
            hashtagRepository.save(hashtag);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete_hashtag/{id}")
    public ResponseEntity<Hashtag> deleteHashtag(@PathVariable (name = "id") Long id){

        if (hashtagRepository.findById(id).isPresent()) {
            hashtagRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
