package Quizki.Create;

import Quizki.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.util.ArrayList;

public class Create {
    public static ComboBox<String> langsComboBox;
    public static TextField tf_face_card, tf_back_card;
    public static Button b_plus, b_minus;
    public static VBox p;
    public static ArrayList<TextField> tf_list = new ArrayList<TextField>();
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            ObservableList<String> langs = FXCollections.observableArrayList("Test", "Card");
            langsComboBox = new ComboBox<String>(langs);
            langsComboBox.setValue("Card");
            langsComboBox.setOnAction(new Events.ChangeType());

            TextField tf_name = new TextField();
            TextField tf_describe = new TextField();
            tf_face_card = new TextField();
            tf_back_card = new TextField();
            tf_face_card.setVisible(false);
            tf_back_card.setVisible(false);



            Button b_create = new Button("Create");
            b_create.setOnAction(new Events.ChangeScene());

            Button b_back = new Button("Back");
            b_plus = new Button("+1");
            b_minus = new Button("-1");
            b_plus.setOnAction(new Events.AddTf());
            b_minus.setOnAction(new Events.DelTf());
            b_plus.setVisible(false);

            p = new VBox(tf_name, tf_describe, langsComboBox, tf_face_card, tf_back_card, b_create, b_back, b_plus, b_minus);
            Scene scene = new Scene(p, 500, 600);
            Main.temp.setScene(scene);
        }

    }
}
