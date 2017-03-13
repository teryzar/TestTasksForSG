package utils.user;

/**
 * Map that contains token as key and object User as value
 */

import entity.User;
import java.util.HashMap;
import java.util.Map;

public class LoggedUserMap {
    public static Map loggedUserMap = new HashMap<String, User>();
    
}
