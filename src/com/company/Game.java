package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Game {
    List<Room> rooms = new ArrayList<>();
    Set<Room> vistedRooms = new HashSet<>();
    double earnedMoney;
    boolean lampOn;
    Room currentRoom;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Room> getVistedRooms() {
        return vistedRooms;
    }

    public void setVistedRooms(Set<Room> vistedRooms) {
        this.vistedRooms = vistedRooms;
    }

    public double getEarnedMoney() {
        return earnedMoney;
    }

    public void setEarnedMoney(double earnedMoney) {
        this.earnedMoney = earnedMoney;
    }

    public void initialize() {
        Random randMoney = new Random();
        Room foyerRoom = new Room(1, "foyer", 1 + randMoney.nextInt(1000));
        Room frontRoom = new Room(2, "front room", 1 + randMoney.nextInt(1000));
        Room libraryRoom = new Room(3, "library", 1 + randMoney.nextInt(1000));
        Room kitchenRoom = new Room(4, "kitchen", 1 + randMoney.nextInt(1000));
        Room diningRoom = new Room(5, "dining room", 1 + randMoney.nextInt(1000));
        Room vaultRoom = new Room(6, "vault", 1 + randMoney.nextInt(1000));
        Room parlorRoom = new Room(7, "parlor", 1 + randMoney.nextInt(1000));
        Room secretRoom = new Room(8, "secrete room", 1 + randMoney.nextInt(1000));

        Map<Direction, Room> foyerChoice = new HashMap<>();
        foyerChoice.put(Direction.NORTH, frontRoom);
        foyerRoom.setChoices(foyerChoice);

        Map<Direction, Room> frontChoice = new HashMap<>();
        frontChoice.put(Direction.SOUTH, foyerRoom);
        frontChoice.put(Direction.WEST, libraryRoom);
        frontChoice.put(Direction.EAST, kitchenRoom);
        frontRoom.setChoices(frontChoice);

        Map<Direction, Room> libraryChoice = new HashMap<>();
        libraryChoice.put(Direction.EAST, frontRoom);
        libraryChoice.put(Direction.NORTH, diningRoom);
        libraryRoom.setChoices(libraryChoice);

        Map<Direction, Room> kitchenChoice = new HashMap<>();
        kitchenChoice.put(Direction.WEST, frontRoom);
        kitchenChoice.put(Direction.NORTH, parlorRoom);
        kitchenRoom.setChoices(kitchenChoice);

        Map<Direction, Room> diningChoice = new HashMap<>();
        diningChoice.put(Direction.SOUTH, libraryRoom);
        diningRoom.setChoices(diningChoice);

        Map<Direction, Room> parlorChoice = new HashMap<>();
        parlorChoice.put(Direction.WEST, vaultRoom);
        parlorChoice.put(Direction.SOUTH, kitchenRoom);
        parlorRoom.setChoices(parlorChoice);

        Map<Direction, Room> secreteChoice = new HashMap<>();
        secreteChoice.put(Direction.WEST, vaultRoom);
        secretRoom.setChoices(secreteChoice);

        Map<Direction, Room> vaultChoice = new HashMap<>();
        Random rand = new Random();
        int prob = rand.nextInt(4);
        if (prob == 0)
            vaultChoice.put(Direction.EAST, secretRoom);

        else
            vaultChoice.put(Direction.EAST, parlorRoom);

        vaultRoom.setChoices(vaultChoice);

        Map<Lamp, String> foyerContent = new HashMap<>();
        foyerContent.put(Lamp.LAMP, "dead scorpion and has a spider web made from pure silk containing gold coins");
        foyerContent.put(Lamp.NOLAMP,"dead scorpion");
        foyerRoom.setLampChoice(foyerContent);

        Map<Lamp, String> frontContent = new HashMap<>();
        frontContent.put(Lamp.LAMP, "piano and the piano has the sheet music for your favorite song");
        frontContent.put(Lamp.NOLAMP, "piano");
        frontRoom.setLampChoice(frontContent);

        Map<Lamp, String> libraryContent = new HashMap<>();
        libraryContent.put(Lamp.LAMP, "spider and scroll on the wall with a secret message.");
        libraryContent.put(Lamp.NOLAMP, "spider");
        libraryRoom.setLampChoice(libraryContent);

        Map<Lamp, String> kitchenContent = new HashMap<>();
        kitchenContent.put(Lamp.LAMP, "bats and a refrigerator full of your favorite food/drink");
        kitchenContent.put(Lamp.NOLAMP, "bats");
        kitchenRoom.setLampChoice(kitchenContent);

        Map<Lamp, String> diningContent = new HashMap<>();
        frontContent.put(Lamp.LAMP, "dust a box which contains an Amazon gift card which you can take if you type \"Get Gift Card\". ");
        frontContent.put(Lamp.NOLAMP, "dust,empty box");
        frontRoom.setLampChoice(diningContent);

        Map<Lamp, String> parlorContent = new HashMap<>();
        parlorContent.put(Lamp.LAMP, "treasure chest and also has a portrait of your favorite movie star and tickets to their latest" +
                " movie which you can take in case you ever get out of the  house");
        parlorContent.put(Lamp.NOLAMP, "treasure chest");
        parlorRoom.setLampChoice(parlorContent);

        Map<Lamp, String> secreteContent = new HashMap<>();
        secreteContent.put(Lamp.LAMP, "contains a map of the house along with the piles of gold. The user can take the map or gold or both");
        secreteContent.put(Lamp.NOLAMP, "piles of gold");
        secretRoom.setLampChoice(secreteContent);

        Map<Lamp, String> vaultContent = new HashMap<>();
        vaultContent.put(Lamp.LAMP, "3 walking skeleton");
        vaultContent.put(Lamp.NOLAMP, "3 walking skeleton");
        vaultRoom.setLampChoice(vaultContent);



        rooms.add(foyerRoom);
        rooms.add(kitchenRoom);
        rooms.add(parlorRoom);
        rooms.add(vaultRoom);
        rooms.add(diningRoom);
        rooms.add(libraryRoom);
        rooms.add(secretRoom);
        rooms.add(frontRoom);
        putMonster();
        putLamp();

    }

    void putMonster() {
        Random rand = new Random();
        int monsterroomID= rand.nextInt(8)+1;
        for (Room room: rooms)
        {
            if(room.getId()==monsterroomID) {
                room.setThereAMonster(true);

            }
        }


    }
    void putLamp() {
        Random rand = new Random();
        int monsterroomID= rand.nextInt(8)+1;
        for (Room room: rooms)
        {
            if(room.getId()==monsterroomID) {
                room.setThereAlamp(true);
            }
        }


    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
