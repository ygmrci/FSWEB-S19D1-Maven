package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit save(Fruit fruit) {
        if (fruit == null) {
            throw new PlantException("Fruit data is not valid");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {
        if (id == null || id <= 0) {
            throw new PlantException("Id must be greater than 0");
        }
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit not found"));
    }

    @Override
    public Fruit delete(Long id) {
        if (id == null || id <= 0) {
            throw new PlantException("Id must be greater than 0");
        }
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit not found"));
        fruitRepository.delete(fruit);
        return fruit;
    }
}
