/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.termcardgame;
/**
 *
 * @author SebastianR
 */
import com.mycompany.termcardgame.Player;
import com.mycompany.termcardgame.Player;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    private String name;
    private List<Player> players;

    public Game(String name, int startingChips, List<String> playerNames) {
        this.name = name;
        players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName, startingChips));
        }
    }


    public abstract void play();


    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
