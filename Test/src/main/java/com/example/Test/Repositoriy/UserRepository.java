package com.example.Test.Repositoriy;


import com.example.Test.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String login);
}
