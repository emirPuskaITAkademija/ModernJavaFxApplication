package property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ProperyDemo {
    public static void main(String[] args) {
        Integer number = 23;
        IntegerProperty numberProperty = new SimpleIntegerProperty(23);
        numberProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Stara vrijednost: " + oldValue+", a nova vrijednost: " + newValue);
            }
        });
        System.out.println(numberProperty.get());
        numberProperty.set(24);//changed
        System.out.println(numberProperty.get());
        System.out.println("Not JavaFx: " + number);
        number = 24;
        System.out.println("Not JavaFx: " + number);
        numberProperty.set(24);//changed
        numberProperty.set(25);//changed

    }
}
