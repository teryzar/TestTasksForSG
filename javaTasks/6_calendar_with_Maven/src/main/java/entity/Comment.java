package entity;
// Generated 08.03.2017 15:09:49 by Hibernate Tools 4.3.1
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * POJO class for Hibernate
 */
public class Comment  implements java.io.Serializable {
    
     @JsonProperty("id")
     private Integer id;
     @JsonProperty("user_id")
     private Integer userId;
     @JsonProperty("text")
     private String text;
     @JsonProperty("ticket_id")
     private Integer ticketId;

    public Comment() {
    }

    public Comment(Integer userId, String text, Integer ticketId) {
       this.userId = userId;
       this.text = text;
       this.ticketId = ticketId;
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
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }




}


