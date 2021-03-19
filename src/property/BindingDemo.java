package property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingDemo {
    public static void main(String[] args) {
        // X = Y+Z
        IntegerProperty aProp = new SimpleIntegerProperty(23);
        System.out.println("A prop: " + aProp.get());
        IntegerProperty bProp = new SimpleIntegerProperty(24);
        aProp.bind(bProp);
        System.out.println("A prop: " + aProp.get());
        aProp.unbind();
        aProp.set(26);
        System.out.println("A prop: " + aProp.get());
    }
}
