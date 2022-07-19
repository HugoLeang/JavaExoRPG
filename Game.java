import javax.swing.text.StyledEditorKit;

import Core.CharacterBuilder;
import Core.FighterBase;
import Core.CombatSystem.CombatManager;

public class Game {

    public static void main(String[] args) {
        boolean running = true;
        FighterBase playerFighter = null;
        CharacterBuilder characterBuilder = new CharacterBuilder();
        CombatManager combatManager = new CombatManager();
        while (running) {
            if (playerFighter == null) {
                playerFighter = characterBuilder.characterBuildProcedure();
                combatManager.StartCombat(playerFighter);
            }

            combatManager.updateCombatLoop();
        }

    }
}
