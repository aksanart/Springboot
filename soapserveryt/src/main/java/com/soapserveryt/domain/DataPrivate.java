package com.soapserveryt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Datauser
 */
@Entity
@Data
public class DataPrivate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dataid;

    private String fullname;
    private String salary;
    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private UserData userdata;

    @Override
    public String toString() {
        return "DataPrivate [ dataid=" + dataid + ", fullname=" + fullname + ", salary=" + salary + ", address="
                + address + "]";
    }
}