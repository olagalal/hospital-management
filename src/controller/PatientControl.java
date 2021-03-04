/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Patient;

/**
 *
 * @author VGA!Sys
 */
public class PatientControl {

    Statement st;

    public void insert(Patient p) {

        try {
            st = DBConnection.getConnection().createStatement();
            String sql = "INSERT INTO patients (`name`, `age`, `phone`, `BloodType`) VALUES ('" + p.getName() + "', '" + p.getAge() + "', '" + p.getPhone() + "', '" + p.getBloodType() + "')";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PatientControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Patient p) {
        
        try {
            st = DBConnection.getConnection().createStatement();
            String sql = "UPDATE patients SET `name`='" + p.getName()+ "', `age`='" + p.getAge() + "', `phone`='" + p.getPhone() + "', `bloodType`='" + p.getBloodType() + "' WHERE `id`='" + p.getId()+ "'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PatientControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {

        try {
            st = DBConnection.getConnection().createStatement();
            String sql = "DELETE FROM patients WHERE `id`='" + id + "'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PatientControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Patient> Search(String name) {
        ObservableList<Patient> ObsP = FXCollections.observableArrayList();
        
        try{
        st = DBConnection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM `patients` WHERE `Name` LIKE '%"+name+"%'");
        resultSet.beforeFirst();
        
        while (resultSet.next()) {
            Patient pp = new Patient();
            pp.setId(Integer.parseInt(resultSet.getString(1)));
            pp.setName(resultSet.getString(2));
            pp.setAge(Integer.parseInt(resultSet.getString(3)));
            pp.setPhone(resultSet.getString(4));
            pp.setBloodType(resultSet.getString(5));
            ObsP.add(pp);
        }
        }catch (SQLException ex) {
            Logger.getLogger(PatientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ObsP;
    }
    
    public ObservableList<Patient> getAllUsers() {
        ObservableList<Patient> ObsP = FXCollections.observableArrayList();
        
        try{
        st = DBConnection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM `patients`");
        resultSet.beforeFirst();
        
        while (resultSet.next()) {
            Patient pp = new Patient();
            pp.setId(Integer.parseInt(resultSet.getString(1)));
            pp.setName(resultSet.getString(2));
            pp.setAge(Integer.parseInt(resultSet.getString(3)));
            pp.setPhone(resultSet.getString(4));
            pp.setBloodType(resultSet.getString(5));
            ObsP.add(pp);
        }
        }catch (SQLException ex) {
            Logger.getLogger(PatientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ObsP;
    }
    
    public static void main(String[] args) throws SQLException {
        new PatientControl().getAllUsers();
        
    }
}
