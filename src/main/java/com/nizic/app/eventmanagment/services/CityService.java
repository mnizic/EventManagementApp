package com.nizic.app.eventmanagment.services;

import com.nizic.app.eventmanagment.entities.City;
import com.nizic.app.eventmanagment.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired private CityRepository repo;

    public List<City> listAllCities(){
        return (List<City>) repo.findAll();
    }
}
