package app;

public class Menu {

    public static void mainMenu(){
        System.out.println("""
                1-авторизоваться
                2-зарегистироваться
                0-выход""");
    }

    public static void adminMenu(){
        System.out.println("""
                1-добавить товар
                2-удалить товар
                3-просмотр пользователей
                4-сменить роль пользователю
                0-назад""");
    }
}
