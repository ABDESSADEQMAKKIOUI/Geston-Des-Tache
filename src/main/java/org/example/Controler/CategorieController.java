package org.example.Controler;

import org.example.DAO.CategorieDAO;
import org.example.Model.Categorie;
import org.example.Model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class CategorieController implements InterfaceController {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void add() throws SQLException
    {
        Categorie categorie = saisie();
        CategorieDAO.addDBO(categorie);
    }

    @Override
    public void update() throws SQLException
    {
        System.out.println("Entrer libelle de catégorie:");
        String libelle = scanner.next();
        while (!CategorieDAO.categorieExist(libelle))
        {
            System.out.println("Cette catégorie n'existe pas !");
            System.out.println("-----------------------------");
            System.out.println("Entrer une libelle de catégorie qui existe:");
            libelle = scanner.next();
        }
        Categorie id = CategorieDAO.searchDAOByLibelle(libelle);
        System.out.println("Entrer nouveau libelle de catégorie:");
        String nouveauLibelle = scanner.next();
        Categorie categorie = new Categorie(id.getId(), nouveauLibelle);
        CategorieDAO.updateDBOByLibelle(libelle,categorie);
    }

    @Override
    public void delete()
    {
        System.out.println("Entrer libelle tu veux supprimer:");
        String libelle = scanner.next();
        while (!CategorieDAO.categorieExist(libelle))
        {
            System.out.println("cette catégorie n'existe pas pas !");
            System.out.println("------------------------------");
            System.out.println("Entrer une libelle de catégorie qui existe:");
            libelle = scanner.next();
        }
        CategorieDAO.deleteDOAByCode(libelle);
    }

    @Override
    public void getAll()
    {
        Categorie.getCategories().forEach(categorie -> System.out.println(categorie.toString()));
    }

    public void trieParAllCategorie()
    {
        Categorie.getCategories().forEach(categorie -> {
            System.out.println(categorie.toString() + " contient :");
            categorie.getTasks().forEach((s, task) -> System.out.println(task.toString()));
        });
    }


    @Override
    public Categorie saisie() throws SQLException
    {
        System.out.println("Entrer libelle de catégorie:");
        String libelle = scanner.next();
        while (CategorieDAO.categorieExist(libelle))
        {
            System.out.println("Cette catégorie existe déja ! ");
            System.out.println("-----------------------------");
            System.out.println("Entrer libelle de catégorie:");
            libelle = scanner.next();
        }
        return new Categorie(libelle);
    }
}
