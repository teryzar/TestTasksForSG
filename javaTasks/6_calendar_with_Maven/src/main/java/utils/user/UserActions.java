package utils.user;

/**
 * Adding or logging user in
 */
import entity.User;
import pojo.users.InsertUserTemplate;
import utils.database.DataHelper;
import utils.user.LoggedUserMap;
import utils.user.UserValidator;

public class UserActions {

    /**
     * Adds new user into database
     *
     * @param userToAdd Converted from JSON
     * @param sessionId SessionID that would be a token for user
     * @return status code of operation
     */
    public static int addUser(InsertUserTemplate userToAdd, String sessionId) {
        int status;
        String authToken = userToAdd.getAuthtoken();
        UserValidator.verifyAuthToken(authToken);
        //преобразовываем полученные в запросе значения в POJO для Hibernate
        User user = new User(userToAdd.getUser(), userToAdd.getPassword(),
                null, null, 0);
        //записываем обьект в базу данных
        status = DataHelper.getInstance().addUser(user);
        LoggedUserMap.loggedUserMap.put(sessionId, user);
        return status;
    }

    public static int loginUser(InsertUserTemplate userToAdd, String sessionId) {
        int status = 400;
        String authToken = userToAdd.getAuthtoken();
        UserValidator.verifyAuthToken(authToken);
        User user = DataHelper.getInstance().getUser(userToAdd.getUser(), userToAdd.getPassword());
        if (user == null) {
            status = 400;
        } else {
            LoggedUserMap.loggedUserMap.put(sessionId, user);
            status = 200;
        }
        return status;
    }

}
