package com.hackathon.demoapp.repo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.hackathon.demoapp.model.ToBuildDeliveryPrecision;

public class TestObjectInfoRepoImp implements TestObjectInfoRepo {

    
    @Autowired
    @Qualifier("postgreJdbc")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("postgreNamedJdbc")
    private NamedParameterJdbcTemplate jdbcNameTemplate;
    
    private static final String AZURE_SCHEMA= "\"demoappadmin@demoapp-hackathon.postgres.database.azure.com\"";

 

    @Override
    public void saveAll(List<ToBuildDeliveryPrecision> list) {
        String query = "INSERT INTO "+AZURE_SCHEMA+".Employee (empid, empname, dep, addedtime, modifiedtime) VALUES (?, ?, ?,?,?)";
        this.jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, list.get(i).getBuildLocation());
                ps.setDate(2, getDateFromString(list.get(i).getDeliveryDate()));
                ps.setString(3, list.get(i).getLateDeliveryResponsibleForum());
                ps.setString(4, list.get(i).getObjectNo());
                ps.setString(5, list.get(i).getPhaseName());
                ps.setString(6, list.get(i).getPhasetype());
                ps.setString(7, list.get(i).getPhysicalBuildMaturity());
                ps.setDate(8, getDateFromString(list.get(i).getPlanedDelivery()));
                ps.setString(9, list.get(i).getReasonForLateDelivery());
                ps.setString(10, list.get(i).getResponsibleDecisionForum());
                ps.setDate(11, getDateFromString(list.get(i).getTargetDelivery()));
                ps.setString(12, list.get(i).getToId());
                ps.setString(13, list.get(i).getToType());
                ps.setInt(14, list.get(i).getGapInDays());
                ps.setInt(15, list.get(i).getMonth());
                ps.setInt(16, list.get(i).getSuccessFullDelivery());
                             

            }

            public int getBatchSize() {
                return list.size();
            }

        });

    }
    
  private static java.sql.Date getDateFromString(String s){
      java.sql.Date sqlDate = null;
    try {
       Date date = new SimpleDateFormat("MM/dd/yyyy").parse(s);
        sqlDate =  new java.sql.Date(date.getTime());
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return sqlDate;  

  }
}
