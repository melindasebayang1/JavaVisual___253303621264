
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private int level;
    private CharacterType type;

    private static int totalCharacterCreated = 0;

    // Constructor
    public Character(String name, int level, CharacterType type) {
        this.name = name;
        this.level = level;
        this.type = type;
        totalCharacterCreated++;
    }

    // Constructor kedua
    public Character(String name, int level) {
        this(name, level, CharacterType.values()[0]);
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Mengambil jumlah Character yang dibuat
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Level up
    public void levelUp() {
        level++;
    }

    // Membandingkan Character berdasarkan nama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", type=" + type +
                '}';
    }
}