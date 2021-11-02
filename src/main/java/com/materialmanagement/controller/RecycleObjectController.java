package com.materialmanagement.controller;

import com.materialmanagement.model.Locality;
import com.materialmanagement.model.RecycleObject;
import com.materialmanagement.repository.ILocalityRepository;
import com.materialmanagement.repository.IRecycleObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Recycle")
public class RecycleObjectController {

    @Autowired
    IRecycleObjectRepository recycleObjectRepository;
    @Autowired
    ILocalityRepository localityRepository;

    @GetMapping("/getRecycle")
    public List<RecycleObject> getAllRecycleObjects() {
        return recycleObjectRepository.findAll();
    }

    @GetMapping("/Recycle/{idRecycleObject}")
    public RecycleObject getRecycleObjectById(@PathVariable Integer idRecycleObject) {
        RecycleObject recycleObject =  recycleObjectRepository.findById(idRecycleObject).get();
        return recycleObject;
    }

    @PostMapping("/Recycle")
    public RecycleObject createLocality(@RequestBody RecycleObject recycleObject) {
        return recycleObjectRepository.save(recycleObject);
    }

    @PutMapping("/Recycle/{idRecycleObject}/{localityId}")
    public RecycleObject associate(@PathVariable Integer idRecycleObject, @PathVariable Integer localityId) {


        RecycleObject recycleObject = recycleObjectRepository.findById(idRecycleObject).get();
        Locality locality = localityRepository.findById(localityId).get();

        recycleObject.setLocality(locality);
        locality.getRecycleObjects().add(recycleObject);

        recycleObjectRepository.save(recycleObject);
        localityRepository.save(locality);

        return recycleObject;

    }

    @DeleteMapping("/User/{idRecycleObject}")
    public RecycleObject deleteLocality(@PathVariable Integer idRecycleObject) {
        RecycleObject recycleObject = recycleObjectRepository.findById(idRecycleObject).get();
        recycleObjectRepository.deleteById(idRecycleObject);
        return recycleObject;
    }

}
