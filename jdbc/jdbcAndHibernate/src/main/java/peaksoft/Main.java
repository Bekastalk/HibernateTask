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
        //userService.saveUser("Asan","Asanov",(byte)22);
        //userService.getAllUsers().forEach(System.out::println);
        //userService.removeUserById(6);
        //userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
