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
    
    private static final String AZURE_SCHEMA= "\"demoappadmin@demoapp-hackathon.postgres.database.azure.com\"";
    private static final String LOCAL_SCHEMA= "postgres";

    @Override
    public List<Employee> getAllEmployee() {
        return jdbcNameTemplate.query("select  \"empId\",firstName, lastName from " +AZURE_SCHEMA+".Employee",
                                      (rs, n) -> new Employee(rs.getInt(1), rs.getString(2), rs.getString(3)));

    }

    @Override
    public void saveAll(List<Employee> list) {
        String query = "INSERT INTO "+AZURE_SCHEMA+".employee(\"empId\", city, country, dob, doj, email, firstname, gender, lasthike, lastname, phoneno, region, "
                + "salary, state, username, age, yearofjoining, yearsincompany)"
                                                 +" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
       
        this.jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, list.get(i).getEmpId());
                ps.setString(2, list.get(i).getCity());
                ps.setString(3, list.get(i).getCounty());
                
                ps.setDate(4, getDateFromString(list.get(i).getDob()));
                ps.setDate(5, getDateFromString(list.get(i).getDoj()));
                
                ps.setString(6, list.get(i).getEmail());
                ps.setString(7, list.get(i).getFirstName());
                ps.setString(8, list.get(i).getGender());
                ps.setString(9, list.get(i).getLastHike());
                ps.setString(10, list.get(i).getLastName());
                ps.setString(11, list.get(i).getPhoneNo());
                ps.setString(12, list.get(i).getRegion());
                ps.setInt(13, list.get(i).getSalary());
                ps.setString(14, list.get(i).getState());
                ps.setString(15, list.get(i).getUserName());
                ps.setString(16, list.get(i).getAge());
                ps.setInt(17, list.get(i).getYearOfJoining());
                ps.setString(18, list.get(i).getYearsInCompany());

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
