package pl.sudoku.game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import pl.sudoku.game.database.entities.Result;
import pl.sudoku.game.entities.enums.Difficulties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TopListController {

    @FXML
    private ListView<String> resultList;

    @FXML
    private void initialize() {
        String hql = "FROM Result r ORDER BY r.points DESC";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toplist");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Result> query = em.createQuery(hql,
                Result.class);
        List<Result> fromDb = query.getResultList();

        for (Result r : fromDb) {
            resultList.getItems().add(r.toString());
        }

//        resultList.getItems().addAll(fromDb.toString());
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScene(event, SceneSwitcher.MAIN_MENU_SCENE, Difficulties.MEDIUM);
    }
}
