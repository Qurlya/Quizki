package Quizki.Pages.Create;

import Quizki.Models.Card;
import Quizki.Models.Collect;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

/**
 * Реализация событий для кнопок функционального окна Create (см. Create).
 */

public class Events {

    // Создание теста (запись в файл JSON)
    static class CreateCollect implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // Нижний предел на количество карточек - хотя бы 4
            if (Create.arr_card.size() < 4) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_UnderLimit"));
                Create.alert.showAndWait();
            } else if (Create.tf_name.getText().isEmpty() || Create.tf_describe.getText().isEmpty()) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_EmptyName"));
                Create.alert.showAndWait();
            } else if (!parseString(Create.tf_name.getText())) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_SpecSymbols"));
                Create.alert.showAndWait();
            } else if (Create.tf_name.getText().trim().equals("__user__")) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_UserFile"));
                Create.alert.showAndWait();
            } else {
                Main.temp.setScene(Main.scene);
                Collect collect = new Collect(Create.tf_name.getText(), Create.tf_describe.getText());
                collect.setCard_set(Create.arr_card);
                String path = Variables.card_filepath + Create.tf_name.getText() + ".json";
                // Добавить окно "прогресса создания"
                try {
                    JsonHandler.saveToFile(collect, path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // Парсер строки на специальные символы
        private static boolean parseString(String stringToParse){
            char[] temp = stringToParse.toCharArray();
            char[] specialChars = {'/', '\\', '?', '!', '.', '*', '>', '<', '"', ':', '|'};
            for (char spec : specialChars){
                for (char c : temp){
                    if(c == spec){
                        return false;
                    }
                }
            }
            return true;
            /*ArrayList<Character> charToParse = new ArrayList<>();
            for (char c : temp){
                charToParse.add(c);
            }
            return !charToParse.contains('/')
                    && !charToParse.contains('.')
                    && !charToParse.contains('\\')
                    && !charToParse.contains('*')
                    && !charToParse.contains('?')
                    && !charToParse.contains('!')
                    && !charToParse.contains('>')
                    && !charToParse.contains('<')
                    && !charToParse.contains('|')
                    && !charToParse.contains(':')
                    && !charToParse.contains('"');*/
        }
    }

    // Изменение действующей сцены на главную страницу
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Main.scene);
        }
    }

    // Добавление карточки в коллекцию
    static class AddCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            String face, back;
            face = Create.tf_face_card.getText();
            back = Create.tf_back_card.getText();
            // Верхний и нижний пределы на количество символов в вопросе/ответе
            if (face.length() > Variables.inputLimit || back.length() > Variables.inputLimit) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_OverLimit"));
                Create.alert.showAndWait();
            } else if (face.isEmpty() || back.isEmpty()) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_IsEmpty"));
                Create.alert.showAndWait();
            } else if (Create.arr_card.contains(new Card(face, back))) {
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_AlreadyExist"));
                Create.alert.showAndWait();
            } else {
                Create.b_del.setDisable(false);
                String back_text = Create.tf_back_card.getText();
                String face_text = Create.tf_face_card.getText();
                Card card = new Card(face_text, back_text);
                Create.arr_card.add(card);
                Create.b_count.setText(String.valueOf(Create.arr_card.size()));
                Create.l_card.setText(face_text + " // " + back_text);
                checkBorder();
            }
        }
    }

    // Переход на предыдущую созданную карточку
    static class PrevCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Create.b_count.setText(String.valueOf(count - 1));
            Card temp = Create.arr_card.get(count - 2);
            Create.l_card.setText(temp.getFace() + " // " + temp.getBack());
            Create.tf_face_card.setText(temp.getFace());
            Create.tf_back_card.setText(temp.getBack());
            checkBorder();
        }
    }

    // Переход на следующую карточку (если такая есть)
    static class NextCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Create.b_count.setText(String.valueOf(count + 1));
            Create.l_card.setText(Create.arr_card.get(count).getFace() + " // " + Create.arr_card.get(count).getBack());
            checkBorder();
        }
    }

    // Удаление карточки из коллекции (если такая есть)
    static class DelCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Card key = Create.arr_card.get(count - 1);
            Create.arr_card.remove(key);
            Create.b_count.setText(String.valueOf(Create.arr_card.size()));
            checkBorder();
        }
    }

    // Проверка существования карточки
    private static void checkBorder() {
        int count = Integer.parseInt(Create.b_count.getText());
        Create.b_prev.setDisable(count <= 1);
        Create.b_next.setDisable(count == Create.arr_card.size() || Create.arr_card.size() <= 1);
        Create.b_del.setDisable(Create.arr_card.isEmpty());
    }
}
