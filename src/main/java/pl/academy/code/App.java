package pl.academy.code;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.academy.code.configuration.AppAutoConfiguration;
import pl.academy.code.model.Animal;
import pl.academy.code.services.IAnimalService;
import pl.academy.code.services.impl.AnimalServiceImpl;

public class App {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setAge(5);
        animal.setName("Reksio");
        animal.setSpecies("Dog");

        Animal animal2 = new Animal();
        animal2.setSpecies("Cat");
        animal2.setName("Kajtek");
        animal2.setAge(6);

        Animal animal3 = new Animal();
        animal3.setSpecies("Snake");
        animal3.setName("Puszek");
        animal3.setAge(3);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppAutoConfiguration.class);

        IAnimalService animalService = context.getBean(IAnimalService.class);

        animalService.saveAnimal(animal);
        animalService.saveAnimal(animal2);
        animalService.saveAnimal(animal3);

        System.out.println(animalService.getAllAnimals());

        System.out.println("TEST !!!!!!!!!!!!!!!!! - " + animalService.getAnimalById(1));

        Animal testAnimal = animalService.getAnimalById(1);
        testAnimal.setId(2);
        animalService.updateAnimal(testAnimal);

        System.exit(0);
    }
}
