package Core.CombatSystem.Techniques;

import Core.FighterBase;
import Utils.RandomUtils;
import Utils.FighterUtils;

public class TechniqueBellyDash extends TechniqueBase {
    public TechniqueBellyDash() {
        super("Belly dash");
    }

    @Override
    public void UseTechnique(FighterBase launcher, FighterBase target) {
        super.UseTechnique(launcher, target);
        target.DealDamage(damageRoll + FighterUtils.getStatsModificator(launcher.getConstitution()), super.attackRoll);
    }
}
