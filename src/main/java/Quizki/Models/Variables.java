package Quizki.Models;

import Quizki.Pages.Main_window.Main;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация класса констант и переменных, задействованных в коде проекта.
 * Абстрагирование необходимых данных для простоты внесения изменений в код приложения.
 */

public class Variables {
    // ϏЯΞΣ7
    // Основные параметры приложения
    public static final int appHeight = 768;    // Высота окна приложения
    public static final int appWidth = 1024;    // Ширина окна приложения
    public static final String projectTitle = "Quizki";     // Название приложения
    public static String card_filepath = String.valueOf(Main.class.getResource("/data/")).substring(6);    // Путь к файлу для создания JSON
    public static String pic_filepath = String.valueOf(Main.class.getResource("/images/")).substring(6);    // Путь к картинкам
    public static final String projectFilePath = "src\\main\\java\\Quizki\\Pages\\Main_window\\path.json";
    public static final String user_file = "__user__.json";     // Файл с данными пользователя (+настройки)
    public static final String dataFormat = "dd_MM_yyyy";   // Формат записи даты
    public static final int loginLimit = 40;    // ограничение на длину имени пользователя
    public static final int inputLimit = 88;    // Ограничение на ввод по символам
    public static final int picSize = 150;     // Размер изображения
    public static final Label copyright = new Label("© Quizki 2024");  // Знак авторского права на продукт

    // Языковые и косметические наборы
    public static final HashMap<String, String> engList = fillEngList();  // Английский
    public static final HashMap<String, String> rusList = fillRusList();  // Русский
    public static final HashMap<String, String> deuList = fillDeuList();  // Немецкий
    public static final HashMap<String, String> chnList = fillChnList();  // Китайский
    //Стили (only ru!)
    public static final HashMap<String, String> style_1List = fillDesignList_1();   // 1-й набор косметики в дизайне (Cats)
    public static final HashMap<String, String> style_2List = fillDesignList_2();   // 2-й набор косметики в дизайне (1337)

    public static HashMap<String, String> curLanguageList = engList;    // По умолчанию - английский

