package com.example.sumi.schoolwar.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserProfile {

    private String name;
    private int hp_max, mp_max, hp_current, mp_current;
    private List<String> ailments;
    private List<String> itens;
    private int scene;
    private HashMap<String, Integer> returned_Ailments, returned_Items;

    public UserProfile() {
        this.name = "Jhon Doe";
        this.hp_max = 10;
        this.mp_max = 8;
        this.hp_current = 10;
        this.mp_current = 8;
        //this.ailments = new ArrayList<String>();
        this.ailments = Arrays.asList("Healthy", "Happy", "Happy");
        this.itens = Arrays.asList("Aspirin", "Cookie");
        this.scene = 0;
    }

    public UserProfile(String name, int hp_max, int mp_max, int hp_current, int mp_current, List<String> ailments, List<String> itens, int scene) {
        this.name = name;
        this.hp_max = hp_max;
        this.mp_max = mp_max;
        this.hp_current = hp_current;
        this.mp_current = mp_current;
        this.ailments = ailments;
        this.itens = itens;
        this.scene = scene;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

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
        returned_Ailments = new HashMap<String, Integer>();
        List<String> aux = new ArrayList<String>();
        for(String s : ailments){
            if (returned_Ailments.containsKey(s)){
                returned_Ailments.put(s, returned_Ailments.get(s) + 1);
            }else{
                returned_Ailments.put(s, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : returned_Ailments.entrySet()){
            aux.add(entry.getKey()+ " X " + entry.getValue().toString());
        }
        Collections.sort(aux);
        return aux;
    }

    public List<String> getItens() {
        returned_Items = new HashMap<String, Integer>();
        List<String> aux = new ArrayList<String>();
        for(String s : itens){
            if (returned_Items.containsKey(s)){
                returned_Items.put(s, returned_Items.get(s) + 1);
            }else{
                returned_Items.put(s, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : returned_Items.entrySet()){
            aux.add(entry.getKey()+ " X " + entry.getValue().toString());
        }
        Collections.sort(aux);
        return aux;
    }


}
