package com.soapserveryt.repository;

import com.soapserveryt.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

    public User findByuserid(Long id);

}