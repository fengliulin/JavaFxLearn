package cc.chengheng.JavaFxBean;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

public class SelectBindingExample {
    public static void main(String[] args) {
        ObjectProperty<Lighting> root = new SimpleObjectProperty<>();

        final ObjectBinding<Color> colorBinding = Bindings.select(root, "light", "color");

        colorBinding.addListener((o, oldValue, newValue) -> {
            System.out.println("\tThe color changed:\n\t\told color = " + oldValue + ",\n\t\tnew color = " + newValue);
        });


        Light firstLight = new Light.Point();
        firstLight.setColor(Color.BLACK);


        Light secondLight = new Light.Point();
        secondLight.setColor(Color.WHITE);


        Lighting firstLighting = new Lighting();
        firstLighting.setLight(firstLight);



        Lighting secondLighting = new Lighting();
        secondLighting.setLight(secondLight);



        root.set(firstLighting);


        root.set(secondLighting);


        secondLighting.setLight(firstLight);

        firstLight.setColor(Color.RED);
    }
}