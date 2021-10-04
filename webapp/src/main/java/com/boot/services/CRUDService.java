package com.boot.services;

import java.util.List;

import com.boot.domain.AbstractDomainClass;

public interface CRUDService<T extends AbstractDomainClass> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T abstractDomainClass);

    void delete(Integer id);
}