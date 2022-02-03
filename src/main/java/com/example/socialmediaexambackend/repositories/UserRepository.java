package com.example.socialmediaexambackend.repositories;

import com.example.socialmediaexambackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUserByFirstNameAndAge(String firstName, int age);

    List<User> getUsersByFirstNameAndLastName(String firstName, String lastName);
}
