/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiOSTabVO;
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
public class MobiOSTabModel implements MobiOSTab {

   
    public ResultVO storeMobiOSTabInfo(MobiOSTabVO mobiOSTabVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public MobiOSTabVO populateMobiOSTabInfo(int os_id) {
        MobiOSTabVO mobiOSTabVO= new MobiOSTabVO();
        try{
            if(0!=os_id){
                DbConnection dbcon1=new DbConnection();
                Connection conn=dbcon1.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from mobi_os_tab where os_id= "+os_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                if(rs1.next()){
                    mobiOSTabVO.setOs_id(rs1.getInt("os_id"));
                    mobiOSTabVO.setOs_name(rs1.getString("os_name"));               
                    
                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return mobiOSTabVO;
    }

  
    public ResultVO deleteMobiOSTabInfo(int os_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=os_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from mobi_os_tab where os_id= "+os_id;
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

  
    public MobiOSTabVO modifyMobiOSTabInfo(MobiOSTabVO mobiOSTabVO) {
        if(null!=mobiOSTabVO){
            int os_id= mobiOSTabVO.getOs_id();
            String os_name= mobiOSTabVO.getOs_name();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update mobi_os_tab set os_name='"+os_name+"' where os_id=" + os_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return mobiOSTabVO;
    }

  
    public ResultVO searchMobiOSTabInfo(int os_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public List<MobiOSTabVO> viewAllMobiOSTabInfo() {
        List<MobiOSTabVO> listOfMobiOSTab=new ArrayList<MobiOSTabVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from mobi_os_tab";
            ResultSet rs=st.executeQuery(sqlQuery);
            MobiOSTabVO mobiOSTabVO=null;
            while(rs.next()){
                mobiOSTabVO=new MobiOSTabVO();
                mobiOSTabVO.setOs_id(rs.getInt("os_id"));
                mobiOSTabVO.setOs_name(rs.getString("os_name"));
                listOfMobiOSTab.add(mobiOSTabVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfMobiOSTab;
        
    }
    
    public boolean checkMobiOSTabCredential(int os_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        MobiOSTabVO mobiOSTabVO= new MobiOSTabVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from mobi_os_tab where os_id=?");
        pstmt.setInt(1, os_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postMobiOSTab(MobiOSTabVO mobiOSTabVO) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into mobi_os_tab values(?,?)");
                pstmt1.setInt(1,mobiOSTabVO.getOs_id());
                pstmt1.setString(2,mobiOSTabVO.getOs_name());
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
