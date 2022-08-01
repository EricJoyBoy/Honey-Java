package it.honeyjava.builder;


import lombok.*;



public class App {

 
  public static void main(String[] args) {

    var mage = new Hero.Builder(Profession.MAGE, "Riobard")  // mago di nome Riobard
        .withHairColor(HairColor.BLACK) // con i capelli di colore nero
        .withWeapon(Weapon.DAGGER) // con una daga
        .build(); // e lo costruisco
    System.out.println(mage.toString()); // stampo il mago

    var warrior = new Hero.Builder(Profession.WARRIOR, "Amberjill")  // guerriero di nome Amberjill
        .withHairColor(HairColor.BLOND) // con i capelli di colore blu
        .withHairType(HairType.LONG_CURLY).withArmor(Armor.CHAIN_MAIL).withWeapon(Weapon.SWORD) // con una scudo e una spada
        .build(); // e lo costruisco
    System.out.println(warrior.toString()); // stampo il guerriero

    var thief = new Hero.Builder(Profession.THIEF, "Desmond") // ladro di nome Desmond
        .withHairType(HairType.BALD) // con i capelli di tipo bald
        .withWeapon(Weapon.BOW) // con una arco
        .build(); // e lo costruisco
    System.out.println(thief.toString()); // stampo il ladro
  }
}

