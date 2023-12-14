package org.example.Service;

import org.example.Controler.CategorieController;
import org.example.Controler.TaskController;
import org.example.Controler.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class ServiceUser {
    Scanner scanner = new Scanner(System.in);
    TaskController taskController = new TaskController();
    UserController userController =new UserController();
    CategorieController categorieController = new CategorieController();
    public void gestionaDesTaches() throws SQLException {
        System.out.println("entrer   3 pour aficher les taches avec leur emploi du temp ");
        System.out.println("entrer   6 pour afficher  les historiques");
        System.out.println("entrer   7 pour retone a menu principal ");
        int n = scanner.nextInt();
        switch (n) {

            case 1: {
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

            case 2: {
                //apel affchage history
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
                choixUser();
                break ;
            }


            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }

        }

    }

    public void gestionDesCategories() throws SQLException {
        System.out.println("entrer   1 pour aficher les tache d'un categorie");
        System.out.println("entrer   2 pour aficher  categories et ses taches");
        System.out.println("entrer   3 pour retone a menu principal ");
        int n = scanner.nextInt();
        switch (n) {

            case 1: {
                categorieController.trieParCategorie();
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

            case 3: {
                choixUser();
                break ;
            }


            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }

        }

    }

    public void choixUser() throws SQLException {

        System.out.println("entrer   1 pour la gestion des tache");
        System.out.println("entrer   2 pour la gestion des categories");
        System.out.println("entrer   3 pour areter le programe");
        int n = scanner.nextInt();
        switch (n) {
            case 1: {
                gestionaDesTaches();
                break;
            }

            case 2: {
                gestionDesCategories();
                break ;
            }

            case 3: {
                System.out.println("sission is end");
                break ;
            }


            default:{
                throw new IllegalArgumentException("Unexpected value: " + n);
            }

        }
    }
}
