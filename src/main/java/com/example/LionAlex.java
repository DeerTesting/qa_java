package com.example;

import java.util.List;

public class LionAlex extends Lion{


    public LionAlex(Feline feline) throws Exception {
        super(feline,"Самец");
    }

    public List<String> getFriends(){
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens(){
        return feline.getKittens(0);
    }
}
