package ru.unclediga.spec.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class AppConfig {
    @Resource(lookup = "resource/myUrl")
    private String myUrl;
    @Resource(lookup = "resource/myRate")
    private Double rate;
    @Resource(lookup = "myParams")
    private Properties properties;
    private List<String> messages;

    @PostConstruct
    public void init() {
        System.out.println("myUrl = " + myUrl);
        System.out.println("rate = " + rate);
        System.out.println("props size= " + properties.size());
        messages = new ArrayList<>();
    }

    public String getMyUrl() {
        return myUrl;
    }

    public Double getRate() {
        return rate;
    }

    public Map<String, String> getProperties() {
        HashMap<String, String> map = new HashMap<>();
        for (String n : properties.stringPropertyNames()) {
            map.put(n, properties.getProperty(n));
        }
        return map;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
