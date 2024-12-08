package Quizki.Pages.About_us;
import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Реализация информационного окна.
 * Содержит информацию о проекте, его разработке, а также о самих разработчиках.
 */

public class About_us {
    public static Pane p;
    public static Button b_back;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();
            Scene scene = new Scene(p, Variables.appWidth+400, Variables.appHeight);

            Label about_Anastasia = new Label
                    ("Имя: Анастасия \n" +
                            "Командная роль: Front-end" +
                            "\nОписание: В нашем проекте Анастасия - единственная девушка, " +
                            "\nкоторая заниматься не только четким и гармоничным дизайном, " +
                            "\nно также ей присвоена роль Мотиватора и Вдохновителя, " +
                            "\nкоторая каждое утро в нашей общей конференции поднимает нам настроение, " +
                            "\nкидая смешные картинки с котятами и предлагая множество замечательных и гениальных идей, " +
                            "\nкоторые, благодаря ей, реализовываются проекте. :3");
            firstOption(about_Anastasia, 100, 100, true);
            Label about_Maximilian = new Label
                    ("Имя: Максимилиан \n" +
                            "Командная роль: Back-end" +
                            "\nОписание: Если про Анастасию можно было сказать, что она сердце проекта, " +
                            "\nто про Максимилиана можно сказать, " +
                            "\nчто он мозг системы, который всегда полон идеями и мыслями, " +
                            "\nблагодаря которому, все фишки и опции доработаны и функционируют идеально. " +
                            "\nБез его аналитического и дивергентного мышления проект создавался бы намного дольше и затруднительнее. " +
                            "\nСобрав все слова выше, можно с гордостью присвоить роль Аналитик и Координатор. =)");
            firstOption(about_Maximilian, 100, 300, true);

            Label about_Pasha = new Label
                    ("Имя: Павел \n" +
                            "Командная роль: Back-end" +
                            "\nОписание: Памагити");
            firstOption(about_Pasha, 100, 500, true);

            b_back = new Button("Назад");
            firstOption(b_back, 0, 500, true);


            b_back.setOnAction(_ -> Main.temp.setScene(Main.scene));

            scene.getStylesheets().add("about_us_style.css");
            Main.temp.setScene(scene);
        }
        private void firstOption(Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
    }

}