package com.shs.nxstudy.no2_generic.commit.homework1;

public class Son extends Father{
    private String game;

    public Son(String name, String work,String game) {
        super(name, work);
        this.game = game;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
