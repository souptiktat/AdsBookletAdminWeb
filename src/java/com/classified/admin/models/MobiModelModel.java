/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiModelVO;
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
public class MobiModelModel implements MobiModel{

   
    public ResultVO storeMobiModelInfo(MobiModelVO mobiModelVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public MobiModelVO populateMobiModelInfo(int model_id) {
        MobiModelVO mobiModelVO= new MobiModelVO();
        try{
            if(0!=model_id){
                DbConnection dbcon1=new DbConnection();
                Connection conn=dbcon1.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from mobi_model_table where model_id= "+model_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    mobiModelVO.setModel_id(rs1.getInt("model_id"));
                    mobiModelVO.setBrand_id(rs1.getInt("brand_id"));
                    mobiModelVO.setModel_name(rs1.getString("model_name"));
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return mobiModelVO;
    }

  
    public ResultVO deleteMobiModelInfo(int model_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=model_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from mobi_model_table where model_id= "+model_id;
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


    public MobiModelVO modifyMobiModelInfo(MobiModelVO mobiModelVO) {
        if(null!=mobiModelVO){
            int model_id= mobiModelVO.getModel_id();
            int brand_id= mobiModelVO.getBrand_id();
            String model_name= mobiModelVO.getModel_name();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update mobi_model_table set brand_id='"+brand_id+"', model_name= '"+ model_name +"' where model_id=" + model_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return mobiModelVO;
    }

  
    public ResultVO searchMobiModelInfo(int model_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List<MobiModelVO> viewAllMobiModelInfo() {
        List<MobiModelVO> listOfMobiModel=new ArrayList<MobiModelVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from mobi_model_table";
            ResultSet rs=st.executeQuery(sqlQuery);
            MobiModelVO mobiModelVO=null;
            while(rs.next()){
                mobiModelVO=new MobiModelVO();
                mobiModelVO.setModel_id(rs.getInt("model_id"));
                mobiModelVO.setBrand_id(rs.getInt("brand_id"));
                mobiModelVO.setModel_name(rs.getString("model_name"));
                listOfMobiModel.add(mobiModelVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfMobiModel;
    }

    public boolean checkMobiModelCredential(int model_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        MobiModelVO mobiModelVO= new MobiModelVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from mobi_model_table where model_id=?");
        pstmt.setInt(1, model_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postMobiModel(MobiModelVO mobiModelVO) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into mobi_model_table values(?,?,?)");
                pstmt1.setInt(1,mobiModelVO.getModel_id());
                pstmt1.setInt(2,mobiModelVO.getBrand_id());
                pstmt1.setString(3,mobiModelVO.getModel_name());
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
