package com.company;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.initialize();
        game.setCurrentRoom(game.rooms.get(0));
        Scanner keyboard = new Scanner(System.in);
        String pick;

        do {

            Room currentRoom = game.getCurrentRoom();

            System.out.println("You are standing in " + currentRoom.getName());
            System.out.println("You see " + currentRoom.getRoomContent());

            game.vistedRooms.add(game.getCurrentRoom());
            System.out.printf("There is  %.2f dollar in the room.Do you want to take it? press Y or N %n",game.getCurrentRoom().getPrize());
            String takeOrLeave=keyboard.nextLine();
            if(takeOrLeave.equalsIgnoreCase("y")) {
                game.earnedMoney += currentRoom.getPrize();
                currentRoom.setPrize(0);
            }

            if (currentRoom.isThereAMonster())
            {
                game.setEarnedMoney(0);
                System.out.println("Oops a monster at "+ currentRoom.getName() +" just took all your money");

            }
            if(currentRoom.isThereAlamp()){

            }

            System.out.println(" Total Earned Money: "+game.getEarnedMoney());


            Iterator it = currentRoom.getChoices().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                System.out.println(pair.getKey());

            }

            System.out.println("Enter Your choice from the above list: ");
            pick = keyboard.nextLine();
            if(pick.equalsIgnoreCase("q"))
                break;
            game.setCurrentRoom(game.getCurrentRoom().getChoices().get(getChoice(pick)));

        } while (!pick.equalsIgnoreCase("q"));

        System.out.println(" total rooms visited: "+game.vistedRooms.size());

        keyboard.close();

    }

    public static Direction getChoice(String pick) throws Exception {
        if (pick.equalsIgnoreCase("north"))
            return Direction.NORTH;
        else if (pick.equalsIgnoreCase("south"))
            return Direction.SOUTH;
        else if (pick.equalsIgnoreCase("east"))
            return Direction.EAST;

        else if (pick.equalsIgnoreCase("west"))
            return Direction.WEST;


        else
            throw new Exception("invalid input Exception " + pick);

    }

}
