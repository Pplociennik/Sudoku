package pl.sudoku.game.database.controllers;

import pl.sudoku.game.database.entities.Result;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DatabaseController {

    public void sendResult(Result result) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toplist");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(result);
        tx.commit();

        em.close();
        emf.close();
    }

}
