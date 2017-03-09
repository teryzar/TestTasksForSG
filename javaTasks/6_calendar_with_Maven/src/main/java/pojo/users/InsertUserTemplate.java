package pojo.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertUserTemplate {
    @JsonProperty("authtoken")
    String authtoken;
    @JsonProperty("user")
    String user;
    @JsonProperty("password")
    String password;

    public InsertUserTemplate() {
    }

    public InsertUserTemplate(String authtoken, String user, String password) {
        this.authtoken = authtoken;
        this.user = user;
        this.password = password;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
