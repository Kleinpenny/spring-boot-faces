package com.auth0.samples.bootfaces.persistence;

import com.auth0.samples.bootfaces.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
