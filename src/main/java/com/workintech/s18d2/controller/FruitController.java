package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/fruit")
    public ResponseEntity<List<Fruit>> getFruits() {
        return ResponseEntity.ok(fruitService.getByPriceAsc());
    }

    @GetMapping("/fruit/desc")
    public ResponseEntity<List<Fruit>> getFruitsDesc() {
        return ResponseEntity.ok(fruitService.getByPriceDesc());
    }

    @GetMapping("/fruit/name/{name}")
    public ResponseEntity<List<Fruit>> getFruitsByName(@PathVariable String name) {
        return ResponseEntity.ok(fruitService.searchByName(name));
    }

    @PostMapping("/fruit")
    public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.save(fruit));
    }

    @GetMapping("/fruit/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        return ResponseEntity.ok(fruitService.getById(id));
    }

    @DeleteMapping("/fruit/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable Long id) {
        return ResponseEntity.ok(fruitService.delete(id));
    }
}
