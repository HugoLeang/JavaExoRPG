package Core;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Core.CombatSystem.Techniques.TechniqueBase;
import Core.CombatSystem.Techniques.TechniqueBellyDash;
import Core.CombatSystem.Techniques.TechniqueChop;
import Core.CombatSystem.Techniques.TechniquePunch;
import Utils.FighterUtils;
import Utils.RandomUtils;

public class FighterBase {
    private String name;
    private float maxHp;
    private float currentHp;

    private int strength;
    private int agility;
    private int constitution;

    private List<TechniqueBase> techniques;

    public FighterBase() {
        this("Nameless fighter");

    }

    public FighterBase(String name) {
        this.name = name;
        strength = RandomUtils.GetRandomNumber(Constants.MIN_STAT, Constants.MAX_STAT);
        agility = RandomUtils.GetRandomNumber(Constants.MIN_STAT, Constants.MAX_STAT);
        constitution = RandomUtils.GetRandomNumber(Constants.MIN_STAT, Constants.MAX_STAT);
        maxHp = RandomUtils.GetRandomNumber(Constants.MIN_HP, Constants.MAX_HP);
        currentHp = maxHp;
        techniques = Arrays.asList(new TechniquePunch(), new TechniqueChop(), new TechniqueBellyDash());

    }

    public float getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(float newCurrentHp) {
        currentHp = newCurrentHp;
    }

    public float getMaxHP() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public List<TechniqueBase> getTechniques() {
        return techniques;
    }

    public void displayStats() {
        String dataToDispay = MessageFormat.format("----[{0}]---- \n | (HP): {1} / {2} | \n", name, currentHp, maxHp)
                + MessageFormat.format(" | [STR] : {0} (MOD.) : {1} | \n", strength,
                        FighterUtils.getStatsModificator(strength))
                + MessageFormat.format(" | [AGI] : {0} (MOD.) : {1} | \n", agility,
                        FighterUtils.getStatsModificator(agility))
                + MessageFormat.format(" | [CON] : {0} (MOD.) : {1} | \n", constitution,
                        FighterUtils.getStatsModificator(constitution));

        System.out.println(dataToDispay);
    }

    public void displayHp() {
        String dataToDispay = MessageFormat.format("----[{0}]---- \n | (HP): {1} / {2} | \n", name, currentHp, maxHp);
        System.out.println(dataToDispay);
    }

    public void DealDamage(int damage, int attackRoll) {
        int defRoll = RandomUtils.GetRandomNumber(1, 20) + FighterUtils.getStatsModificator(getConstitution());

        if (attackRoll > defRoll) {
            System.out.println(name + " receive " + damage + "pts of damage ");
            currentHp -= damage;
        } else {
            int reducedDamage = Math.max(0, damage - FighterUtils.getStatsModificator(getConstitution()));
            System.out.println(name + " reduce damages," + name + " receive " + reducedDamage);
            currentHp -= reducedDamage;
        }

    }
}
