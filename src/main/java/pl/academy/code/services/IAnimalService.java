package pl.academy.code.services;

import pl.academy.code.model.Animal;

import java.util.List;

public interface IAnimalService {
    void saveAnimal(Animal animal);
    List<Animal> getAllAnimals();
    Animal getAnimalById(int id);
    void updateAnimal(Animal animal);
}
