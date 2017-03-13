package entity;
// Generated 08.03.2017 15:09:49 by Hibernate Tools 4.3.1
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * POJO class for Hibernate
 */
public class Issue  implements java.io.Serializable {

     @JsonProperty("id")
     private Integer id;
     @JsonProperty("title")
     private String title;
     @JsonProperty("description")
     private String description;
     @JsonProperty("status")
     private Integer status;
     @JsonProperty("user_id")
     private int userId;

    public Issue() {
    }

	
    public Issue(int userId) {
        this.userId = userId;
    }
    public Issue(String title, String description, Integer status, int userId) {
       this.title = title;
       this.description = description;
       this.status = status;
       this.userId = userId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }




}


