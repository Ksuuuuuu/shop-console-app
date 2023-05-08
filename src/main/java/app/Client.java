package app;


public class Client extends User {

    public Client(String surname, String name, String patronymic, String phone, String email, String login, String password) {
        super(surname, name, patronymic,phone, email, login, password, Role.CLIENT);
    }

}
