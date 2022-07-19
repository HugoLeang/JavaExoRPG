package Core.CombatSystem.Techniques;

import Core.FighterBase;
import Utils.RandomUtils;

public class TechniqueBase {
    private String techniqueName;
    protected int attackRoll;
    protected int damageRoll;
    protected int damageDice;

    public TechniqueBase(String name) {
        techniqueName = name;
    }

    public void UseTechnique(FighterBase launcher, FighterBase target) {
        System.out.println(launcher.getName() + " use " + techniqueName);
        attackRoll = RandomUtils.GetRandomNumber(1, 20);
        damageRoll = RandomUtils.GetRandomNumber(1, damageDice);
    }

    public String getTechniqueName() {
        return techniqueName;
    }
}
