package com.ssafy.phone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DBClose;
import com.ssafy.util.DBConnecton;

public class PhoneManager {
	public void insertPhone(Phone phone) {
        try {
            Connection conn = DBConnecton.getConnection();
            String sql = "INSERT INTO phone VALUES(0, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone.getName());
            pstmt.setInt(2, phone.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Phone selectOne(int idx) {
        Phone phone = null;
        try {
            Connection conn = DBConnecton.getConnection();
            String sql = "SELECT * FROM phone WHERE p_idx = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idx);
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() ) {
                phone = new Phone(rs.getInt("p_idx"), rs.getString("p_name"), rs.getInt("p_price"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return phone;
    }
	public List<Phone> selectAll(){
        PreparedStatement ps = null; // 쿼리를 만들어주는 객체
        ResultSet res = null; // 쿼리를 실행한 결과를 담는 객체

        List<Phone> list = new ArrayList<>();
        try {
        	 Connection conn = DBConnecton.getConnection();
            String sql = "SELECT * FROM member";
            ps = conn.prepareStatement(sql);

            // 실행 및 결과 반환
            res = ps.executeQuery();
 
            while (res.next()) {
                int pIdx = res.getInt(1);
                String pName = res.getString(2);
                int Price = res.getInt(3);
                list.add(new Phone(pIdx, pName, Price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return list;
	}
}
