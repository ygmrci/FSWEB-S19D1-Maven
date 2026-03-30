package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/vegetable")
    public ResponseEntity<List<Vegetable>> getVegetables() {
        return ResponseEntity.ok(vegetableService.getByPriceAsc());
    }

    @GetMapping("/vegetable/desc")
    public ResponseEntity<List<Vegetable>> getVegetablesDesc() {
        return ResponseEntity.ok(vegetableService.getByPriceDesc());
    }

    @GetMapping("/vegetable/name/{name}")
    public ResponseEntity<List<Vegetable>> getVegetablesByName(@PathVariable String name) {
        return ResponseEntity.ok(vegetableService.searchByName(name));
    }

    @PostMapping("/vegetable")
    public ResponseEntity<Vegetable> saveVegetable(@RequestBody Vegetable vegetable) {
        return ResponseEntity.ok(vegetableService.save(vegetable));
    }

    @GetMapping("/vegetable/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable Long id) {
        return ResponseEntity.ok(vegetableService.getById(id));
    }

    @DeleteMapping("/vegetable/{id}")
    public ResponseEntity<Vegetable> deleteVegetable(@PathVariable Long id) {
        return ResponseEntity.ok(vegetableService.delete(id));
    }
}
