package com.bodega.backend.service;

import com.bodega.backend.model.Roles;

import java.util.List;

public interface RolesService extends ICRUD<Roles>{
    List<Roles> findByName(String nombre);

    List<Roles> findByCondition(Boolean estado);
}
