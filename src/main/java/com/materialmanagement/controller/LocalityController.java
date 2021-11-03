package com.materialmanagement.controller;

import com.materialmanagement.model.Locality;
import com.materialmanagement.model.User;
import com.materialmanagement.repository.ILocalityRepository;
import com.materialmanagement.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Locality")
public class LocalityController {

    @Autowired
    ILocalityRepository localityRepository;
    @Autowired
    IUserRepository userRepository;

    @GetMapping()
    public List<Locality> getAllLocalities() {
        return localityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Locality getLocalityById(@PathVariable Integer id) {
        Locality locality =  localityRepository.findById(id).get();
        return locality;
    }

    @PostMapping()
    public Locality createLocality(@RequestBody Locality Locality) {
        return localityRepository.save(Locality);
    }

    @PutMapping("/{localityId}/{userId}{")
    public Locality associate(@PathVariable Integer localityId, @PathVariable Integer userId) {

        User user = userRepository.findById(userId).get();
        Locality locality = localityRepository.findById(localityId).get();

        locality.setUser(user);
        user.getLocalities().add(locality);

        userRepository.save(user);
        localityRepository.save(locality);

        return  locality;

    }

    @PutMapping("/{localityId}")
    public Locality updateLocality(@PathVariable Integer localityId, @RequestBody Locality LocalityNew) {

        Locality locality = localityRepository.findById(localityId).get();

        locality.setName(LocalityNew.getName());
        locality.setNeighborhood(LocalityNew.getNeighborhood());

        localityRepository.save(locality);

        return locality;
    }


    @DeleteMapping("/{localityId}")
    public Locality deleteLocality(@PathVariable Integer localityId) {
        Locality locality = localityRepository.findById(localityId).get();
        userRepository.deleteById(localityId);
        return locality;
    }


}
