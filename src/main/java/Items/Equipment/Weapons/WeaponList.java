package Items.Equipment.Weapons;

import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Equipment.OffHands.DefenseOffHand;
import Items.Equipment.OffHands.MagicOffHand;
import Items.Equipment.OffHands.OffHand;
import Items.Equipment.OffHands.StrengthOffHand;

import java.util.ArrayList;
import java.util.List;

public class WeaponList {
    List<EquipableItem> weaponList = new ArrayList<>();
    public void compileWeaponList(){
     //tier 1
     weaponList.add(voidDagger);
     weaponList.add(voidStaff);
     weaponList.add(silverRapier);
     weaponList.add(arcaneOrb);
     weaponList.add(orbOfMight);
     weaponList.add(blessedShield);
     //tier 2
     weaponList.add(shadowblade);
     weaponList.add(eldritchStaff);
     weaponList.add(cursedSword);
     weaponList.add(eldritchTome);
     weaponList.add(golemHeart);
     weaponList.add(voidShield);
     //tier 3
     weaponList.add(arcaneHammer);
     weaponList.add(arcaneScepter);
     weaponList.add(abyssalHammer);
     weaponList.add(voidSigil);
     weaponList.add(holySigil);
     weaponList.add(sentinelShield);
     //tier 4
     weaponList.add(celestialBow);
     weaponList.add(staffOfTheEternalVoid);
     weaponList.add(bladeOfFury);
     weaponList.add(crystalOfAbyssalMastery);
     weaponList.add(dragonboneWarhorn);
     weaponList.add(shieldOfWarding);
     //tier 5
     weaponList.add(etherealBlade);
     weaponList.add(staffOfAbyssalDominion);
     weaponList.add(axeOfAnnihilation);
     weaponList.add(blackGrimoire);
     weaponList.add(leviathansGrasp);
     weaponList.add(aegis);
    }

    //
    //tier 1
    //

    //balanced -- stats split evenly between magic and strength
    public BalancedWeapon voidDagger = new BalancedWeapon("Void Dagger", "A dark dagger with magical properties.", 1);
    //magic weapon -- predominant magic stat
    public MagicWeapon voidStaff = new MagicWeapon("Enchanted Staff", "A staff imbued with magical energy.", 1);
    //strength weapon -- predominant strength stat
    public StrengthWeapon silverRapier = new StrengthWeapon("Silver Rapier", "A sleek rapier crafted from silver.", 1);
    //magic offhand
    public MagicOffHand arcaneOrb = new MagicOffHand("Arcane Orb", "A mysterious orb pulsating with arcane power.", 1);
   //strength offhand
   public StrengthOffHand orbOfMight = new StrengthOffHand("Orb of Might", "An enchanted crystal ball that enhances strength.", 1);
    //defense offhand
    public DefenseOffHand blessedShield = new DefenseOffHand("Blessed Shield", "A holy shield blessed by the church.", 1);

    //
    //tier 2 -- 20 stats for weapons, 10 for offhand
    //

    //balanced
    public BalancedWeapon shadowblade = new BalancedWeapon("Shadowblade", "A sleek and deadly blade forged from shadows and infused with void magic.", 2);
    //magic weapon
    public MagicWeapon eldritchStaff = new MagicWeapon("Eldritch Staff", "A twisted staff infused with eldritch energy.", 2);
    //strength weapon
    public StrengthWeapon cursedSword = new StrengthWeapon("Cursed Sword", "A blade imbued with a dark curse.", 2);
    //magic offhand
    public MagicOffHand eldritchTome = new MagicOffHand("Eldritch Tome", "A forbidden tome filled with eldritch knowledge.", 2);
    //strength offhand
    public StrengthOffHand golemHeart = new StrengthOffHand("Golem Heart", "The warm, stone core of a fallen golem, still radiating power.", 2);
    //defense offhand
    public DefenseOffHand voidShield = new DefenseOffHand("Void Shield", "A shield that absorbs the essence of the void.", 2);

    //
    //tier 3 -- 40 stats for weapons, 20 for offhand
    //

