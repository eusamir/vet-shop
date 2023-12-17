package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vetshop.com.vetshop.DTO.AnimalDto;
import vetshop.com.vetshop.Entities.Animal;
import vetshop.com.vetshop.Repositories.IAnimalRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    IAnimalRepository animalRepository;

    public List<AnimalDto> findAll(){
        List<Animal> resultList = animalRepository.findAll();
        return resultList.stream().map(AnimalDto::new).toList();
    }

    public AnimalDto findById(UUID id){
        Animal animal = animalRepository.findById(id).orElseThrow();
        return new AnimalDto(animal);
    }

    public  AnimalDto create(AnimalDto animalDto){
        Animal animal = new Animal(animalDto);
        return new AnimalDto(animalRepository.save(animal));
    }

    public AnimalDto update(AnimalDto animalDto){
        Animal animal = animalRepository.findById(animalDto.getId()).orElseThrow();
        animal.setTipo(animalDto.getTipo());
        animal.setRaca(animalDto.getRaca());
        animal.setDataNascimento(animalDto.getDataNascimento());
        return new AnimalDto(animalRepository.save(animal));
    }

    public void delete(UUID id){
        Animal animal = animalRepository.findById(id).orElseThrow();
        animalRepository.delete(animal);
    }

}
