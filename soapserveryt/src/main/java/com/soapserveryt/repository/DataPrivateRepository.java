package com.soapserveryt.repository;

import com.soapserveryt.domain.DataPrivate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DataPrivateRepository
 */
@Repository
public interface DataPrivateRepository extends CrudRepository<DataPrivate, Long> {
    public DataPrivate findBydataid(Long id);
}