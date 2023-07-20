package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //Util.getConnection();
        UserService userService=new UserServiceImpl();
        //userService.createUsersTable();
        //userService.saveUser("Asman","Esenov",(byte)22);
        //userService.getAllUsers().forEach(System.out::println);
        //userService.removeUserById(1);
        //userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
