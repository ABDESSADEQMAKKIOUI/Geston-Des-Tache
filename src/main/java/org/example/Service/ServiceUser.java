package org.example.Service;

import org.example.Controler.CategorieController;
import org.example.Controler.HistoryController;
import org.example.Controler.TaskController;
import org.example.Controler.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class ServiceUser {
    Scanner scanner = new Scanner(System.in);
    TaskController taskController = new TaskController();
    HistoryController historyController = new HistoryController();
    CategorieController categorieController = new CategorieController();

    public void gestionaDesTaches() throws SQLException {
        System.out.println("entrer   1 pour afficher les taches avec leur emploi du temp ");
        System.out.println("entrer   2 pour afficher  les historiques");
        System.out.println("entrer   3 pour afficher  les tache par priority");
        System.out.println("entrer   4 pour retour a menu principal ");
        int n = scanner.nextInt();
        switch (n)
        {
            case 1: {
                taskController.trieTaskWithDate();
                System.out.println("enter y pour accéde a la menu precedent");
                String b = scanner.next();
                if (b.equals("y"))
                {
                    gestionaDesTaches();
                }
                else {
                    break;
                }
                break ;
            }
            case 2: {
                historyController.getAll();
                System.out.println("enter y pour accéde a la menu precedent");
                String b = scanner.next();
                if (b.equals("y")){
                    gestionaDesTaches();
                }
                else {
                    break;
                }

                break ;
            }
            case 3: {
                taskController.trieTaskWithPriority();
                System.out.println("enter y pour accéde a la menu precedent");
                String b = scanner.next();
                if (b.equals("y")){
                    gestionaDesTaches();
                }
                else {
                    break;
                }

                break ;
            }
            case 4: {
                choixUser();
                break ;
            }
            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }
        }
    }

    public void gestionDesCategories() throws SQLException
    {
        System.out.println("entrer   1 pour afficher les tache par id categorie ");
        System.out.println("entrer   2 pour afficher all categorie");
        System.out.println("entrer   3 pour retour a menu principal ");
        int n = scanner.nextInt();
        switch (n)
        {
            case 1: {
                taskController.trieTaskWithCategory();
                System.out.println("enter y pour accéde a la menu precedent");
                String b = scanner.next();
                if (b.equals("y")){
                    gestionDesCategories();
                }
                else {
                    break;
                }
                break ;
            }
            case 2: {
                categorieController.getAll();
                System.out.println("enter y pour accéde a la menu precedent");
                String b = scanner.next();
                if (b.equals("y")){
                    gestionDesCategories();
                }
                else {
                    break;
                }
                break;
            }
            case 3: {
                choixUser();
                break ;
            }
            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }
        }
    }

    public void choixUser() throws SQLException
    {
        System.out.println("entrer   1 pour la gestion des tache");
        System.out.println("entrer   2 pour la gestion des categories");
        System.out.println("entrer   3 pour stop program");
        int n = scanner.nextInt();
        switch (n)
        {
            case 1: {
                gestionaDesTaches();
                break;
            }
            case 2: {
                gestionDesCategories();
                break ;
            }
            case 3: {
                System.out.println("session is end");
                break ;
            }
            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }
        }
    }
}
