/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiConditionVO;
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
public class MobiConditionModel implements MobiCondition{

    
    public ResultVO storeMobiCondInfo(MobiConditionVO mobiCondVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public MobiConditionVO populateMobiCondInfo(String cond_id) {
        MobiConditionVO mobiCondVO= new MobiConditionVO();
        DbConnection dbcon=new DbConnection();
        try{
            if(null!=cond_id){
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from mobi_condition_tab where cond_id= "+cond_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    mobiCondVO.setCond_id(rs1.getString("cond_id"));
                    mobiCondVO.setCond_name(rs1.getString("cond_name"));
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return mobiCondVO;
    }

    
    public ResultVO deleteMobiCondInfo(String cond_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(null!=cond_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from mobi_condition_tab where cond_id= "+cond_id;
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

  
    public MobiConditionVO modifyMobiCondInfo(MobiConditionVO mobiCondVO) {
        if(null!=mobiCondVO){
            String cond_id= mobiCondVO.getCond_id();
            String cond_name= mobiCondVO.getCond_name();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update mobi_condition_tab set cond_name='"+cond_name+"' where cond_id=" + cond_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return mobiCondVO;
    }

  
    public ResultVO searchMobiCondInfo(String cond_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List<MobiConditionVO> viewAllMobiCondInfo() {
        List<MobiConditionVO> listOfMobiCond=new ArrayList<MobiConditionVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from mobi_condition_tab";
            ResultSet rs=st.executeQuery(sqlQuery);
            MobiConditionVO mobiCondVO=null;
            while(rs.next()){
                mobiCondVO=new MobiConditionVO();
                mobiCondVO.setCond_id(rs.getString("cond_id"));
                mobiCondVO.setCond_name(rs.getString("cond_name"));
                listOfMobiCond.add(mobiCondVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfMobiCond;
    }
    
    public boolean checkMobiCondCredential(String cond_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        MobiConditionVO mobiCondVO= new MobiConditionVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from mobi_condition_tab where cond_id=?");
        pstmt.setString(1, cond_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postMobiCond(MobiConditionVO mobiCondVO) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into mobi_condition_tab values(?,?)");
                pstmt1.setString(1,mobiCondVO.getCond_id());
                pstmt1.setString(2,mobiCondVO.getCond_name());
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
