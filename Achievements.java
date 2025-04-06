/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.excersize;

import java.util.ArrayList;

/**
 *
 * @author Anikah
 */
public class Achievements extends User{
    private String achievementName;
    private ArrayList<String> achievements;

    
    public Achievements(String achievementName, String username){
        this.achievementName = achievementName;
        super(username);
    }
    public String getName(){
        return achievementName;
    }
    public void isUnlocked(String name){
       /*for (String achievementName: achievements){
            if (achievementName.getName().equalsIgnoreCase(name)){
                achievements.remove(item);
                System.out.println(name + " removed Successfully");
                return true;
            }
        }
        System.out.println(name+ " not found");
        return false;*/
    }
    
}
