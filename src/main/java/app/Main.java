package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static User login(Scanner in, UserService userService){
        System.out.println("Логин:");
        String login = in.next();
        System.out.println("Пароль:");
        String password = in.next();
        User currentUser = userService.loginUser(login, password);
        if (currentUser == null){
            System.out.println("Неверные данные");
            return login(in, userService);
        }
        else {
            System.out.println("Вы авторизированы");
            System.out.println(currentUser);
            return currentUser;
        }
    }
    public static Client registry(Scanner in, UserService userService){
        System.out.println("Фамилия:");
        String surname = in.next();
        System.out.println("Имя:");
        String name = in.next();
        System.out.println("Отчество:");
        String patronymic = in.next();
        System.out.println("Телефон:");
        String phone = in.next();
        if (!Check.checkPhone(phone)){
            System.out.println("Неверный формат");
            return registry(in, userService);
        }
        else{
            System.out.println("Почта:");
            String email = in.next();
            if (!Check.checkEmail(email)){
                System.out.println("Неверный формат");
                return registry(in, userService);
            }
            else{
                System.out.println("Логин:");
                String login = in.next();
                System.out.println("Пароль:");
                String password = in.next();
                Client user = new Client(surname, name, patronymic, phone, email, login, password);
                if (!userService.registry(user)){
                    System.out.println("Данные логина или imail уже заняты");
                    return registry(in, userService);
                }
                else {return user;}
            }

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        List<User> users = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        UserService userService = new UserService(users);
        Admin admin = new Admin("Северов", 
                "Илья",
                "Сергеевич",
                "8-900-510-45-78",
                "severov@gmail.com",
                "severovIl",
                "Seva90");
        
        userService.registry(admin);

        start(in, userService, users, products);
    }

    public static void start(Scanner in, UserService userService, List<User> users, List<Product> products){
        User currentUser = null;
        int choice;
        do{
            Menu.mainMenu();
            choice = in.nextInt();
            if (choice == 0)
                return;
        }while (!Check.checkPositiveInt(choice) || choice > 2);

        switch (choice){
            case 1-> currentUser = login(in, userService);
            case 2-> currentUser = registry(in, userService);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }

        if (currentUser.getRole().equals(Role.CLIENT)){
            Client client = (Client) currentUser;
            client.seeProducts(products);
            System.out.println("Для выхода введите любой символ");
            in.nextLine();
            start(in, userService, users, products);
        }
        else{
            do{
                Menu.adminMenu();
                choice = in.nextInt();

            Admin admin = (Admin) currentUser;
            switch (choice){
                case 1->{
                    System.out.println("Название:");
                    String name = in.next();
                    System.out.println("Цена:");
                    double cost = in.nextDouble();
                    admin.addProduct(new Product(name,cost ), products);
                }
                case 2->{
                    admin.seeProducts(products);
                    System.out.println("Введите номер");
                    int pos = in.nextInt();
                    admin.deleteProduct(pos, products);
                }
                case 3-> admin.seeInfUsers(users);
                case 4->{
                    admin.seeInfUsers(users);
                    System.out.println("Введите номер");
                    int pos = in.nextInt();
                    System.out.println("Введите роль");
                    String role = in.next();
                    admin.setRole(pos, role.equals("Админ")? Role.ADMIN : Role.CLIENT, users);
                }
                case 0->start(in, userService, users, products);
            }
            }while (choice!=0);
        }

    }

}
