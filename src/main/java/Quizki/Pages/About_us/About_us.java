package Quizki.Pages.About_us;

import Quizki.Models.JsonHandler;
import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static Quizki.Models.Variables.picSize;
import static Quizki.Models.Variables.pic_filepath;
import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация информационного окна.
 * Содержит информацию о проекте, его разработке, а также о самих разработчиках.
 */

public class About_us {
    public static Pane about_us_p;
    public static Button b_back;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            about_us_p = new Pane();
            Scene scene = new Scene(about_us_p, Variables.appWidth, Variables.appHeight);
            try {
                // Добавление изображений разработчиков
                final Image anastasia = new Image(new FileInputStream(pic_filepath + "anastasia.jpg"));
                final Image maximilian = new Image(new FileInputStream(pic_filepath + "maximilian.png"));
                final Image pavel = new Image(new FileInputStream(pic_filepath + "pavel.jpg"));

                firstOption(about_us_p, anastasia, 10, 10, true);
                firstOption(about_us_p, maximilian, 10, picSize + 60, true);
                firstOption(about_us_p, pavel, 10, 2 * (picSize + 60), true);

                Label about_Anastasia = new Label
                        ("Имя: Анастасия \n" +
                                "Командная функция: Front-end-разработчик" +
                                "\nОписание: В нашем проекте Анастасия - единственная девушка, " +
                                "\nкоторая заниматься не только четким и гармоничным дизайном, " +
                                "\nно также ей присвоена роль Мотиватора и Вдохновителя, " +
                                "\nкоторая каждое утро в нашей общей конференции поднимает нам настроение, " +
                                "\nкидая смешные картинки с котятами и предлагая множество замечательных и гениальных идей, " +
                                "\nкоторые, благодаря ей, реализовываются проекте. :3" +
                                "\nКонтактные данные: -");
                firstOption(about_us_p, about_Anastasia, picSize + 20, 10, true);
                about_Anastasia.getStyleClass().add("about_us");

                Label about_Maximilian = new Label
                        ("Имя: Максимилиан \n" +
                                "Командная функция: DevOps-инженер" +
                                "\nОписание: Если про Анастасию можно было сказать, что она сердце проекта, " +
                                "\nто про Максимилиана можно сказать, " +
                                "\nчто он мозг системы, который всегда полон идеями и мыслями, " +
                                "\nблагодаря которому, все фишки и опции доработаны и функционируют идеально. " +
                                "\nБез его аналитического и дивергентного мышления проект создавался бы намного дольше и затруднительнее. " +
                                "\nСобрав все слова выше, можно с гордостью присвоить роль Аналитик и Координатор. =)" +
                                "\nКонтактные данные: maksimilianbegunov@inbox.ru");
                firstOption(about_us_p, about_Maximilian, picSize + 20, picSize + 60, true);
                about_Maximilian.getStyleClass().add("about_us");

                Label about_Pavel = new Label
                        ("Имя: Павел\n" +
                                "Командная функция: Back-end-разработчик\n" +
                                "Описание: Паша - это наша трудолюбивая пчелка\n" +
                                "Именно он создает основной функционал, на котором держится весь проект.\n" +
                                "Благодаря его умению ориентироваться в задачах и искать пути их решения, \n" +
                                "проект Quizki имеет такой комфортный интерфейс.\n" +
                                "В нашей команде он является Исполнителем и Коллективистом.\n" +
                                "С ним обсуждение никогда не бывает скучным, ведь он тот ещё шутник ;)\n" +
                                "Контактные данные: BzzB\uD83D\uDCA4");
                firstOption(about_us_p, about_Pavel, picSize + 20, 2 * (picSize + 60), true);
                about_Pavel.getStyleClass().add("about_us");

                b_back = new Button(Variables.curLanguageList.get("Back"));
                firstOption(about_us_p, b_back, 100, 700, true);
                b_back.setOnAction(_ -> {
                    Main.printScene();
                    Main.temp.setScene(Main.scene);}
                );

                firstOption(about_us_p, Variables.copyright, 5, Variables.appHeight - 20, true);
                Variables.copyright.getStyleClass().add("copyright");

                scene.getStylesheets().add("about_us_style.css");
                JsonHandler.changeColor(scene);
                Main.temp.setScene(scene);
            }   catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}