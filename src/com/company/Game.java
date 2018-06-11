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
        Room foyerRoom = new Room(1, "foyer", 1 + randMoney.nextInt(1000), "dead scorpion");
        Room frontRoom = new Room(2, "front room", 1 + randMoney.nextInt(1000), "piano");
        Room libraryRoom = new Room(3, "library", 1 + randMoney.nextInt(1000), "spider");
        Room kitchenRoom = new Room(4, "kitchen", 1 + randMoney.nextInt(1000), "bats");
        Room diningRoom = new Room(5, "dining room", 1 + randMoney.nextInt(1000), "dust,empty box");
        Room vaultRoom = new Room(6, "vault", 1 + randMoney.nextInt(1000), "3 walking skeleton");
        Room parlorRoom = new Room(7, "parlor", 1 + randMoney.nextInt(1000), "treasure chest");
        Room secretRoom = new Room(8, "secrete room", 1 + randMoney.nextInt(1000), "piles of gold");

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

        rooms.add(foyerRoom);
        rooms.add(kitchenRoom);
        rooms.add(parlorRoom);
        rooms.add(vaultRoom);
        rooms.add(diningRoom);
        rooms.add(libraryRoom);
        rooms.add(secretRoom);
        rooms.add(frontRoom);
        putMonster();

    }

    void putMonster() {
        Random rand = new Random();
        int monsterroomID= rand.nextInt(8)+1;
        for (Room room: rooms)
        {
            if(room.getId()==monsterroomID)
                room.setThereAMonster(true);
        }


    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
