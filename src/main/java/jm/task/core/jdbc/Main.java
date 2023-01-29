package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

/**
 * Создание таблицы User(ов)
 *  1. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль
 *     (User с именем – name добавлен в базу данных)
 *  2. Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
 *  3. Очистка таблицы User(ов)
 *  4. Удаление таблицы
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
