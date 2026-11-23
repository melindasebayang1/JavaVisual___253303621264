package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        characterList = new ArrayList<>();
    }

    public boolean addCharacter(Character character) {

        if (findByName(character.getName()) != null) {
            System.out.println("Karakter sudah ada!");
            return false;
        }

        characterList.add(character);

        System.out.println("Karakter " + character.getName()
                + " berhasil ditambahkan.");

        return true;
    }

    public Character findByName(String name) {

        for (Character c : characterList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {

        Character target = findByName(name);

        if (target == null) {
            System.out.println("Karakter tidak ditemukan!");
            return false;
        }

        characterList.remove(target);

        System.out.println("Karakter " + name + " berhasil dihapus.");

        return true;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    public double getAverageLevel() {

        if (characterList.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Character c : characterList) {
            total += c.getLevel();
        }

        return (double) total / characterList.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }

    public boolean isNameTaken(String name) {
    for (Character c : getAllCharacters()) {            // memakai method yang sudah ada
        if (c.getName().equalsIgnoreCase(name)) {       // "arjuna" dianggap sama dengan "Arjuna"
            return true;
        }
    }
    return false;
}
}