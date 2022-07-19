package Core;

import java.text.MessageFormat;
import java.util.Scanner;

public class CharacterBuilder {
    FighterBase playerFighter = new FighterBase();
    String fighterName = "";

    public FighterBase characterBuildProcedure() {
        System.out.println("===== FIGHTER CREATION =====");
        setPlayerFighterName();
        System.out.println("Fighter Stats sheet");
        playerFighter.displayStats();
        checkReroll();
        setStatsPoint();
        finalizeCharacter();

        return playerFighter;
    }

    public void setPlayerFighterName() {
        System.out.println("Choose your character name");
        Scanner scanner = new Scanner(System.in);
        fighterName = scanner.nextLine();
        playerFighter.setName(fighterName);
    }

    public void checkReroll() {
        boolean waitPlayer = true;
        while (waitPlayer) {
            System.out.println("Type [r] to reroll a new character OR type [y] to continue...");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.charAt(0) == 'r') {
                playerFighter = new FighterBase(fighterName);
                playerFighter.displayStats();
            } else if (input.charAt(0) == 'y')
                waitPlayer = false;
        }

    }

    public void setStatsPoint() {
        int remainingPoint = 4;
        while (remainingPoint != 0) {
            String message = MessageFormat.format(
                    "Assign your stats point (Remaining: {0}) \n 1 - STR \n 2 - AGI \n 3 - CON", remainingPoint);
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            switch (input.charAt(0)) {
                case '1':
                    playerFighter.setStrength(playerFighter.getStrength() + 1);
                    remainingPoint--;
                    break;
                case '2':
                    playerFighter.setAgility(playerFighter.getAgility() + 1);
                    remainingPoint--;
                    break;
                case '3':
                    playerFighter.setConstitution(playerFighter.getConstitution() + 1);
                    remainingPoint--;
                    break;
                default:
                    System.out.println("Option not found");
                    break;
            }
            playerFighter.displayStats();
        }
    }

    public void finalizeCharacter() {

        System.out.println("===== YOUR FIGHTER =====");
        playerFighter.displayStats();
        System.out.println("\n Enter any character to continue...");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
