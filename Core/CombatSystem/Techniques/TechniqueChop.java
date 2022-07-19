package Core.CombatSystem.Techniques;

import Core.FighterBase;
import Utils.FighterUtils;

public class TechniqueChop extends TechniqueBase {
    public TechniqueChop() {
        super("Chop");
    }

    @Override
    public void UseTechnique(FighterBase launcher, FighterBase target) {
        super.UseTechnique(launcher, target);
        target.DealDamage(damageRoll + FighterUtils.getStatsModificator(launcher.getAgility()), super.attackRoll);
    }
}
