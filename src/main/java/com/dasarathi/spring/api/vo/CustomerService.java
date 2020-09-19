package com.dasarathi.spring.api.vo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class CustomerService {
    private static final Character[] cacheMe = new Character[26];
    private static final Random randomMe = new Random();
    private final int id;
    private final String name;
    private final boolean active;

    public CustomerService() {
        this("UNDEFINED", -1, false);
    }

    public CustomerService(String name, int id, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    synchronized public static String createUID() {
        StringBuilder UID = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            for (int x = 1; x <= 4; x++) {
                UID.append(cacheMe[randomMe.nextInt(cacheMe.length)]);
            }
            if (i <= 3) {
                UID.append('-');
            }
        }
        return new String(UID);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "CurrentStatus( " + id + " , " + name + " , " + active + " )";
    }

    @PostConstruct
    public void intiClazz() {
        int A = 65;// int Z = 90;
        for (int i = 0; i < 26; i++) {
            cacheMe[i] = new Character((char) (i + A));
        }
    }
}
