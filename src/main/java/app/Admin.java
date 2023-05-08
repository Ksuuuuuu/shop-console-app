package app;

import java.util.List;

public class Admin extends User {


    public Admin(String surname,
                 String name,
                 String patronymic,
                 String phone,
                 String email,
                 String login,
                 String password) {
        super(surname, name, patronymic,phone, email, login, password, Role.ADMIN);
    }

    public void addProduct(Product p, List<Product> productList) {
        productList.add(p);
    }

    public void deleteProduct(int pos, List<Product> productList) {
        productList.remove(pos - 1);
    }

    public void seeInfUsers(List<User> users) {
        for (int i = 1; i <= users.size(); i++) {
            System.out.println(i + "-" + users.get(i - 1));
        }
    }

    public void setRole(int pos, Role role, List<User> users) {
        User us = users.get(pos-1);
        us.setRole(role);
        users.set(pos-1, us);
    }


}
