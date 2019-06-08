package com.maktab25.homework11.tamrin1;

import java.util.ArrayList;
import java.util.List;

public class SecondMain {

    private static List<Animal> initList() {
        List<Animal> animalList = new ArrayList<>();
        BreedType[] breedTypes = BreedType.values();
        for (int i = 0; i < 99; i++) {
            animalList.add(new Cat("cat" + (i + 1), breedTypes[i]));
        }
        return animalList;
    }
}
