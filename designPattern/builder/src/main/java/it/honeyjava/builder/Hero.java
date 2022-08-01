package it.honeyjava.builder;

import lombok.var;

public final class Hero {

    private final Profession profession; // professione dell'eroe
    private final String name; // nome dell'eroe
    private final HairType hairType; // tipo di acconciatura dell'eroe
    private final HairColor hairColor; // colore dei capelli dell'eroe
    private final Armor armor; // armatura dell'eroe
    private final Weapon weapon; // arma dell'eroe
  
    private Hero(Builder builder) { // costruttore privato
      this.profession = builder.profession; // professione dell'eroe
      this.name = builder.name; // nome dell'eroe
      this.hairColor = builder.hairColor; // colore dei capelli dell'eroe
      this.hairType = builder.hairType; // tipo di acconciatura dell'eroe
      this.weapon = builder.weapon; // arma dell'eroe
      this.armor = builder.armor; // armatura dell'eroe
    }
  
    public Profession getProfession() {
      return profession;
    }
  
    public String getName() {
      return name;
    }
  
    public HairType getHairType() {
      return hairType;
    }
  
    public HairColor getHairColor() {
      return hairColor;
    }
  
    public Armor getArmor() {
      return armor;
    }
  
    public Weapon getWeapon() {
      return weapon;
    }
  
    @Override
    public String toString() {
  
      var sb = new StringBuilder();
      sb.append("This is a ")
          .append(profession)
          .append(" named ")
          .append(name);
      if (hairColor != null || hairType != null) {
        sb.append(" with ");
        if (hairColor != null) {
          sb.append(hairColor).append(' ');
        }
        if (hairType != null) {
          sb.append(hairType).append(' ');
        }
        sb.append(hairType != HairType.BALD ? "hair" : "head");
      }
      if (armor != null) {
        sb.append(" wearing ").append(armor);
      }
      if (weapon != null) {
        sb.append(" and wielding a ").append(weapon);
      }
      sb.append('.');
      return sb.toString();
    }
  
    /**
     * The builder class.
     */
    public static class Builder { // classe Builder
  
      private final Profession profession; // professione dell'eroe
      private final String name; // nome dell'eroe
      private HairType hairType; // tipo di acconciatura dell'eroe
      private HairColor hairColor; // colore dei capelli dell'eroe
      private Armor armor; // armatura dell'eroe
      private Weapon weapon; // arma dell'eroe
  
      /**
       * Constructor.
       */
      public Builder(Profession profession, String name) {
        if (profession == null || name == null) {
          throw new IllegalArgumentException("profession and name can not be null");
        }
        this.profession = profession;
        this.name = name;
      }
  
      public Builder withHairType(HairType hairType) {
        this.hairType = hairType;
        return this;
      }
  
      public Builder withHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
        return this;
      }
  
      public Builder withArmor(Armor armor) {
        this.armor = armor;
        return this;
      }
  
      public Builder withWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
      }
  
      public Hero build() {
        return new Hero(this);
      }
    }
  }