    // Изменение картинки кота на основном экране в зависимости от выбранного языка
    public static void changeMainCat(){
        ImageView defaultCat = new ImageView();
        ImageView kaomojiCat = new ImageView();
        ImageView leetCat = new ImageView();

        try {
            User user1 = JsonHandler.loadAccountData();
            Image kaomoji1Cat = new Image(new FileInputStream(pic_filepath + "kaomoji1.png"));
            Image kaomoji2Cat = new Image(new FileInputStream(pic_filepath + "kaomoji2.png"));

            Image leet1Cat = new Image(new FileInputStream(pic_filepath + "maximilian.png"));
            Image leet2Cat = new Image(new FileInputStream(pic_filepath + "maximilian2.png"));

            Image default1Cat = new Image(new FileInputStream(pic_filepath + "default1Cat.png"));
            Image default2Cat = new Image(new FileInputStream(pic_filepath + "default2Cat.png"));

            defaultCat.setImage(default1Cat);
            defaultCat.setOnMouseClicked(_->{
                if(defaultCat.getImage().equals(default1Cat)){
                    defaultCat.setImage(default2Cat);
                }else{
                    defaultCat.setImage(default1Cat);
                }
            });

            kaomojiCat.setImage(kaomoji1Cat);
            kaomojiCat.setOnMouseClicked(_->{
                if(kaomojiCat.getImage().equals(kaomoji1Cat)){
                    kaomojiCat.setImage(kaomoji2Cat);
                }else{
                    kaomojiCat.setImage(kaomoji1Cat);
                }
            });

            leetCat.setImage(leet1Cat);
            leetCat.setOnMouseClicked(_->{
                if(leetCat.getImage().equals(leet1Cat)){
                    leetCat.setImage(leet2Cat);
                }else{
                    leetCat.setImage(leet1Cat);
                }
            });

            String temp = user1.getLanguage();
            switch(temp){
                case "cat":
                    firstOption(Main.main_p, kaomojiCat, 700, 500, true);
                    break;
                case "1337":
                    firstOption(Main.main_p, leetCat, 700, 500, true);
                    break;
                default:
                    firstOption(Main.main_p, defaultCat, 700, 500, true);
                    break;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Инициализация для английского набора
    private static HashMap<String, String> fillEngList() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Page_AboutUs", "About us");
        temp.put("Page_Create", "➕");
        temp.put("Page_Repository", "Repository");
        temp.put("Page_Account", "Account");
        temp.put("Page_Settings", "Settings");
        temp.put("Test_Name", "Name");
        temp.put("Test_Description", "Description");
        temp.put("Create_Question", "Question");
        temp.put("Create_Answer", "Answer");
        temp.put("Create_MakeNew", "Create");
        temp.put("Create_AddCard", "Add card");
        temp.put("Create_DelCard", "Delete card");
        temp.put("Back", "Back");
        temp.put("Test_Correct", "True");
        temp.put("Test_Wrong", "False");
        temp.put("Repos_Card", "As cards");
        temp.put("Repos_Test", "As test");
        temp.put("Repos_Text", "As txt-input");
        temp.put("Repos_Delete", "Delete test");
        temp.put("Test_End", "Finish");
        temp.put("Test_Continue", "Continue");
        temp.put("Test_Again", "Start over");
        temp.put("Test_Check", "Check");
        temp.put("Test_CorrectAnswers", "Your correct answers");
        temp.put("Test_WrongAnswers", "Your wrong answers");
        temp.put("Alert_OverLimit", "Question/Answer must be under " + inputLimit + " symbols!");
        temp.put("Alert_IsEmpty", "Question/Answer must be filled!");
        temp.put("Alert_AlreadyExist", "This question is already exist! Come up with another one.");
        temp.put("Alert_DeleteErr", "Error deleting an object! (Try again)");
        temp.put("Alert_UnderLimit", "The test must contain at least 4 cards!");
        temp.put("Alert_EmptyName", "The test cannot have an empty name/description!");
        temp.put("Alert_UserFile", "The test cannot have the name '__user__'!");
        temp.put("Alert_SpecSymbols", "The name of the test must not have special characters!");
        temp.put("Alert_EmptyUserName", "The user must have a name!");
        temp.put("Alert_UserLimit", "The user name must be under " + loginLimit + " symbols!");
        temp.put("Alert_ConfirmDelete", "Are you sure you wanna delete this test?");
        temp.put("Settings_Language", "Select language");
        temp.put("Settings_Color", "Select color theme");
        temp.put("Settings_ColorBlue", "Blue");
        temp.put("Settings_ColorYellow", "Yellow");
        temp.put("Settings_ColorGreen", "Green");
        temp.put("Settings_ColorBlack", "Black");
        temp.put("Settings_ColorWhite", "White");
        temp.put("Settings_Apply", "Apply");
        temp.put("Account_Registration", "Registration");
        temp.put("Account_Name", "Name");
        temp.put("Account_Date", "Registration date");
        temp.put("Account_CollectionCount", "Collections created");
        temp.put("Account_CollectionStudy", "Collections completed");
        temp.put("Account_Activity", "Activity tracking");
        temp.put("Account_ChangeName", "New name input");

        return temp;
    }

    // Инициализация для русского набора
    private static HashMap<String, String> fillRusList() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Page_AboutUs", "О разработчиках");
        temp.put("Page_Create", "➕");
        temp.put("Page_Repository", "Репозиторий");
        temp.put("Page_Account", "Профиль");
        temp.put("Page_Settings", "Настройки");
        temp.put("Test_Name", "Название");
        temp.put("Test_Description", "Описание");
        temp.put("Create_Question", "Вопрос");
        temp.put("Create_Answer", "Ответ");
        temp.put("Create_MakeNew", "Создать");
        temp.put("Create_AddCard", "Добавить");
        temp.put("Create_DelCard", "Удалить");
        temp.put("Back", "Назад");
        temp.put("Test_Correct", "Верно");
        temp.put("Test_Wrong", "Неверно");
        temp.put("Repos_Card", "Карточки");
        temp.put("Repos_Test", "Тестирование");
        temp.put("Repos_Text", "Письменный ввод");
        temp.put("Repos_Delete", "Удалить тест");
        temp.put("Test_End", "Закончить");
        temp.put("Test_Continue", "Продолжить");
        temp.put("Test_Again", "Пройти заново");
        temp.put("Test_Check", "Проверить");
        temp.put("Test_CorrectAnswers", "Ваши правильные ответы");
        temp.put("Test_WrongAnswers", "Ваши неправильные ответы");
        temp.put("Alert_OverLimit", "Вопрос/Ответ не должен быть длиннее " + inputLimit + " символов!");
        temp.put("Alert_IsEmpty", "Вопрос/Ответ не должен быть пустым!");
        temp.put("Alert_AlreadyExist", "Такой вопрос уже существует! Придумайте другой.");
        temp.put("Alert_DeleteErr", "Ошибка удаления объекта! (Попробуйте еще раз)");
        temp.put("Alert_UnderLimit", "Тест должен содержать хотя бы 4 карточки!");
        temp.put("Alert_EmptyName", "Тест не может иметь пустое имя/описание!");
        temp.put("Alert_UserFile", "Тест не может иметь имя '__user__'!");
        temp.put("Alert_SpecSymbols", "Название теста не должно иметь специальные символы!");
        temp.put("Alert_EmptyUserName", "Пользователь обязан иметь имя!");
        temp.put("Alert_UserLimit", "Имя пользователя не должно быть длиннее " + loginLimit + " символов!");
        temp.put("Alert_ConfirmDelete", "Вы уверены, что хотите удалить этот тест?");
        temp.put("Settings_Language", "Выберите язык");
        temp.put("Settings_Color", "Выберите цвет");
        temp.put("Settings_ColorBlue", "Синий");
        temp.put("Settings_ColorYellow", "Жёлтый");
        temp.put("Settings_ColorGreen", "Зелёный");
        temp.put("Settings_ColorBlack", "Чёрный");
        temp.put("Settings_ColorWhite", "Белый");
        temp.put("Settings_Apply", "Принять");
        temp.put("Account_Registration", "Регистрация");
        temp.put("Account_Name", "Имя");
        temp.put("Account_Date", "Дата регистрации");
        temp.put("Account_CollectionCount", "Коллекций создано");
        temp.put("Account_CollectionStudy", "Коллекций пройдено");
        temp.put("Account_Activity", "Учёт активности");
        temp.put("Account_ChangeName", "Ввод нового имени");

        return temp;
    }

    // Инициализация для немецкого набора
    private static HashMap<String, String> fillDeuList() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Page_AboutUs", "Über Entwickler");
        temp.put("Page_Create", "➕");
        temp.put("Page_Repository", "Repository");
        temp.put("Page_Account", "Profil");
        temp.put("Page_Settings", "Einstellungen");
        temp.put("Test_Name", "Name");
        temp.put("Test_Description", "Beschreibung");
        temp.put("Create_Question", "Frage");
        temp.put("Create_Answer", "Antwort");
        temp.put("Create_MakeNew", "Erstellen");
        temp.put("Create_AddCard", "Karte hinzufügen");
        temp.put("Create_DelCard", "Karte löschen");
        temp.put("Back", "Zurück");
        temp.put("Test_Correct", "Richtig");
        temp.put("Test_Wrong", "Falsch");
        temp.put("Repos_Card", "Als Karten");
        temp.put("Repos_Test", "Als Test");
        temp.put("Repos_Text", "Als Texteingabe");
        temp.put("Repos_Delete", "Test löschen");
        temp.put("Test_End", "Beenden");
        temp.put("Test_Continue", "Weiterhin");
        temp.put("Test_Again", "Von vorne beginnen");
        temp.put("Test_Check", "Überprüfen");
        temp.put("Test_CorrectAnswers", "Ihre richtigen Antworten");
        temp.put("Test_WrongAnswers", "Deine falschen Antworten");
        temp.put("Alert_OverLimit", "Die Frage/Antwort sollte nicht länger sein " + inputLimit + " zeichen!");
        temp.put("Alert_IsEmpty", "Die Frage/Antwort darf nicht leer sein!");
        temp.put("Alert_AlreadyExist", "Eine solche Frage existiert bereits! Denken Sie an einen anderen.");
        temp.put("Alert_DeleteErr", "Fehler beim Löschen des Objekts! (Versuchen Sie es erneut)");
        temp.put("Alert_UnderLimit", "Der Test sollte mindestens 4 Karten enthalten!");
        temp.put("Alert_EmptyName", "Der Test darf keinen leeren Namen/keine leere Beschreibung haben!");
        temp.put("Alert_UserFile", "Der Test kann nicht den Namen '__user__' haben!");
        temp.put("Alert_SpecSymbols", "Der Name des Tests sollte keine Sonderzeichen haben!");
        temp.put("Alert_EmptyUserName", "Der Benutzer muss einen Namen haben!");
        temp.put("Alert_UserLimit", "Der Benutzername muss unter " + loginLimit + " Zeichen sein!");
        temp.put("Alert_ConfirmDelete", "Sind Sie sicher, dass Sie diesen Test löschen möchten?");
        temp.put("Settings_Language", "Sprache auswählen");
        temp.put("Settings_Color", "Wählen Sie eine Farbe aus");
        temp.put("Settings_ColorBlue", "Blau");
        temp.put("Settings_ColorYellow", "Gelber");
        temp.put("Settings_ColorGreen", "Grün");
        temp.put("Settings_ColorBlack", "Schwarzer");
        temp.put("Settings_ColorWhite", "Weiße");
        temp.put("Settings_Apply", "Annehmen");
        temp.put("Account_Registration", "Rezeption");
        temp.put("Account_Name", "Name");
        temp.put("Account_Date", "Registrierungsdatum");
        temp.put("Account_CollectionCount", "Sammlungen abgeschlossen");
        temp.put("Account_CollectionStudy", "Sammlungen abgeschlossen");
        temp.put("Account_Activity", "Aktivitäts-Tracking");
        temp.put("Account_ChangeName", "Eingabe eines neuen Namens");

        return temp;
    }

