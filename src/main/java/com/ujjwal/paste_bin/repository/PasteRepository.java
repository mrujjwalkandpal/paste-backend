package com.ujjwal.paste_bin.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ujjwal.paste_bin.model.PasteBin;

@Repository
public class PasteRepository{

    private final JdbcTemplate jdbcTemplate;

    public PasteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(PasteBin paste){
        String id=paste.getId();
        String content=paste.getText();
        LocalDateTime expiry=paste.getExpiry();

        String sql="INSERT INTO pastes(id,content,expiry_time) VALUES(?,?,?)";
        jdbcTemplate.update(sql,id,content,expiry);
    }

    public PasteBin mapRow(ResultSet resultSet,int index) throws SQLException{
        return new PasteBin(
            resultSet.getString("id"),
            resultSet.getString("content"),
            resultSet.getTimestamp("expiry_time").toLocalDateTime()
        );
    }

    public PasteBin findById(String id){
        String sql= "SELECT * FROM pastes WHERE id=?";
        List<PasteBin> result = jdbcTemplate.query(sql, this::mapRow,id);

        return result.isEmpty()?null:result.get(0);
    }

    public boolean existsById(String id){
        String sql="SELECT COUNT(*) FROM pastes WHERE id= ?";

        int rows= jdbcTemplate.queryForObject(sql,Integer.class,id);

        if(rows==0) return false;
        else return true;
    }


}