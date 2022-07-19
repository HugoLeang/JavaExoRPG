package Core.CombatSystem.Techniques;

import Core.FighterBase;
import Utils.FighterUtils;

public class TechniquePunch extends TechniqueBase {

    public TechniquePunch() {
        super("Punch");
    }

    @Override
    public void UseTechnique(FighterBase launcher, FighterBase target) {
        super.UseTechnique(launcher, target);
        target.DealDamage(damageRoll + FighterUtils.getStatsModificator(launcher.getStrength()), super.attackRoll);
    }
}
