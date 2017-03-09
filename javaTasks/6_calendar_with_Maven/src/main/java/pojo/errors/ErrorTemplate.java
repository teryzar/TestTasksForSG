package pojo.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorTemplate {
    @JsonProperty("status")
    int status;
    @JsonProperty("message")
    String message;    

    public ErrorTemplate() {
    }

    public ErrorTemplate(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
