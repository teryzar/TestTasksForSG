package utils.database;

import entity.User;
import pojo.users.InsertUserTemplate;
import utils.user.UserValidator;

public class AddUser {
    
        public static void addUser(InsertUserTemplate userToAdd){
        String authToken = userToAdd.getAuthtoken();
        UserValidator.verifyUserRights(authToken);
        //преобразовываем полученные в запросе значения в POJO для Hibernate
        User user = new User(userToAdd.getUser(), userToAdd.getPassword(),
               null, null, 0);
        //записываем обьект в базу данных
        DataHelper.getInstance().addUser(user);
    }
    
}
