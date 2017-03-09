package pojo.issues;
//класс POJO для преобразования обьекта в JSON

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Issue;

public class SelectIssueDetTemplate {
    @JsonProperty("status")
    int status;
    
    @JsonProperty("issue")
    Issue issue;

    public SelectIssueDetTemplate() {
    }

    public SelectIssueDetTemplate(int status, Issue issue) {
        this.status = status;
        this.issue = issue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
    
    
    
}
