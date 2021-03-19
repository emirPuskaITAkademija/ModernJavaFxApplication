package property;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class FxCollectionDemo {
    public static void main(String[] args) {
        //Chelsea - Juventus: 1-2
        ObservableList<Integer> matchScore = FXCollections.observableArrayList(1, 2);
        matchScore.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                System.out.format("Listener1: Chelsea-Juventus: %d - %d%n", c.getList().get(0), c.getList().get(1));
            }
        });
        matchScore.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                System.out.format("Listener2: Chelsea-Juventus: %d - %d%n", c.getList().get(0), c.getList().get(1));
            }
        });
        matchScore.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                System.out.format("Listener3: Chelsea-Juventus: %d - %d%n", c.getList().get(0), c.getList().get(1));
            }
        });
        matchScore.set(1, 3);
    }
}