    // Инициализация для китайского набора
    private static HashMap<String, String> fillChnList() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Page_AboutUs", "关于开发人员");
        temp.put("Page_Create", "➕");
        temp.put("Page_Repository", "存储库");
        temp.put("Page_Account", "个人资料");
        temp.put("Page_Settings", "设置");
        temp.put("Test_Name", "名称");
        temp.put("Test_Description", "描述");
        temp.put("Create_Question", "问题");
        temp.put("Create_Answer", "答案");
        temp.put("Create_MakeNew", "创建");
        temp.put("Create_AddCard", "添加卡");
        temp.put("Create_DelCard", "删除卡");
        temp.put("Back", "返回");
        temp.put("Test_Correct", "对");
        temp.put("Test_Wrong", "錯");
        temp.put("Repos_Card", "作为卡片");
        temp.put("Repos_Test", "作为测试");
        temp.put("Repos_Text", "作为文本输入");
        temp.put("Repos_Delete", "删除测试");
        temp.put("Test_End", "完成");
        temp.put("Test_Continue", "继续");
        temp.put("Test_Again", "重新开始");
        temp.put("Test_Check", "检查");
        temp.put("Test_CorrectAnswers", "你的正确答案");
        temp.put("Test_WrongAnswers", "你的错误答案");
        temp.put("Alert_OverLimit", "问题/答案不应该更长 " + inputLimit + " 人物！");
        temp.put("Alert_IsEmpty", "问题/答案不应该是空的！");
        temp.put("Alert_AlreadyExist", "这样的问题已经存在了！ 再想出一个。");
        temp.put("Alert_DeleteErr", "删除对象时出错！（再试一次）");
        temp.put("Alert_UnderLimit", "测试必须包含至少4张卡片！");
        temp.put("Alert_EmptyName", "测试不能有一个空的名称/描述！");
        temp.put("Alert_UserFile", "测试不能具有名称'__user__'！");
        temp.put("Alert_SpecSymbols", "考试名称不得有特殊字符！");
        temp.put("Alert_EmptyUserName", "用户必须有一个名字！");
        temp.put("Alert_UserLimit", "用户名必须在" + loginLimit + "个符号以下！");
        temp.put("Alert_ConfirmDelete", "您确定要删除此测试吗？");
        temp.put("Settings_Language", "选择语言");
        temp.put("Settings_Color", "选择一种颜色");
        temp.put("Settings_ColorBlue", "蓝色");
        temp.put("Settings_ColorYellow", "黄色");
        temp.put("Settings_ColorGreen", "绿色");
        temp.put("Settings_ColorBlack", "黑色");
        temp.put("Settings_ColorWhite", "白色");
        temp.put("Settings_Apply", "接受");
        temp.put("Account_Registration", "注册");
        temp.put("Account_Name", "名称");
        temp.put("Account_Date", "登记日期");
        temp.put("Account_CollectionCount", "创建的集合");
        temp.put("Account_CollectionStudy", "馆藏已完成");
        temp.put("Account_Activity", "活动追踪");
        temp.put("Account_ChangeName", "新名称输入");

