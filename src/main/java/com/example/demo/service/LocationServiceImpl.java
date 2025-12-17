package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LocationEntity;
import com.example.demo.service.LocationService;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/addlocation")
    public LocationEntity add(@RequestBody LocationEntity le) {
        return locationService.createlocation(le);
    }

    @GetMapping("/showlocation")
    public List<LocationEntity> show() {
        return locationService.getalllocation();
    }
}


.......



package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LocationEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private long latitude;
    private long longitude;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getLatitude() {
        return latitude;
    }
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
    public long getLongitude() {
        return longitude;
    }
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
    public LocationEntity() {
    }
    public LocationEntity(long id, String name, long latitude, long longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
}


......



package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
    
}



......



package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LocationEntity;

public interface LocationService {
    LocationEntity createlocation(LocationEntity location);
    List<LocationEntity> getalllocation();
}



......



package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepo;

    @Override
    public LocationEntity createlocation(LocationEntity le) {
        return locationRepo.save(le);
    }

    @Override
    public List<LocationEntity> getalllocation() {
        return locationRepo.findAll();
    }
}



