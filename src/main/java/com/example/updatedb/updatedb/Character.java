package com.example.updatedb.updatedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Character {

    private static final Logger log = LoggerFactory.getLogger(Character.class);

    private int id = 0;

    void setId(int oldId) {
        if(oldId >= id)
        id = oldId;
    }

    void setNextId() {
        id = id + 1;
    }

    int getId() {
        return id;
    }

    String getName() {
        String num = String.valueOf(id);
        String name = "人" + num;
        log.info("name" + name);
        return name;
    }
    
}
