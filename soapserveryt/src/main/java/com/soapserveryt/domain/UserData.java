package com.soapserveryt.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * UserData
 */
@Entity
/*
 * @Data ini error kalo ketemu mapping database @OneToOne / @OneToMany(mappedBy
 * = "user") karena hql direpository pake constructor
 */
@Getter
@Setter
public class UserData {

    public UserData() {
    }

    public UserData(DataPrivate dataid, User userid) {
        this.dataPrivate = dataid;
        this.user = userid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "userid")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    @JoinColumn(name = "dataid")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private DataPrivate dataPrivate;

    @Override
    public String toString() {
        return "UserData[ " + user + ", " + dataPrivate + "]";
    }

}