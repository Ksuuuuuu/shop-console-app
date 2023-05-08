package app;

import java.util.List;
import java.util.Objects;

public class User {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final String phone;
    private final String email;
    private final String login;
    private final String password;
    private Role role;

    public User(String surname, String name, String patronymic, String phone, String email, String login, String password, Role role){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }


    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(surname, user.surname)
                && Objects.equals(name, user.name)
                && Objects.equals(patronymic, user.patronymic)
                && Objects.equals(phone, user.phone)
                && Objects.equals(email, user.email)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, phone, email, login, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public void seeProducts(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Товаров в списке нет");
        } else {
            for (int i = 1; i <= productList.size(); i++) {
                System.out.println(i + "-" + productList.get(i - 1));
            }
        }
    }
}
