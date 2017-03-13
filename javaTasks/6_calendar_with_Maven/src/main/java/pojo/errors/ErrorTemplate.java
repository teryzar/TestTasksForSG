package pojo.errors;
/**
 * POJO class to convert error messages to response
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorTemplate {
    @JsonProperty("status")
    int status;
    @JsonProperty("message")
    String message;    

    public ErrorTemplate() {
    }
    
    /*
    *Constructor
    *@param gets an error status and generates text
    */
    
    public ErrorTemplate(int status) {
        this.status = status;
        if (status == 400) message = "Bad Request" ;
        else if (status == 401) message = "Bad Auth token";
        else if (status == 403) message = "Forbidden";
        else if (status == 409) message = "Username exists";
        else if (status == 412) message = "Precondition failed";
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
