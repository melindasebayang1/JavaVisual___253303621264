
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Membuat Character
        Character c1 = new Character(
                "Aragorn", 10, CharacterType.values()[0]);

        Character c2 = new Character(
                "Gandalf", 20, CharacterType.values()[1]);

        Character c3 = new Character(
                "Legolas", 15, CharacterType.values()[2]);

        // Menambahkan Character
        System.out.println("=== CHARACTER MANAGER ===");

        System.out.println("Tambah Aragorn: "
                + manager.addCharacter(c1));

        System.out.println("Tambah Gandalf: "
                + manager.addCharacter(c2));

        System.out.println("Tambah Legolas: "
                + manager.addCharacter(c3));

        // Menampilkan semua Character
        System.out.println("\n=== DAFTAR CHARACTER ===");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // Total Character
        System.out.println("\nTotal Character: "
                + manager.getTotalCharacters());

        // Rata-rata level
        System.out.println("Rata-rata Level: "
                + manager.getAverageLevel());

        // Mencari Character
        System.out.println("\n=== PENCARIAN ===");

        Character found = manager.findByName("Gandalf");

        if (found != null) {
            System.out.println("Character ditemukan: " + found);
        } else {
            System.out.println("Character tidak ditemukan");
        }

        // Character terkuat
        System.out.println("\n=== CHARACTER TERKUAT ===");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println(strongest);
        }

        // Menghapus Character
        System.out.println("\n=== HAPUS CHARACTER ===");

        System.out.println("Hapus Legolas: "
                + manager.removeCharacter("Legolas"));

        System.out.println("Total setelah dihapus: "
                + manager.getTotalCharacters());
    }
}