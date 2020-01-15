package org.fasttrackit.nationsmatch.transfer;

import java.time.LocalDate;

public class UserInConversationResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate messageSentDate;
    private boolean messageSent;
    private boolean messageSeen;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getMessageSentDate() {
        return messageSentDate;
    }

    public void setMessageSentDate(LocalDate messageSentDate) {
        this.messageSentDate = messageSentDate;
    }

    public boolean isMessageSent() {
        return messageSent;
    }

    public void setMessageSent(boolean messageSent) {
        this.messageSent = messageSent;
    }

    public boolean isMessageSeen() {
        return messageSeen;
    }

    public void setMessageSeen(boolean messageSeen) {
        this.messageSeen = messageSeen;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserInConversationResponse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", messageSentDate=" + messageSentDate +
                ", messageSent=" + messageSent +
                ", messageSeen=" + messageSeen +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
