package org.fasttrackit.nationsmatch.transfer;

public class TestRequest {

    private String userName;
    private String text;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                "userName='" + userName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
