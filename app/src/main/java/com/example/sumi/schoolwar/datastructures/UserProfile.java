package com.example.sumi.schoolwar.datastructures;

import java.util.List;

public class UserProfile {

    private String name;
    private int hp_max, mp_max, hp_current, mp_current;
    private List<String> ailments;
    private List<String> itens;

    public void take_hit(int amount){
        hp_current =- amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp_max() {
        return hp_max;
    }

    public void setHp_max(int hp_max) {
        this.hp_max = hp_max;
    }

    public int getMp_max() {
        return mp_max;
    }

    public void setMp_max(int mp_max) {
        this.mp_max = mp_max;
    }

    public int getHp_current() {
        return hp_current;
    }

    public void setHp_current(int hp_current) {
        this.hp_current = hp_current;
    }

    public int getMp_current() {
        return mp_current;
    }

    public void setMp_current(int mp_current) {
        this.mp_current = mp_current;
    }

    public List<String> getAilments() {
        return ailments;
    }

    public List<String> getItens() {
        return itens;
    }


}
