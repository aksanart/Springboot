package com.soapserveryt.SeriveImplement;

import java.util.List;

import com.soapserveryt.domain.DataPrivate;
import com.soapserveryt.domain.User;
import com.soapserveryt.domain.UserData;
import com.soapserveryt.repository.DataPrivateRepository;
import com.soapserveryt.repository.UserDataRepository;
import com.soapserveryt.repository.UserRepository;
import com.soapserveryt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImplement
 */
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private DataPrivateRepository dataRepo;
    @Autowired
    UserDataRepository userDataRepo;

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User createData(User user, DataPrivate dataPrivate) throws Exception {
        User user1 = userRepo.findByUsername(user.getUsername());
        DataPrivate dataPrivate2 = new DataPrivate();
        UserData userData = new UserData();
        if (user1 != null) {
            System.out.println("Use sudah ada");
        } else {
            user1 = userRepo.save(user);
            dataPrivate2 = dataRepo.save(dataPrivate);

            userData.setDataPrivate(dataPrivate2);
            userData.setUser(user);
            userDataRepo.save(userData);

        }
        return user1;
    }

    @Override
    public List<UserData> findAllData() {
        return userDataRepo.findAllData();
    }

    @Override
    public void DeleteRow(User user) {
        userRepo.delete(user);
    }

    @Override
    public User findByuserid(Long id) {
        // TODO Auto-generated method stub
        return userRepo.findByuserid(id);
    }

}