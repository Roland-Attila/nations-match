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
    @NotBlank
    private String name;
    @NotNull
    private LocalDate messageSentDate;
    private boolean sent;
    private boolean seen;
    @NotNull
    private int activeChats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getActiveChatHeads() {
        return activeChats;
    }

    public void setActiveChatHeads(int activeChatHeads) {
        this.activeChats = activeChatHeads;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messageSentDate=" + messageSentDate +
                ", sent=" + sent +
                ", seen=" + seen +
                ", activeChatHeads=" + activeChats +
                '}';
    }
}
