package ru.unclediga.spec.model;

import java.io.Serializable;

public class TestMessage implements Serializable {
    private String sendTime;
    private String text;

    public TestMessage() {
    }

    public TestMessage(String sendTime, String text) {
        this.sendTime = sendTime;
        this.text = text;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
