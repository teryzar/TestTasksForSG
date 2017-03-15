package utils.user;

import entity.User;
import static utils.user.LoggedUserMap.loggedUserMap;

/**
 * Validates user rights to execuse any actions
 *
 * @author Andrey
 */
public class UserValidator {

    /**
     * Verifying authToken
     *
     * @param authToken
     * @return status code of operation
     */
    public static int verifyAuthToken(String authToken) {
        //пока заглушка
        return 200;
    }

    /**
     * Verifying if user is teamlead
     *
     * @param token
     * @return status code of operation
     */
    public static int verifyIsTeamLead(String token) {

        if (verifyUserLoggedOn(token) == 200) {
            User user = (User) loggedUserMap.get(token);
            if (user.getIsTeamlead() != 0) {
                return 200;
            }
        }
        return 403;

    }

    public static int verifyUserLoggedOn(String token) {
        /**
         * Verifying if user is logged in
         *
         * @param token
         * @return status code of operation
         */
        if (loggedUserMap.containsKey(token)) {
            return 200;
        }
        return 403;
    }
}
