package org.fasttrackit.nationsmatch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserConversation {
    @Id
    private Long userId;
    @Id
    private Long conversationId;
    @MapsId
    @ManyToMany(fetch = FetchType.EAGER)
    private Conversation conversation;
    @MapsId
    @ManyToMany(fetch = FetchType.LAZY)
    private User user;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_conversation", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "conversation_id"))
    private Set<User> users = new HashSet<>();

    public void addUserToConversation(User user) {
        users.add(user);
        user.getConversations().add(this.conversation);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserConversation that = (UserConversation) o;

        return users.equals(that.users);
    }

    @Override
    public int hashCode() {
        return (int) (user.getId() ^ (conversationId >>> 32));
    }

    //    private String groupName;
//    private LocalDate messageSentDate;
//    private boolean messageSent;
//    private boolean messageSeen;

}
