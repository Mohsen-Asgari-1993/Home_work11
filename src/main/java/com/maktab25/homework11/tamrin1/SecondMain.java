package com.maktab25.homework11.tamrin1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMain {

    public static void main(String[] args) {
        System.out.println(filterByNameAndBreedType(initList()));
    }

    private static List<Animal> initList() {
        List<Animal> animalList = new ArrayList<>();
        BreedType[] breedTypes = BreedType.values();
        for (int i = 0; i < 99; i++) {
            animalList.add(new Cat("cat" + (i + 1), breedTypes[i]));
        }
        return animalList;
    }

    private static List<BreedType> filterByNameAndBreedType(List<Animal> animals) {
        Function<Cat, BreedType> change = Cat::getBreedType;
        List<BreedType> catsBreedTypes = animals.stream().filter(cat -> {
            if (cat instanceof Cat) {
                if (((Cat) cat).getBreedType().toString().startsWith("A") ||
                        ((Cat) cat).getBreedType().toString().startsWith("C") ||
                        ((Cat) cat).getBreedType().toString().startsWith("P"))
                    return true;
            }
            return false;
        }).filter(cat -> Integer.parseInt(cat.getName().substring(3)) % 2 == 0)
                .map(c -> change.apply((Cat) c)).collect(Collectors.toList());
        return catsBreedTypes;
    }
}
