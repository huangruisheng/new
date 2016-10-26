package com.trusthiker.core.user.service.impl;

import com.trusthiker.common.db.service.EntityServiceImpl;
import com.trusthiker.core.user.dao.CityDao;
import com.trusthiker.core.user.model.City;
import com.trusthiker.core.user.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rui on 16/10/25.
 */
@Service
@Transactional
public class CityServiceImpl extends EntityServiceImpl<City> implements CityService {

    @Autowired
    private CityDao cityDao;


    @Override
    public City get(Integer id) {
        return cityDao.getById(id);
    }


    @Override
    public List<City> getAll() {
        return cityDao.getAll();
    }

    @Override
    public City add(City city) {
        cityDao.insert(city);
        return city;
    }

    @Override
    public void update(City city) {
        cityDao.update(city);
    }
}
