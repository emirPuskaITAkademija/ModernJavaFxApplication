package controller;

import dao.ShowDao;
import dao.connection.ConnectionPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Show;

import java.sql.SQLException;
import java.util.List;

public class ShowController {

    public ObservableList<Show> loadShows(){
        ObservableList<Show> showObservableList= FXCollections.observableArrayList();
        try {
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);
            List<Show> showList = showDao.retrieveAll();
            showObservableList.addAll(showList);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return showObservableList;
    }
}
