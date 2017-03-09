package pojo.tickets;

//POJO класс для списка тикетов

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SelectTicketListTemplate {
    @JsonProperty("status")
    int status;
    
    @JsonProperty("ticket_ids")
    List<Integer> ticketList;

    public SelectTicketListTemplate() {
    }

    public SelectTicketListTemplate(int status, List<Integer> ticketList) {
        this.status = status;
        this.ticketList = ticketList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Integer> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Integer> issueList) {
        this.ticketList = issueList;
    }
       
}

