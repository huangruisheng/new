package com.trusthiker.core.user.service;

import com.trusthiker.core.user.model.City;

import java.util.List;

/**
 * Created by rui on 16/10/25.
 */
public interface CityService {

    City get(Integer id);

    List<City> getAll();

    City add(City city);

    void update(City city);
}
