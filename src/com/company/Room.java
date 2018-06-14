package com.company;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private int id;
    private String name;
    private double prize;
    private String roomContent;
    private boolean isThereAMonster;
    private boolean isThereAlamp;
    public boolean isThereAlamp() {
        return isThereAlamp;
    }

    public void setThereAlamp(boolean thereAlamp) {
        isThereAlamp = thereAlamp;
    }




    public Map<Lamp, String> getLampChoice() {
        return lampChoice;
    }

    public void setLampChoice(Map<Lamp, String> lampChoice) {
        this.lampChoice = lampChoice;
    }





    public Room(int id, String name, double prize) {
        super();
        this.id = id;
        this.name = name;
        this.prize = prize;

    }
    private Map<Direction, Room> choices = new HashMap<>();
    private Map<Lamp, String> lampChoice = new HashMap<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getRoomContent() {
        return roomContent;
    }

    public void setRoomContent(String roomContent) {
        this.roomContent = roomContent;
    }

    public Map<Direction, Room> getChoices() {
        return choices;
    }

    public void setChoices(Map<Direction, Room> choices) {
        this.choices = choices;
    }

    public boolean isThereAMonster() {
        return isThereAMonster;
    }

    public void setThereAMonster(boolean isThereAMonster) {
        this.isThereAMonster = isThereAMonster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
}
