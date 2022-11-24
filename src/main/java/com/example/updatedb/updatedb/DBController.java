package com.example.updatedb.updatedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class DBController implements CommandLineRunner  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(DBController.class);
	private static final Character character = new Character();

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner run");

        adjustOldId();
		character.setNextId();
        
		String insertSql = "INSERT INTO テーブル名 (id, name) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, character.getId(), character.getName());

        log.info("INSERT success.");
    }

    private void adjustOldId() {
        String selectSql = "SELECT MAX(id) FROM テーブル名";
        Integer maxId = jdbcTemplate.queryForObject(selectSql, Integer.class);
        
        if (maxId != null) {
            character.setId(maxId.intValue());
        }
    }
}
