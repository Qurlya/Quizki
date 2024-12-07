package Quizki.Models;

/**
 * Реализация класса констант и переменных, задействованных в коде проекта.
 * Абстрагирование необходимых данных для простоты внесения изменений в код приложения.
 */

public class Variables {
    //ϏЯΞΣ⩱
    // Основные параметры приложения
    public static final int appHeight = 600;    // Высота окна приложения
    public static final int appWidth = 500;    // Ширина окна приложения
    public static final String projectTitle = "Quizki";     // Название приложения
    public static final String card_filepath = "src/main/java/Quizki/Data/";    // Путь к файлу для создания JSON

    // Косметические элементы дизайна
    public static final String correctAnswerEmoji_cat = "ヾ(≧▽≦*)o";   // Смешной смайлик правильного ответа
    public static final String wrongAnswerEmoji_cat = "(┬┬﹏┬┬)";   // Смешной смайлик неправильного ответа
    public static final String backEmoji_cat = "＼（〇_ｏ）／";   // Смешной смайлик кнопки "назад"
}