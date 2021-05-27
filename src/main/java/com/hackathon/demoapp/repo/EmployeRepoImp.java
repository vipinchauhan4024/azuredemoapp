package com.hackathon.demoapp.repo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hackathon.demoapp.model.Employee;

@Repository
public class EmployeRepoImp implements EmployeRepo {
    @Autowired
    @Qualifier("postgreJdbc")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("postgreNamedJdbc")
    private NamedParameterJdbcTemplate jdbcNameTemplate;
    
    private static final String SCHEMA= "\"demoappadmin@demoapp-hackathon.postgres.database.azure.com\"";
    private static final String SCHEMA1= "demoappadmin@demoapp-hackathon.postgres.database.azure.com";

    @Override
    public List<Employee> getAllEmployee() {
        return jdbcNameTemplate.query("select  empid, empname, dep from" +SCHEMA+".Employee",
                                      (rs, n) -> new Employee(rs.getInt("empid"), rs.getString("empname"), rs.getString("dep")));

    }

    @Override
    public void saveAll(List<Employee> list) {

        String query = "INSERT INTO "+SCHEMA1+".Employee (empid, empname, dep) VALUES (?, ?, ?)";
        this.jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, list.get(i).getEmpId());
                ps.setString(2, list.get(i).getEmpname());
                ps.setString(3, list.get(i).getDept());

            }

            public int getBatchSize() {
                return list.size();
            }

        });

    }
}
