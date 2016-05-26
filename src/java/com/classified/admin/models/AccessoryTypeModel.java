/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.AccessoryTypeVO;
import com.classifiedindia.model.DbConnection;
import com.classified.admin.vo.ResultVO;
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
public class AccessoryTypeModel implements AdminInterface{

    DbConnection dbcon=new DbConnection();

    public List<AccessoryTypeVO> viewAllAccessoryInfo(){
        List<AccessoryTypeVO> listOfAccessoryType=new ArrayList<AccessoryTypeVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from accessories_type_table";
            ResultSet rs=st.executeQuery(sqlQuery);
            AccessoryTypeVO accessoryTypeVO=null;
            while(rs.next()){
                accessoryTypeVO=new AccessoryTypeVO();
                accessoryTypeVO.setAccessory_id(rs.getInt("accessory_id"));
                accessoryTypeVO.setAccessory_name(rs.getString("accessory_name"));
                accessoryTypeVO.setAccess_posting_date(rs.getString("access_posting_date"));
                listOfAccessoryType.add(accessoryTypeVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfAccessoryType;
    }

    public ResultVO storeAccessoryInfo(AccessoryTypeVO accessTypeVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AccessoryTypeVO populateAccessoryInfo(int accessory_id) {
        AccessoryTypeVO accessTypeVO= new AccessoryTypeVO();
        try{
            if(0!=accessory_id){
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from accessories_type_table where accessory_id= "+accessory_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    accessTypeVO.setAccessory_id(rs1.getInt("accessory_id"));
                    accessTypeVO.setAccessory_name(rs1.getString("accessory_name"));
                    accessTypeVO.setAccess_posting_date(rs1.getString("access_posting_date"));
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return accessTypeVO;
    }

    public ResultVO deleteAccessoryInfo(int accessory_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=accessory_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from accessories_type_table where accessory_id= "+accessory_id;
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

    public AccessoryTypeVO modifyAccessoryInfo(AccessoryTypeVO accessTypeVO) {
        if(null!=accessTypeVO){
            int accessory_id= accessTypeVO.getAccessory_id();
            String accessory_name= accessTypeVO.getAccessory_name();
            String access_posting_date= accessTypeVO.getAccess_posting_date();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update accessories_type_table set accessory_name='"+accessory_name+"', access_posting_date= '"+ access_posting_date +"' where accessory_id=" + accessory_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return accessTypeVO;
    }

    public ResultVO searchAccessoryInfo(int accessory_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean checkAccessoryTypeCredential(int accessory_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        AccessoryTypeVO accessTypeVO= new AccessoryTypeVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from accessories_type_table where accessory_id=?");
        pstmt.setInt(1, accessory_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postAccessoryType(AccessoryTypeVO accessTypeVO) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into accessories_type_table values(?,?,?)");
                pstmt1.setInt(1,accessTypeVO.getAccessory_id());
                pstmt1.setString(2,accessTypeVO.getAccessory_name());
                pstmt1.setString(3,accessTypeVO.getAccess_posting_date());
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
