
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        characterList = new ArrayList<>();
    }

    // Menambahkan karakter
    public boolean addCharacter(Character character) {

        if (character == null) {
            return false;
        }

        if (isNameTaken(character.getName())) {
            System.out.println("Karakter sudah ada!");
            return false;
        }

        characterList.add(character);

        System.out.println("Karakter " + character.getName()
                + " berhasil ditambahkan.");

        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name.trim())) {
                return c;
            }
        }

        return null;
    }

    // Menghapus karakter
    public boolean removeCharacter(String name) {

        Character target = findByName(name);

        if (target == null) {
            System.out.println("Karakter tidak ditemukan!");
            return false;
        }

        characterList.remove(target);

        System.out.println("Karakter " + name
                + " berhasil dihapus.");

        return true;
    }

    // Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characterList.size();
    }

    // Mengambil seluruh karakter
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // Menghitung rata-rata level
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

    // Mencari karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }

    // Memeriksa nama karakter duplikat
    public boolean isNameTaken(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }

        return false;
    }
}
