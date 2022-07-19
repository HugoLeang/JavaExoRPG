package Core.CombatSystem;

import Core.FighterBase;
import Core.CombatSystem.Techniques.TechniqueBase;
import Utils.FighterUtils;
import Utils.RandomUtils;
import java.util.List;
import java.util.Scanner;
import java.text.MessageFormat;

public class CombatManager {
    private FighterBase playerFighter;
    private FighterBase enemyFighter;

    private FighterBase currentFighter;
    private boolean fightRunning = true;

    public void StartCombat(FighterBase playerFigther) {
        this.playerFighter = playerFigther;
        enemyFighter = new FighterBase("Enemy Fighter");
        checkInitiative();
    }

    public void checkInitiative() {
        int playerInitiative = RandomUtils.GetRandomNumber(0, 20)
                + FighterUtils.getStatsModificator(playerFighter.getAgility());
        int enemyInitiative = RandomUtils.GetRandomNumber(0, 20)
                + FighterUtils.getStatsModificator(playerFighter.getAgility());

        if (playerInitiative >= enemyInitiative)
            currentFighter = playerFighter;
        else {
            currentFighter = enemyFighter;
        }
    }

    public void updateCombatLoop() {
        deathWatcher();
        if (fightRunning) {
            System.out.println("---ooooo~~~ STATS ~~~ooooo---");
            playerFighter.displayHp();
            enemyFighter.displayHp();
            if (currentFighter == enemyFighter)
                playEnemyTurn();
            else {
                playPlayerTurn();
            }
            passTurn();
        }
    }

    private void playEnemyTurn() {
        System.out.println("======== [ENEMY TURN] =======");
        List<TechniqueBase> techniques = currentFighter.getTechniques();
        techniques.get(RandomUtils.GetRandomNumber(0, techniques.size())).UseTechnique(enemyFighter, playerFighter);
        System.out.println("===============");
    }

    private void playPlayerTurn() {
        System.out.println("======== [PLAYER TURN] =======");
        boolean waitingInput = true;
        Scanner scanner = new Scanner(System.in);
        List<TechniqueBase> techniques = playerFighter.getTechniques();
        while (waitingInput) {
            System.out.println("Select your technique \n 1 - STR (PUNCH) \n 2 - AGI (CHOP) \n 3 - CON (BELLY DASH)");
            String input = scanner.next();
            switch (input.charAt(0)) {
                case '1':
                    techniques.get(0).UseTechnique(playerFighter, enemyFighter);
                    break;
                case '2':
                    techniques.get(1).UseTechnique(playerFighter, enemyFighter);
                    break;
                case '3':
                    techniques.get(2).UseTechnique(playerFighter, enemyFighter);
                    break;
                default:
                    System.out.println("Option not found");
                    break;
            }
            System.out.println("===============");
            waitingInput = false;
        }

    }

    private void passTurn() {
        if (currentFighter == enemyFighter)
            currentFighter = playerFighter;
        else {

            currentFighter = enemyFighter;
        }
    }

    private void deathWatcher() {
        if (playerFighter.getCurrentHp() <= 0 || enemyFighter.getCurrentHp() <= 0) {
            fightRunning = false;
            System.out.println("======= END OF FIGHT =====");
            if (enemyFighter.getCurrentHp() <= 0) {
                System.out.println("======= " + playerFighter.getName() + " WON =====");
            } else {
                System.out.println("======= ENEMY FIGHTER WON =====");
            }

            System.exit(0);
        }
    }

}
