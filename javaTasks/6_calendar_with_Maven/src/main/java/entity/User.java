package entity;
// Generated 08.03.2017 15:09:49 by Hibernate Tools 4.3.1
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * POJO class for Hibernate
 */
public class User  implements java.io.Serializable {

    @JsonProperty("id")
     private Integer id;
    @JsonProperty("loign")
     private String username;
    @JsonProperty("password")
     private String password;
    @JsonProperty("status")
     private String status;
     @JsonProperty("group_id")
     private Integer groupId;
     @JsonIgnore
     private Integer isTeamlead;

    public User() {
    }

    public User(String username, String password, String status, Integer groupId, Integer isTeamlead) {
       this.username = username;
       this.password = password;
       this.status = status;
       this.groupId = groupId;
       this.isTeamlead = isTeamlead;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public Integer getIsTeamlead() {
        return this.isTeamlead;
    }
    
    public void setIsTeamlead(Integer isTeamlead) {
        this.isTeamlead = isTeamlead;
    }




}


