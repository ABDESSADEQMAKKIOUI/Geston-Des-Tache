package org.example.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Categorie {
    private static int id ;
    private String libelle ;
    private HashMap<String ,Task> tasks = new HashMap<String ,Task>();
    private static ArrayList<Categorie> categories = new ArrayList<>();


    public Categorie(String libelle)
    {
        id++;
        this.libelle = libelle;
        categories.add(this);
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<String, Task> tasks) {
        this.tasks = tasks;
    }

    public static ArrayList<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categorie> categories) {
        Categorie.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Categorie.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
