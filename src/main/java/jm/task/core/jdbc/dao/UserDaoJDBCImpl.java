package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util.LoadDriver();
        try (Statement statement = Util.open().createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL AUTO_INCREMENT,
                      name VARCHAR(45) NOT NULL,
                      last_name VARCHAR(45) NOT NULL,
                      age SMALLINT NOT NULL,
                      PRIMARY KEY (id))
                    """;
            statement.execute(sql);
            System.out.println("Таблица users успешно создана");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        Util.LoadDriver();
        try (Statement statement = Util.open().createStatement()) {
            String sql = """
                    DROP TABLE IF EXISTS users
                    """;
            statement.execute(sql);
            System.out.println("Таблица users успешно удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util.LoadDriver();
        try (Statement statement = Util.open().createStatement()) {
            String sql = "INSERT INTO users (name, last_name, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
            statement.execute(sql);
            System.out.println("В таблицу users успешно внесены следующие данные: " + name + ", " + lastName + ", " + age);
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так");
        }
    }

    public void removeUserById(long id) {
        Util.LoadDriver();
        try (Statement statement = Util.open().createStatement()) {
            String sql = "DELETE FROM users WHERE id = " + id;
            statement.execute(sql);
            System.out.println("Из таблицы users успешно удалена следующая запись с id = " + id);
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Util.LoadDriver();
        try (Statement statement = Util.open().createStatement()) {
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));
            }
            for (User user : users) {
                System.out.println(user.getName() + " " + user.getLastName() + " " + user.getAge());
            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так");
        }
        return users;
    }

    public void cleanUsersTable() {
        Util.LoadDriver();
        try (Statement statement = Util.open().createStatement()) {
            String sql = "TRUNCATE users";
            statement.execute(sql);
            System.out.println("Таблица users успешно очищена");
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
