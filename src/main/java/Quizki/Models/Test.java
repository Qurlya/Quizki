package Quizki.Models;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Тест - ФИЗ (форма измерения знаний), основанный на многообразии запросно-ответной системы.
 * Имеется 3 вариации ответов:
 * - Унарный (Прямое однозначное соответствие между запросом и ответом);
 * - Полинарный (Однозначное соответствие запросу последовательности определенных ответов);
 * - Текстовый (Соответствие запросу определенными ключевыми словами, в разных последовательностях).
 * Тест соответствует универсальному ФСИМ, когда пользователь не имеет изначального
 * доступа к базе ответов, и ему необходимо пройти все вопросы полностью, для того чтобы
 * исследовать результат прохождения теста.
 */

public class Test extends Collect{

    public Test(String name, String description){
        super(name, description);
    }

    public Test(){
        super();
    }

    public void chooseAnswerType(String type){

        /*switch(type){
            case "UNARY":
                return new RadioButton();
            case "POLYNARY":
                return new CheckBox();
            case "TEXT":
                return TextField;
        }*/
    }
}
