package com.soapserveryt.repository;

import com.soapserveryt.domain.User;
import com.soapserveryt.domain.UserData;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * UserDataRepository
 */
public interface UserDataRepository extends CrudRepository<UserData, Long> {

    @Query("Select new com.soapserveryt.domain.UserData(ud.dataPrivate, ud.user)" + " from UserData ud")
    public List<UserData> findAllData();

    public UserData findByUser(User user);
}