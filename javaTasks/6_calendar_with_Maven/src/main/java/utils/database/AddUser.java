package utils.database;

import entity.User;
import pojo.users.InsertUserTemplate;
import utils.user.LoggedUserMap;
import utils.user.UserValidator;

public class AddUser {

    public static int addUser(InsertUserTemplate userToAdd, String sessionId) {
        int status;
        String authToken = userToAdd.getAuthtoken();
        UserValidator.verifyUserRights(authToken);
        //преобразовываем полученные в запросе значения в POJO для Hibernate
        User user = new User(userToAdd.getUser(), userToAdd.getPassword(),
                null, null, 0);
        //записываем обьект в базу данных
        status = DataHelper.getInstance().addUser(user);
        LoggedUserMap.loggedUserMap.put(sessionId, user);
        return status;
    }

    public static int loginUser(InsertUserTemplate userToAdd, String sessionId) {
        int status = 200; //заглушка
        String authToken = userToAdd.getAuthtoken();
        UserValidator.verifyUserRights(authToken);
        User user = DataHelper.getInstance().getUser(userToAdd.getUser());
        LoggedUserMap.loggedUserMap.put(sessionId, user);
        return status;
    }

}