        return temp;
    }

    // Cats style
    private static HashMap<String, String> fillDesignList_1() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Page_AboutUs", "О разработчиках");
        temp.put("Page_Create", "➕");
        temp.put("Page_Repository", "Репозиторий");
        temp.put("Page_Account", "Профиль");
        temp.put("Page_Settings", "Настройки");
        temp.put("Test_Name", "Название");
        temp.put("Test_Description", "Описание");
        temp.put("Create_Question", "Вопрос");
        temp.put("Create_Answer", "Ответ");
        temp.put("Create_MakeNew", "Создать");
        temp.put("Create_AddCard", "Добавить");
        temp.put("Create_DelCard", "Удалить");
        temp.put("Back", "\uD83C\uDFE0\uD83D\uDC08");
        temp.put("Test_Correct", "ヾ(≧▽≦*)o");
        temp.put("Test_Wrong", "(┬┬﹏┬┬)");
        temp.put("Repos_Card", "Карточки");
        temp.put("Repos_Test", "Тест");
        temp.put("Repos_Text", "Письменный ввод");
        temp.put("Repos_Delete", "Удалить тест");
        temp.put("Test_End", "＼（〇_ｏ）／");
        temp.put("Test_Continue", "Продолжить");
        temp.put("Test_Again", "≧ ﹏ ≦");
        temp.put("Test_Check", "ヽ(￣ω￣(￣ω￣〃)ゝ");
        temp.put("Test_CorrectAnswers", "Ваши правильные ответы");
        temp.put("Test_WrongAnswers", "Ваши неправильные ответы");
        temp.put("Alert_OverLimit", "Вопрос/Ответ не должен быть длиннее " + inputLimit + " символов!");
        temp.put("Alert_IsEmpty", "Вопрос/Ответ не должен быть пустым!");
        temp.put("Alert_AlreadyExist", "Такой вопрос уже существует! Придумайте другой.");
        temp.put("Alert_DeleteErr", "Ошибка удаления объекта! (Попробуйте еще раз)");
        temp.put("Alert_UnderLimit", "Тест должен содержать хотя бы 4 карточки!");
        temp.put("Alert_EmptyName", "Тест не может иметь пустое имя/описание!");
        temp.put("Alert_UserFile", "Тест не может иметь имя '__user__'!");
        temp.put("Alert_SpecSymbols", "Название теста не должно иметь специальные символы!");
        temp.put("Alert_EmptyUserName", "Пользователь обязан иметь имя!");
        temp.put("Alert_UserLimit", "Имя пользователя не должно быть длиннее " + loginLimit + " символов!");
        temp.put("Alert_ConfirmDelete", "Вы уверены, что хотите удалить этот тест?");
        temp.put("Settings_Language", "Выберите язык");
        temp.put("Settings_Color", "Выберите цвет");
        temp.put("Settings_ColorBlue", "Синий");
        temp.put("Settings_ColorYellow", "Жёлтый");
        temp.put("Settings_ColorGreen", "Зелёный");
        temp.put("Settings_ColorBlack", "Чёрный");
        temp.put("Settings_ColorWhite", "Белый");
        temp.put("Settings_Apply", "ヾ(•ω•`)o");
        temp.put("Account_Registration", "(づ￣ 3￣)づ");
        temp.put("Account_Name", "Имя");
        temp.put("Account_Date", "Вы с нами уже с (*≧︶≦))(￣▽￣* )ゞ");
        temp.put("Account_CollectionCount", "Коллекций создано");
        temp.put("Account_CollectionStudy", "Коллекций пройдено");
        temp.put("Account_Activity", "Учёт активности ㄟ(≧◇≦)ㄏ");
        temp.put("Account_ChangeName", "Ввод нового имени ㄟ( ▔, ▔ )ㄏ");

        return temp;
    }

    // 1337 style
    private static HashMap<String, String> fillDesignList_2() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Page_AboutUs", "0 Я◬ʒR∆ҔθŦ4N₭ĂХ");
        temp.put("Page_Create", "➕");
        temp.put("Page_Repository", "ЯEP05170RУ");
        temp.put("Page_Account", "∐ΡΟΦ◪λb");
        temp.put("Page_Settings", "₦∆S₸Я0ЙКN");
        temp.put("Test_Name", "ŊÆɱΞ");
        temp.put("Test_Description", "∆E∑XРIПTION");
        temp.put("Create_Question", "QYE∑710N");
        temp.put("Create_Answer", "AN∑VV3Р");
        temp.put("Create_MakeNew", "ΣØʒ∂∀Ŋ⨝Ξ");
        temp.put("Create_AddCard", "∀∆∆");
        temp.put("Create_DelCard", "∆ΞΛET∃");
        temp.put("Back", "💀");
        temp.put("Test_Correct", "C0ЯREC‡");
        temp.put("Test_Wrong", "\uD835\uDD68尺Ø\uD835\uDCC3Ᏻ");
        temp.put("Repos_Card", "CAЯ∆S");
        temp.put("Repos_Test", "∓∃∑∓");
        temp.put("Repos_Text", "7∄X7-1ИПYT");
        temp.put("Repos_Delete", "∆ΞΛET∃ 7357");
        temp.put("Test_End", "ΞN∆");
        temp.put("Test_Continue", "CXN7IИYΞ");
        temp.put("Test_Again", "A6∀1И");
        temp.put("Test_Check", "C|-|XϽK");
        temp.put("Test_CorrectAnswers", "Vаши прАVилbные 07VE7bI");
        temp.put("Test_WrongAnswers", "Vаши NΞпрАVилbные 07VE7bI");
        temp.put("Alert_OverLimit", "Вопрос/Ответ не должен быть длиннее " + inputLimit + " символов!");
        temp.put("Alert_IsEmpty", "Вопрос/Ответ не должен быть пустым!");
        temp.put("Alert_AlreadyExist", "Такой вопрос уже существует! Придумайте другой.");
        temp.put("Alert_DeleteErr", "Ошибка удаления объекта! (Попробуйте еще раз)");
        temp.put("Alert_UnderLimit", "Тест должен содержать хотя бы 4 карточки!");
        temp.put("Alert_EmptyName", "Тест не может иметь пустое имя/описание!");
        temp.put("Alert_UserFile", "Тест не может иметь имя '__user__'!");
        temp.put("Alert_SpecSymbols", "Название теста не должно иметь специальные символы!");
        temp.put("Alert_EmptyUserName", "Пользователь обязан иметь имя!");
        temp.put("Alert_UserLimit", "Имя пользователя не должно быть длиннее " + loginLimit + " символов!");
        temp.put("Alert_ConfirmDelete", "Вы уверены, что хотите удалить этот тест?");
        temp.put("Settings_Language", "VbI6ери7е RZbI|<");
        temp.put("Settings_Color", "VbI6ери7е цvе7");
        temp.put("Settings_ColorBlue", "Синий");
        temp.put("Settings_ColorYellow", "Жёлтый");
        temp.put("Settings_ColorBlack", "Чёрный");
        temp.put("Settings_ColorGreen", "Зелёный");
        temp.put("Settings_ColorWhite", "Белый");
        temp.put("Settings_Apply", "Принять");
        temp.put("Account_Registration", "ЯEGI57RA7I0И");
        temp.put("Account_Name", "ŊÆɱΞ");
        temp.put("Account_Date", "∆∀7А ЯEGI57RAЦII");
        temp.put("Account_CollectionCount", "SOZ∆AИ0");
        temp.put("Account_CollectionStudy", "ПR0Й∆ΞŊO");
        temp.put("Account_Activity", "Y4E7 AK71VИOS71");
        temp.put("Account_ChangeName", "VV0∆ NE\\/\\/ ИA/ИE");
        // there was cry4me

        return temp;
    }
}