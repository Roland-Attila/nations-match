package org.fasttrackit.nationsmatch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Conversation {
    @Id
    @GeneratedValue
    private Long id;
    private String groupName;
    @NotBlank
    private String userFirstName;
    @NotBlank
    private String userLastName;
    @NotNull
    private LocalDate messageSentDate;
    private boolean sent;
    private boolean seen;
    private int activeChats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public int getActiveChats() {
        return activeChats;
    }

    public void setActiveChats(int activeChats) {
        this.activeChats = activeChats;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", messageSentDate=" + messageSentDate +
                ", sent=" + sent +
                ", seen=" + seen +
                ", activeChats=" + activeChats +
                '}';
    }
}
