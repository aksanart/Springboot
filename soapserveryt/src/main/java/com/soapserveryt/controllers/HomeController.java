package com.soapserveryt.controllers;

import java.util.List;
import java.util.Map;

import com.soapserveryt.SeriveImplement.UserServiceImplement;
import com.soapserveryt.domain.DataPrivate;
import com.soapserveryt.domain.User;
import com.soapserveryt.domain.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired
    private UserServiceImplement userImpl;

    @GetMapping("/")
    public String index(Map<String, Object> map) {
        List<UserData> datas = userImpl.findAllData();
        map.put("datas", datas);
        return "index";
    }

    @GetMapping("/adddata")
    public String addData() {
        return "formInput";
    }

    @PostMapping("/savedata")
    public String saveData(@RequestParam Map<String, String> postData) throws Exception {
        User user = new User();
        DataPrivate dataPrivate = new DataPrivate();

        user.setUsername(postData.get("username"));
        user.setApiKey(postData.get("apiKey"));

        dataPrivate.setFullname(postData.get("fullname"));
        dataPrivate.setSalary(postData.get("salary"));
        dataPrivate.setAddress(postData.get("address"));

        userImpl.createData(user, dataPrivate);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        User user = userImpl.findByuserid(id);
        userImpl.DeleteRow(user);
        return "redirect:/";

    }
}