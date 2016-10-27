package com.trusthiker.core.user.service;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.trusthiker.core.user.model.City;
import com.trusthiker.dto.user.CityStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/testAppContext_mysql.xml")
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class})
public class CityServiceTest {


    @Autowired
    private CityService cityService;

    @Test
    @DatabaseSetup("CitySampleData.xml")
    public void testGet() throws Exception {
        List<City> cities = cityService.getAll();
        assertNotNull(cities);
        assertEquals(1, cities.size());
    }

    @Test
    @DatabaseSetup("CitySampleData.xml")
    public void testGetAll() throws Exception {
        List<City> cities = cityService.getAll();
        assertNotNull(cities);
        assertEquals(1, cities.size());
        City city = cityService.get(cities.get(0).getId());
        assertEquals("上海", city.getName());
    }

    @Test
    public void testAdd() throws Exception {
        City city = new City();
        city.setCode(10001);
        city.setName("上海");
        city.setPinyin("shanghai");
        city.setStatus(CityStatus.ENABLE);
        city.setOperator("SYSTEM");
        city = cityService.add(city);
        Integer id = city.getId();
        assertNotNull(id);
        city = cityService.get(id);
        assertEquals("上海", city.getName());
    }


    @Test
    @DatabaseSetup("CitySampleData.xml")
    public void testUpdate() throws Exception {
        List<City> cities = cityService.getAll();
        City city = cities.get(0);
        Integer id = city.getId();
        city.setName("上海1");
        cityService.update(city);
        city = cityService.get(id);
        assertEquals("上海1", city.getName());
    }
}