    //balanced
    public BalancedWeapon arcaneHammer = new BalancedWeapon("Arcane Hammer", "A mystical hammer infused with arcane energy.", 3);
    //magic weapon
    public MagicWeapon arcaneScepter = new MagicWeapon("Arcane Scepter", "A twisted scepter channeling arcane energies.", 3);

    //strength weapon
    public StrengthWeapon abyssalHammer = new StrengthWeapon("Abyssal Hammer", "A massive hammer forged in the depths of the abyss.", 3);

    //magic offhand
    public MagicOffHand voidSigil = new MagicOffHand("Void Sigil", "A dark sigil emanating an aura of primal void energy.", 3);

    //strength offhand
    public StrengthOffHand holySigil = new StrengthOffHand("Holy Sigil", "A blessed sigil emanating an aura of celestial energy.", 3);

    //defense offhand
    public DefenseOffHand sentinelShield = new DefenseOffHand("Sentinel Shield", " A sturdy shield engraved with ancient runes, providing exceptional defense against all forms of harm.", 3);

    //
    //tier 4
    //

    //balanced
    public BalancedWeapon celestialBow = new BalancedWeapon("Celestial Bow", " A bow crafted from celestial materials, imbued with both strength and magic.", 4);
    //magic weapon
    public MagicWeapon staffOfTheEternalVoid = new MagicWeapon("Staff of the Eternal Void", "A staff adorned with swirling darkness, tapping into the forbidden forces of the eternal void.", 4);
    //strength weapon
    public StrengthWeapon bladeOfFury = new StrengthWeapon("Blade of Fury", "A razor-sharp sword crackling with primal energy, empowering every strike with raw strength.", 4);
    //magic offhand
    public MagicOffHand crystalOfAbyssalMastery = new MagicOffHand("Crystal of Abyssal Mastery", "A crystalline artifact infused with the essence of the elements of the void, granting control over abyssal forces.", 4);
    //strength offhand
    public StrengthOffHand dragonboneWarhorn = new StrengthOffHand("Dragonbone Warhorn", "A legendary warhorn carved from the bones of a mighty dragon, empowering your strength on the battlefield.", 4);
    //defense offhand
    public DefenseOffHand shieldOfWarding = new DefenseOffHand("Shield of Warding", "A mystical shield radiating an aura of protective energy, shielding you from harm in the most dire situations.", 4);

    //
    // tier 5 -- 110 stats for weapons, 55 for offhand
    //

    //    //balanced
    public BalancedWeapon etherealBlade = new BalancedWeapon("Ethereal Blade", " A shimmering blade that exists between realms, possessing equal measures of magic and strength.", 5);
    //    //magic weapon
    public MagicWeapon staffOfAbyssalDominion = new MagicWeapon("Staff of Abyssal Dominion", "A radiant scepter infused with abyssal energy, granting control over the forces of the void itself.", 5);
    //    //strength weapon
    public StrengthWeapon axeOfAnnihilation = new StrengthWeapon("Axe of Annihilation", "A colossal battle axe radiating an aura of destruction, capable of cleaving through any obstacle.", 5);
    //    //magic offhand
    public MagicOffHand blackGrimoire = new MagicOffHand("Black Grimoire", "An evil tome whispering ancient secrets, granting forbidden knowledge and dark magical abilities.", 5);
    //    //strength offhand
    public StrengthOffHand leviathansGrasp = new StrengthOffHand("Leviathan's Grasp", "A tentacle-like appendage infused with the power of ancient sea beasts, providing tremendous strength.", 5);
    //    //defense offhand
    public DefenseOffHand aegis = new DefenseOffHand("Aegis", "An indestructible shield rumored to have been forged by gods, providing unmatched defense to its wielder", 5);

 public EquipableItem getByTypeAndTier(String type, int tier){
  compileWeaponList();
  for (int i = 0; i < weaponList.size(); i++) {
   EquipableItem item = weaponList.get(i);
     if(item.getType().equals(type) && item.getTier() == tier){
      return item;
     }
  }
  return null;
 }

}
