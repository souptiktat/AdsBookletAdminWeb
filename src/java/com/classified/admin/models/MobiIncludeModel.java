/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classified.admin.models;

import com.classified.admin.vo.MobiIncludeVO;
import com.classified.admin.vo.ResultVO;
import com.classifiedindia.model.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class MobiIncludeModel implements MobiInclude{

    
    public ResultVO storeMobileIncludeInfo(MobiIncludeVO mobiIncludeVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public MobiIncludeVO populateMobileIncludeInfo(int includ_tab_id) {
        MobiIncludeVO mobiIncludeVO= new MobiIncludeVO();
        try{
            if(0!=includ_tab_id){
                DbConnection dbcon=new DbConnection();
                Connection conn=dbcon.dbConnect();
                Statement st2=conn.createStatement();
                String sqlQuery2= "select * from mobi_include_tab where includ_tab_id= "+includ_tab_id;
                System.out.println("Test Query:" +sqlQuery2);
                ResultSet rs1= st2.executeQuery(sqlQuery2);
                ResultSetMetaData rsmd1=rs1.getMetaData();
                if(rs1.next()){
                    mobiIncludeVO.setInclud_tab_id(rs1.getInt("includ_tab_id"));
                    mobiIncludeVO.setMobile_adv_id(rs1.getInt("mobile_adv_id"));
                    mobiIncludeVO.setInclud_id(rs1.getInt("includ_id"));
                    System.out.print("<tr><td>"+rsmd1.getColumnName(1)+"</td><td>"+rsmd1.getColumnName(2)+"</td><td>"+rsmd1.getColumnName(3)+"</td></tr>");

                }
            }
        }
        catch(Exception e){
            e.getMessage();
        }
        return mobiIncludeVO;
    }

    
    public ResultVO deleteMobileIncludeInfo(int includ_tab_id) {
        ResultVO resultVO= new ResultVO();
        try{
            if(0!=includ_tab_id){
                DbConnection dbcon1=new DbConnection();
                Connection con1=dbcon1.dbConnect();
                Statement st1=con1.createStatement();
                String sqlQuery1="delete from mobi_include_tab where includ_tab_id= "+includ_tab_id;
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

    
    public MobiIncludeVO modifyMobileIncludeInfo(MobiIncludeVO mobiIncludeVO) {
        if(null!=mobiIncludeVO){
            int includ_tab_id= mobiIncludeVO.getInclud_tab_id();
            int mobile_adv_id= mobiIncludeVO.getMobile_adv_id();
            int includ_id= mobiIncludeVO.getInclud_id();
            try{
                DbConnection dbcon2= new DbConnection();
                Connection con2= dbcon2.dbConnect();
                Statement st2= con2.createStatement();
                String updateQuery= "update mobi_include_tab set mobile_adv_id='"+mobile_adv_id+"', includ_id= '"+ includ_id +"' where includ_tab_id=" + includ_tab_id;
                System.out.println("Update Query:" + updateQuery);
                int rowsAffected1=st2.executeUpdate(updateQuery);
                if(rowsAffected1 > 0){
                    
                }
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        return mobiIncludeVO;
    }

    
    public ResultVO searchMobileIncludeInfo(int includ_tab_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<MobiIncludeVO> viewAllMobileIncludeInfo() {
        List<MobiIncludeVO> listOfMobiIncludes=new ArrayList<MobiIncludeVO>();
        try{
            DbConnection dbcon=new DbConnection();
            Connection con=dbcon.dbConnect();
            Statement st=con.createStatement();
            String sqlQuery="select * from mobi_include_tab";
            ResultSet rs=st.executeQuery(sqlQuery);
            ResultSetMetaData rsmd=rs.getMetaData();
            MobiIncludeVO mobiIncludeVO=null;
            while(rs.next()){
                mobiIncludeVO=new MobiIncludeVO();
                mobiIncludeVO.setInclud_tab_id(rs.getInt("includ_tab_id"));
                mobiIncludeVO.setMobile_adv_id(rs.getInt("mobile_adv_id"));
                mobiIncludeVO.setInclud_id(rs.getInt("includ_id"));
                System.out.print("<tr><td>"+rsmd.getColumnName(1)+"</td><td>"+rsmd.getColumnName(2)+"</td><td>"+rsmd.getColumnName(3)+"</td></tr>");
                listOfMobiIncludes.add(mobiIncludeVO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listOfMobiIncludes;
    }
    
    public boolean checkMobileIncludeCredential(int includ_tab_id) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean status=false;
        MobiIncludeVO mobiIncludeVO= new MobiIncludeVO();
        DbConnection dbcon= new DbConnection();
        conn= dbcon.dbConnect();
        pstmt=conn.prepareStatement("select * from mobi_include_tab where includ_tab_id=?");
        pstmt.setInt(1, includ_tab_id);
        rs= pstmt.executeQuery();
        while(rs.next()){
            status= true;
        }
        pstmt.close();
        conn.close();
        return status;
    }
    
    public void postMobileInclude(MobiIncludeVO mobiIncludeVO) throws SQLException{
        Connection conn=null;
        PreparedStatement pstmt1= null;
        
        try{
            DbConnection dbcon=new DbConnection();
            conn= dbcon.dbConnect();
            System.out.println("Connection Established");
            if(null!=conn){
                pstmt1=conn.prepareStatement("insert into mobi_include_tab values(?,?,?)");
                pstmt1.setInt(1,mobiIncludeVO.getInclud_tab_id());
                pstmt1.setInt(2,mobiIncludeVO.getMobile_adv_id());
                pstmt1.setInt(3,mobiIncludeVO.getInclud_id());
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
