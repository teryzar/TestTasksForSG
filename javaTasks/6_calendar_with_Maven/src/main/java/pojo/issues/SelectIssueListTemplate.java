package pojo.issues;

//POJO класс для списка Issues 

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SelectIssueListTemplate {
    @JsonProperty("status")
    int status;
    
    @JsonProperty("issues_ids")
    List<Integer> issueList;

    public SelectIssueListTemplate() {
    }

    public SelectIssueListTemplate(int status, List<Integer> issueList) {
        this.status = status;
        this.issueList = issueList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Integer> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Integer> issueList) {
        this.issueList = issueList;
    }
       
}
