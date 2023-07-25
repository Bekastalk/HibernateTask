package peaksoft.dao;

import peaksoft.entity.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    User user = new User();

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sql = "create table users(" +
                "id serial primary key," +
                "first_name varchar," +
                "last_name varchar," +
                "age int)";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Error");
        }
    }

    public void dropUsersTable() {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("drop table users");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Table is dropped");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(" +
                    "first_name, last_name, age)" +
                    "values (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Successfully saved");
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        Connection connection=Util.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("delete from users where id=?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println(id+" is remove");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User>list=new ArrayList<>();
        String sql ="select * from users";
        try(Connection connection=Util.getConnection();
            Statement statement=connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage()+"Error");
        }
        return list;
    }

    public void cleanUsersTable() {
        Connection connection=Util.getConnection();

        try {PreparedStatement preparedStatement=connection.prepareStatement("delete from users");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}