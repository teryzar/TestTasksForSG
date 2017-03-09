package pojo.issues;

import entity.Issue;
import com.fasterxml.jackson.annotation.JsonProperty;

//класс POJO для парсинга JSON из запроса на добавление Issue


public class InsertIssueTemplate {
    @JsonProperty("token")
    Long token;
    @JsonProperty("user_id")
    int user_id;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("status_id")
    int status;

    public InsertIssueTemplate() {
    }

    public InsertIssueTemplate(Long token, int user_id, String title, String description, int status) {
        this.token = token;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Long getToken() {
        return token;
    }

    public void setToken(Long token) {
        this.token = token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
