package com.company;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private int id;
    private String name;
    private double prize;
    private String roomContent;
    private boolean isThereAMonster;

    public boolean isThereAlamp() {
        return isThereAlamp;
    }

    public void setThereAlamp(boolean thereAlamp) {
        isThereAlamp = thereAlamp;
    }

    private boolean isThereAlamp;

    public Room(int id, String name, double prize, String roomContent) {
        super();
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.roomContent = roomContent;
    }
    private Map<Direction, Room> choices = new HashMap<>();

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
}
