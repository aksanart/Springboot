package com.soapserveryt.api.service;

import java.util.List;

import com.soapserveryt.api.soap.ClientRequest;
import com.soapserveryt.api.soap.ServerRespond;
import com.soapserveryt.domain.DataPrivate;
import com.soapserveryt.domain.User;
import com.soapserveryt.domain.UserData;
import com.soapserveryt.repository.DataPrivateRepository;
import com.soapserveryt.repository.UserDataRepository;
import com.soapserveryt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DataSoap
 */
@Service
public class DataSoapService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private DataPrivateRepository dataRepo;
    @Autowired
    private UserDataRepository userDataRepo;

    public ServerRespond checkData(ClientRequest client) {
        ServerRespond serverRespond = new ServerRespond();
        List<String> errorMsg = serverRespond.getErrorMsg();

        User user = userRepo.findByUsername(client.getUsername());
        // validation
        if (user == null) {
            errorMsg.add("Access Denied: User not found!");
        } else {
            if (!user.getApiKey().equals(client.getApiKey())) {
                errorMsg.add("Access Denied: Wrong key!");
            }
        }

        if (errorMsg.size() > 0) {
            serverRespond.setIsApprove(false);
            serverRespond.setAddress(null);
            serverRespond.setFullname(null);
            serverRespond.setSalary(null);
        } else {
            UserData userData = userDataRepo.findByUser(user);
            DataPrivate dataPrivate = dataRepo.findBydataid(userData.getDataPrivate().getDataid());

            serverRespond.setIsApprove(true);
            serverRespond.setAddress(dataPrivate.getAddress());
            serverRespond.setFullname(dataPrivate.getFullname());
            serverRespond.setSalary(dataPrivate.getSalary());
            errorMsg.clear();
        }
        return serverRespond;
    }
}