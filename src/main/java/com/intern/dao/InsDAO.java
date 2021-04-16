package com.intern.dao;

import com.intern.bo.InsuranceBO;
import com.intern.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsDAO {
    private Connection conn;

    public InsDAO() {
        this.conn = DBUtils.getConnection();
    }

    public boolean updateInsNumberPlateByName(String insName, String numberPlate) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement(" UPDATE insurance SET number_plate = ? WHERE name = ? ");
            cstmt.setString(1, numberPlate);
            cstmt.setString(2, insName);

            return cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveIns(InsuranceBO bo) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("INSERT INTO insurance (name, type) VALUES (?, ?)");
            cstmt.setString(1, bo.getName());
            cstmt.setString(2, bo.getType());

            return cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int countIns() {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("SELECT count(*) FROM insurance");
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getTypeIns(String name) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("SELECT type from insurance where name = ?");
            cstmt.setString(1, name);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            System.out.println("Ins don't exists");
            return "";
        }
    }

    public List<InsuranceBO> getAvailableIns() {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("   name, ");
        sql.append("   type, ");
        sql.append("   number_plate ");
        sql.append(" FROM insurance ");
        sql.append(" WHERE number_plate is null ");

        PreparedStatement cstmt;
        List<InsuranceBO> dataRes = new ArrayList<InsuranceBO>();
        try {
            cstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                InsuranceBO ins = new InsuranceBO();
                ins.setName(rs.getString(1));
                ins.setType(rs.getString(2));
                ins.setNumberPlate(rs.getString(3));

                dataRes.add(ins);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataRes;
    }
}
