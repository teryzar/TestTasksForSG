package utils.database;

import entity.User;
import pojo.users.InsertUserTemplate;
import utils.user.LoggedUserMap;
import utils.user.UserValidator;

public class AddUser {

    static int status;

    public static int addUser(InsertUserTemplate userToAdd, String sessionId) {
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

}
