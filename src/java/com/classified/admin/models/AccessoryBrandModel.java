/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.AccessoryBrandVO;
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
public class AccessoryBrandModel implements AccessoryBrand{
    DbConnection dbcon=new DbConnection();

    
    public ResultVO storeAccessoryInfo(AccessoryBrandVO accessBrandVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AccessoryBrandVO populateAccessoryInfo(int accessry_brand_id) {
        AccessoryBrandVO accessBrandVO= new AccessoryBrandVO();
        try{
            if(0!=accessry_brand_id){
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from accessoty_brand_table where accessry_brand_id= "+accessry_brand_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    accessBrandVO.setAccessry_brand_id(rs1.getInt("accessry_brand_id"));
                    accessBrandVO.setAccessoty_brand_name(rs1.getString("accessoty_brand_name"));
                                        
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return accessBrandVO;
    }

   
    public ResultVO deleteAccessoryInfo(int accessry_brand_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=accessry_brand_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from accessoty_brand_table where accessry_brand_id= "+accessry_brand_id;
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

  
    public AccessoryBrandVO modifyAccessoryInfo(AccessoryBrandVO accessBrandVO) {
        if(null!=accessBrandVO){
            int accessry_brand_id= accessBrandVO.getAccessry_brand_id();
            String accessoty_brand_name= accessBrandVO.getAccessoty_brand_name();            
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update accessoty_brand_table set accessoty_brand_name='"+accessoty_brand_name +"' where accessry_brand_id=" + accessry_brand_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return accessBrandVO;
    }

  
    public ResultVO searchAccessoryInfo(int accessry_brand_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public List<AccessoryBrandVO> viewAllAccessoryInfo() {
        List<AccessoryBrandVO> listOfAccessoryBrand=new ArrayList<AccessoryBrandVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from accessoty_brand_table";
            ResultSet rs=st.executeQuery(sqlQuery);
            AccessoryBrandVO accessoryBrandVO=null;
            while(rs.next()){
                accessoryBrandVO=new AccessoryBrandVO();
                accessoryBrandVO.setAccessry_brand_id(rs.getInt("accessry_brand_id"));
                accessoryBrandVO.setAccessoty_brand_name(rs.getString("accessoty_brand_name"));
                listOfAccessoryBrand.add(accessoryBrandVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfAccessoryBrand;
    }
    
    public boolean checkAccessoryBrandCredential(int accessry_brand_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        AccessoryBrandVO accessBrandVO= new AccessoryBrandVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from accessoty_brand_table where accessry_brand_id=?");
        pstmt.setInt(1, accessry_brand_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postAccessoryBrand(AccessoryBrandVO accessBrandVO) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into accessoty_brand_table values(?,?)");
                pstmt1.setInt(1,accessBrandVO.getAccessry_brand_id());
                pstmt1.setString(2,accessBrandVO.getAccessoty_brand_name());
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
