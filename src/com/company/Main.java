package com.company;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.initialize();
        game.setCurrentRoom(game.rooms.get(0));
        game.rooms.get(0).setRoomContent(game.rooms.get(0).getLampChoice().get(Lamp.NOLAMP));
        game.lampOn=false;

        Scanner keyboard = new Scanner(System.in);
        String pick=" ";

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
            System.out.println(" Total Earned Money: "+game.getEarnedMoney());
            if(currentRoom.isThereAlamp()||game.lampOn){
                if(game.lampOn){
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
                    Room rn=game.getCurrentRoom().getChoices().get(getChoice(pick));
                    rn.setRoomContent(rn.getLampChoice().get(Lamp.NOLAMP));
                    game.lampOn=true;
                }
                else {
                    System.out.println("There is a Lamp in this room. if you want to take it type \"Get Lump\" or type any key to go with out the Lamp ");
                    String lampChoice=keyboard.nextLine();
                    if(lampChoice.equalsIgnoreCase("get lamp")){
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
                        Room rn=game.getCurrentRoom().getChoices().get(getChoice(pick));
                        rn.setRoomContent(rn.getLampChoice().get(Lamp.NOLAMP));
                        game.lampOn=true;
                    }
                }



            }else{

            Iterator it = currentRoom.getChoices().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                System.out.println(pair.getKey());

            }

            System.out.println("Enter Your choice from the above list: ");
            pick = keyboard.nextLine();
            if(pick.equalsIgnoreCase("q")) {
                break;
            }
                game.setCurrentRoom(game.getCurrentRoom().getChoices().get(getChoice(pick)));
                Room rn=game.getCurrentRoom().getChoices().get(getChoice(pick));
                System.out.println(rn.getLampChoice().get(Lamp.NOLAMP));
               // rn.setRoomContent(rn.getLampChoice().get(Lamp.NOLAMP));
            }

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
