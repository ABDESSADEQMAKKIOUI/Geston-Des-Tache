package org.example.Service;

import org.example.Controler.CategorieController;
import org.example.Controler.HistoryController;
import org.example.Controler.TaskController;
import org.example.Controler.UserController;

import java.sql.SQLException;
import java.util.Scanner;



public class ServiceAdmin {

    Scanner scanner = new Scanner(System.in);
    TaskController taskController = new TaskController();
    HistoryController historyController = new HistoryController();
    UserController userController =new UserController();
    CategorieController categorieController = new CategorieController();

    public void gestionaDesTaches() throws SQLException
    {
        System.out.println("entrer   1 pour ajouter une tache");
        System.out.println("entrer   2 pour affecter une tache a un utilisateur");
        System.out.println("entrer   3 pour afficher les taches avec leur emploi du temp ");
        System.out.println("entrer   4 pour modifier  une tache");
        System.out.println("entrer   5 pour supprimer  une tache");
        System.out.println("entrer   6 pour afficher  les historiques");
        System.out.println("entrer   7 pour aficher  les tache par priority");
        System.out.println("entrer   8 pour retone a menu principal ");
        int n = scanner.nextInt();
        switch (n)
        {
            case 1: {
                taskController.add();
                System.out.println("tu veut ajouter une nouveaux tache y/n");
                String b = scanner.next();
                while (b.equals("y")) {
                    taskController.add();
                    System.out.println("tu veut ajouter une nouveaux tache y/n");
                    b = scanner.next();
                }
                gestionaDesTaches();
                break;
            }

            case 2: {
                taskController.affecterTache();
                System.out.println("tu veut affecter une nouveaux tache a un user y/n");
                String b = scanner.next();
                while (b.equals("y")) {
                    taskController.affecterTache();
                    System.out.println("tu veut affecter une nouveaux tache a un user y/n");
                    b = scanner.next();
                }
                gestionaDesTaches();
                break ;
            }
            case 3: {
                    taskController.trieTaskWithDate();
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
             taskController.update();
                System.out.println("tu veut modifier une nouveaux tache y/n");
                String b = scanner.next();
                while (b.equals("y"))
                {
                    taskController.update();
                    System.out.println("tu veut modifier une nouveaux tache y/n");
                    b = scanner.next();
                }
                gestionaDesTaches();
                break ;
            }
            case 5: {
                taskController.delete();
                System.out.println("tu veut supprimer une nouveaux tache y/n");
                String b = scanner.next();
                while (b.equals("y")) {
                    taskController.delete();
                    System.out.println("tu veut supprimer une nouveaux tache y/n");
                    b = scanner.next();
                }
                gestionaDesTaches();

                break ;
            }
            case 6: {
                historyController.getAll();
                System.out.println("tu veux accéde à la menu précèdent y/n");
                String b = scanner.next();
                if (b.equals("y")){
                    gestionaDesTaches();
                }
                else {
                    break;
                }
                break ;
            }
            case 7: {
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
            case 8: {
                choixAdmin();
                break ;
            }
            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }
        }
    }

    public void gestionDesUtilisateurs() throws SQLException
    {
        System.out.println("entrer   1 pour ajouter un utilisateur");
        System.out.println("entrer   2 pour modifier  un utilisateur");
        System.out.println("entrer   3 pour suprimer  un utilisateur");
        System.out.println("entrer   4 pour retone a menu principal ");
        int n = scanner.nextInt();
        switch (n) {
            case 1: {
                userController.add();
                System.out.println("tu veut ajouter un nouveaux utilisateur y/n");
                String b = scanner.next();
                while (b.equals("y")) {
                    userController.add();
                    System.out.println("tu veut ajouter un nouveaux utilisateur y/n");
                    b = scanner.next();
                }
                userController.update();
                break;
            }

            case 2: {
                userController.update();
                System.out.println("tu veut modfier un nouveaux utilisateur y/n");
                String b = scanner.next();
                while (b.equals("y")) {
                    userController.update();
                    System.out.println("tu veut modfier un nouveaux utilisateur y/n");
                    b = scanner.next();
                }
                userController.update();
                break ;
            }
            case 3: {
                userController.delete();
                System.out.println("tu veut suprimer un nouveaux utilisateur y/n");
                String b = scanner.next();
                while (b.equals("y")) {
                    userController.delete();
                    System.out.println("tu veut suprimer un nouveaux utilisateur y/n");
                    b = scanner.next();
                }
                gestionDesUtilisateurs();

                break ;
            }
            case 4: {
                choixAdmin();

                break ;
            }
            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }

    }
    }
    public void gestionDesCategories() throws SQLException {
        System.out.println("entrer   1 pour ajouter un categorie");
        System.out.println("entrer   2 pour modifier  un categorie");
        System.out.println("entrer   3 pour suprimer  un categorie");
        System.out.println("entrer   4 pour aficher les tache d'un categorie");
        System.out.println("entrer   5 pour aficher  categories et ses taches");
        System.out.println("entrer   6 pour retone a menu principal ");
            int n = scanner.nextInt();
            switch (n) {
                case 1: {
                    categorieController.add();
                    System.out.println("tu veut ajouter une nouveaux categorie y/n");
                    String b = scanner.next();
                    while (b.equals("y")) {
                        categorieController.add();
                        System.out.println("tu veut ajouter une nouveaux categorie y/n");
                        b = scanner.next();
                    }
                   gestionDesCategories();
                    break;
                }

                case 2: {
                    categorieController.update();
                    System.out.println("tu veut modfier un nouveaux categorie y/n");
                    String b = scanner.next();
                    while (b.equals("y")) {
                        categorieController.update();
                        System.out.println("tu veut modfier un nouveaux categorie y/n");
                        b = scanner.next();
                    }
                    gestionDesCategories();
                    break ;
                }
                case 3: {
                    categorieController.delete();
                    System.out.println("tu veut suprimer un nouveaux categorie y/n");
                    String b = scanner.next();
                    while (b.equals("y")) {
                        categorieController.delete();
                        System.out.println("tu veut suprimer un nouveaux categorie y/n");
                        b = scanner.next();
                    }
                    gestionDesCategories();

                    break ;
                }
                case 4: {
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
                case 5: {
                    categorieController.trieParAllCategorie();
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

                case 6: {
                    choixAdmin();
                    break ;
                }


                default:{
                    throw new IllegalArgumentException("Unexpected value: " + n);
                }

            }

    }

    public void choixAdmin() throws SQLException {

            System.out.println("entrer   1 pour la gestion des tache");
            System.out.println("entrer   2 pour la gestion des utilisateurs");
            System.out.println("entrer   3 pour la gestion des categories");
            System.out.println("entrer   4 pour areter le programe");
             int n = scanner.nextInt();
            switch (n) {
                case 1: {
                     gestionaDesTaches();
                    break;
                }

                case 2: {
                    gestionDesUtilisateurs();
                    break ;
                }
                case 3: {
                    gestionDesCategories();
                    break ;
                }

                case 5: {
                    System.out.println("sission is end");
                    break ;
                }


                default:{
                    throw new IllegalArgumentException("Unexpected value: " + n);
            }

        }
    }
}
