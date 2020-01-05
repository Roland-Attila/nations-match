package org.fasttrackit.nationsmatch.transfer;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ConversationRequest {

    @Id
    private Long id;
    @NotBlank
    private String userFirstName;
    @NotBlank
    private String userLastName;
    @NotBlank
    private String groupName;
    @NotNull
    private LocalDate messageSentDate;
    private boolean sent;
    private boolean seen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public LocalDate getMessageSentDate() {
        return messageSentDate;
    }

    public void setMessageSentDate(LocalDate messageSentDate) {
        this.messageSentDate = messageSentDate;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    @Override
    public String toString() {
        return "ConversationRequest{" +
                "id=" + id +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", messageSentDate=" + messageSentDate +
                ", sent=" + sent +
                ", seen=" + seen +
                '}';
    }
}