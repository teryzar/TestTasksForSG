package pojo.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertedUserTemplate {
    @JsonProperty("status")
    int status;
    @JsonProperty("token")
    String token;

    public InsertedUserTemplate() {
    }

    public InsertedUserTemplate(int status, String token) {
        this.status = status;
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
