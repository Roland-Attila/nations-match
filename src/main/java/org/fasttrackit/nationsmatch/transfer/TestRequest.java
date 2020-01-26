package org.fasttrackit.nationsmatch.transfer;

public class TestRequest {

    private int userId;
    private String text;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TestRequest{" +
                "userId=" + userId +
                ", text='" + text + '\'' +
                '}';
    }
}
