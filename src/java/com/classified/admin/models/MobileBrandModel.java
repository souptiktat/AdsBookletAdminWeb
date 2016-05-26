/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobileBrandVO;
import com.classified.admin.vo.ResultVO;
import com.classifiedindia.model.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class MobileBrandModel implements MobileBrand{

    
    public ResultVO storeMobileBrandInfo(MobileBrandVO mobileBrandVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public MobileBrandVO populateMobileBrandInfo(int brand_id) {
        MobileBrandVO mobileBrandVO= new MobileBrandVO();
        DbConnection dbcon=new DbConnection();
        try{
            if(0!=brand_id){
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from mobi_brand_table where brand_id= "+brand_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    mobileBrandVO.setBrand_id(rs1.getInt("brand_id"));
                    mobileBrandVO.setBrand_name(rs1.getString("brand_name"));
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return mobileBrandVO;
    }

    
    public ResultVO deleteMobileBrandInfo(int brand_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=brand_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from mobi_brand_table where brand_id= "+brand_id;
                System.out.println("Test Query: " +sqlQuery1);
                int rowsAffected=st1.executeUpdate(sqlQuery1);
                if(rowsAffected >0){
                    resultVO.setMessage("One Row Deleted");
                }
                else{
                    resultVO.setMessage("No Row Deleted");
                }
            }
        }catch(Exception e){
            e.getMessage();
        }
        return resultVO;
    }

    
    public MobileBrandVO modifyMobileBrandInfo(MobileBrandVO mobileBrandVO) {
        if(null!=mobileBrandVO){
            int brand_id= mobileBrandVO.getBrand_id();
            String brand_name= mobileBrandVO.getBrand_name();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update mobi_brand_table set brand_name='"+brand_name+"' where brand_id=" + brand_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return mobileBrandVO;
    }

    
    public ResultVO searchMobileBrandInfo(int brand_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<MobileBrandVO> viewAllMobileBrandInfo() {
        List<MobileBrandVO> listOfMobileBrand=new ArrayList<MobileBrandVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from mobi_brand_table";
            ResultSet rs=st.executeQuery(sqlQuery);
            MobileBrandVO mobileBrandVO=null;
            while(rs.next()){
                mobileBrandVO=new MobileBrandVO();
                mobileBrandVO.setBrand_id(rs.getInt("brand_id"));
                mobileBrandVO.setBrand_name(rs.getString("brand_name"));
                listOfMobileBrand.add(mobileBrandVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfMobileBrand;
    }
    
    public boolean checkMobileBrandCredential(int brand_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        MobileBrandVO mobileBrandVO= new MobileBrandVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from mobi_brand_table where brand_id=?");
        pstmt.setInt(1, brand_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postMobileBrand(MobileBrandVO mobileBrandVO) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into mobi_brand_table values(?,?)");
                pstmt1.setInt(1,mobileBrandVO.getBrand_id());
                pstmt1.setString(2,mobileBrandVO.getBrand_name());
                pstmt1.execute();
            }
            else{
                System.out.println("Connection Not Found");
            }
        }
        catch(Exception e){
            System.out.println("Message" + e.getMessage());
            e.printStackTrace();
        }
        finally{
            conn.close();
        }
    }
    
}
