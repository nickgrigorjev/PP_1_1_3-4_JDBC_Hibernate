package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

/**
 * Создание таблицы User(ов)
 *  1. UserHibernateDaoImpl должен реализовывать интерфейс UserDao
 *  2. В класс Util должна быть добавлена конфигурация для Hibernate (рядом с JDBC), без использования xml.
 *  3. Service на этот раз использует реализацию dao через Hibernate
 *  4. Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl должны быть реализованы с помощью SQL.
 *  */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Иван","Иванов",(byte)35);
        userService.saveUser("Пётр","Петров",(byte)36);
        userService.saveUser("Семён","Семёнов",(byte)37);
        userService.saveUser("Василий","Васильев",(byte)38);
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
