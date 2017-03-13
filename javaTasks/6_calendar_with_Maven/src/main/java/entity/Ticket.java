package entity;
// Generated 08.03.2017 15:09:49 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * POJO class for Hibernate
 */
public class Ticket  implements java.io.Serializable {

     @JsonProperty("id")
     private Integer id;
     @JsonProperty("user_id")
     private Integer userId;
     @JsonProperty("title")
     private String title;
     @JsonProperty("description")
     private String description;
     @JsonProperty("status")
     private Integer statusId;
     @JsonProperty("issue_id")
     private Integer issueId;
     @JsonProperty("parent_id")
     private Integer parentId;
     @JsonProperty("dlt")
     private Date dlt;

    public Ticket() {
    }

    public Ticket(Integer userId, String title, String description, Integer statusId, Integer issueId, Integer parentId, Date dlt) {
       this.userId = userId;
       this.title = title;
       this.description = description;
       this.statusId = statusId;
       this.issueId = issueId;
       this.parentId = parentId;
       this.dlt = dlt;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
    public Integer getIssueId() {
        return this.issueId;
    }
    
    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }
    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Date getDlt() {
        return this.dlt;
    }
    
    public void setDlt(Date dlt) {
        this.dlt = dlt;
    }




}


