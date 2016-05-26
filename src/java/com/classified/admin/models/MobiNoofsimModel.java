/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiNoofsimVO;
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
public class MobiNoofsimModel implements MobiNoofsim {

    
    public ResultVO storeMobiNoofsimInfo(MobiNoofsimVO mobiNoofsimVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public MobiNoofsimVO populateMobiNoofsimInfo(int noof_id) {
        MobiNoofsimVO mobiNoofsimVO= new MobiNoofsimVO();
        try{
            if(0!=noof_id){
                DbConnection dbcon1=new DbConnection();
                Connection conn=dbcon1.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from mobi_noofsim_tab where noof_id= "+noof_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    mobiNoofsimVO.setNoof_id(rs1.getInt("noof_id"));
                    mobiNoofsimVO.setNoof_name(rs1.getString("noof_name"));                   
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return mobiNoofsimVO;
    }

   
    public ResultVO deleteMobiNoofsimInfo(int noof_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=noof_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from mobi_noofsim_tab where noof_id= "+noof_id;
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

  
    public MobiNoofsimVO modifyMobiNoofsimInfo(MobiNoofsimVO mobiNoofsimVO) {
        if(null!=mobiNoofsimVO){
            int noof_id= mobiNoofsimVO.getNoof_id();
            String noof_name= mobiNoofsimVO.getNoof_name();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update mobi_noofsim_tab set noof_name='"+noof_name+"' where noof_id=" + noof_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return mobiNoofsimVO;
    }

  
    public ResultVO searchMobiNoofsimInfo(int noof_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List<MobiNoofsimVO> viewAllMobiNoofsimInfo() {
        List<MobiNoofsimVO> listOfMobiNoofsim=new ArrayList<MobiNoofsimVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from mobi_noofsim_tab";
            ResultSet rs=st.executeQuery(sqlQuery);
            MobiNoofsimVO mobiNoofsimVO=null;
            while(rs.next()){
                mobiNoofsimVO=new MobiNoofsimVO();
                mobiNoofsimVO.setNoof_id(rs.getInt("noof_id"));
                mobiNoofsimVO.setNoof_name(rs.getString("noof_name"));
                listOfMobiNoofsim.add(mobiNoofsimVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfMobiNoofsim;
    }
    
    public boolean checkMobiNoofsimCredential(int noof_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        MobiNoofsimVO mobiNoofsimVO= new MobiNoofsimVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from mobi_noofsim_tab where noof_id=?");
        pstmt.setInt(1, noof_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postMobiNoofsim(MobiNoofsimVO mobiNoofsimVO) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into mobi_noofsim_tab values(?,?)");
                pstmt1.setInt(1,mobiNoofsimVO.getNoof_id());
                pstmt1.setString(2,mobiNoofsimVO.getNoof_name());
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
