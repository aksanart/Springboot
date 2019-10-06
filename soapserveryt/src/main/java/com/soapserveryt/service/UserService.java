package com.soapserveryt.service;

import java.util.List;

import com.soapserveryt.domain.DataPrivate;
import com.soapserveryt.domain.User;
import com.soapserveryt.domain.UserData;

/**
 * UserService
 */
public interface UserService {

    public User findByUsername(String username);

    public User save(User user);

    public User createData(User user, DataPrivate dataPrivate) throws Exception;

    public List<UserData> findAllData();

    public User findByuserid(Long id);

    public void DeleteRow(User user);
}